package com.example.BusStation.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtUtills {

    @Value("${jwt.secret}")
    private String jwtSecret;

    @Value("${jwt.expiration}")
    private long jwtExpiration;

    public String generateJwtToken(Authentication authentication) {
        UserDetails userPricipal = (UserDetails) authentication.getPrincipal();
        Map<String, String> claims = new HashMap<String, String>();
        claims.put("role", userPricipal.getAuthorities().stream().findFirst().get().getAuthority());
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(userPricipal.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date(new Date().getTime() + jwtExpiration))
                .signWith(SignatureAlgorithm.HS256, jwtSecret)
                .compact();
    }

    public Key key() {
        return Keys.hmacShaKeyFor(Decoders.BASE64.decode(jwtSecret));
    }

    public boolean validateJwtToken(String authtoken) {
        try {
            Jwts.parserBuilder().setSigningKey(key()).build().parse(authtoken);
            return true;
        } catch (Exception e) {
        }
        return false;
    }

    public String getUsernameFromJwtToken(String authtoken) {
        return Jwts.parserBuilder().setSigningKey(key()).build().parseClaimsJws(authtoken).getBody().getSubject();
    }
}
