package com.example.auth_service.config;

import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtService {

    // Secret key - secure place (env var, config server etc.)
    private static final String SECRET_KEY = "4B6250655368566D5970337336763979244226452948404D635166546A576E5A";

    // Username extract
    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    // General claim extractor
    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    // Token generate karna (with extra claims)
    public String generateToken(Map<String, Object> extraClaims, UserDetails userDetails) {
        return Jwts
                .builder()
                .setClaims(extraClaims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24)) // 1 din
                .signWith(getSignInKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    // Simple token generate (without extra claims)
    public String generateToken(UserDetails userDetails) {
        return generateToken(new HashMap<>(), userDetails);
    }

    // Token valid or not
    public boolean isTokenValid(String token, UserDetails userDetails) {
        final String username = extractUsername(token);
        return username.equals(userDetails.getUsername()) && !isTokenExpired(token);
    }

    // Token expire or not
    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    // find token expire date
    private Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    // finding all claims extract
    private Claims extractAllClaims(String token) {
        return Jwts
                .parserBuilder()
                .setSigningKey(getSignInKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    // Secret key  decode and  signing key generate
    private Key getSignInKey() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
