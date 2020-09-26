package com.eshop.Eshop.security;

import io.jsonwebtoken.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.time.LocalDateTime;
import java.time.ZoneId;

@Component
@Slf4j
public class JwtTokenProvider {

    @Value("${app.jwtSecret}")
    private String jwtSecret;

    @Value("${app.jwtExpirationInHours}")
    private long jwtExpirationInHours;

    public String generateToken(Authentication authentication) {
        UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime expiryDate = LocalDateTime.now().plusHours(jwtExpirationInHours);
        return Jwts.builder()
                .setSubject(userPrincipal.getId())
                .setIssuedAt(Date.from(now.atZone(ZoneId.systemDefault()).toInstant()))
                .setExpiration(Date.from(expiryDate.atZone(ZoneId.systemDefault()).toInstant()))
                .signWith(SignatureAlgorithm.HS512, jwtSecret)
                .compact();
    }

    public String getUserIdFromJWT(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(jwtSecret)
                .parseClaimsJws(token)
                .getBody();
        return claims.getSubject();
    }

    public boolean validateToken(String authToken) {
        try {
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);
            return true;
        } catch (MalformedJwtException ex) {
            log.info("Invalid JWT token");
        } catch (ExpiredJwtException ex) {
            log.info("Expired JWT token");
        } catch (UnsupportedJwtException ex) {
            log.info("Unsupported JWT token");
        } catch (IllegalArgumentException ex) {
            log.info("JWT claims string is empty.");
        }
        return false;
    }
}
