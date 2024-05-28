package vip.dengwj.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Map;

@Data
@Component
@ConfigurationProperties(prefix = "myjwt")
public class JWTUtils {
    private String token;
    private Long expiration;

    /**
     * 生成 jwt
     *
     * @param claims
     * @return
     */
    public String generateToken(Map<String, Object> claims) {
        String jwt = Jwts.builder()
            .signWith(SignatureAlgorithm.HS256, token)
            .setClaims(claims)
            .setExpiration(new Date(System.currentTimeMillis() + expiration))
            .compact();

        return jwt;
    }

    /**
     * 解析 jwt
     */
    public Map<String, Object> parseToken(String jwt) {
        Claims body = Jwts.parser()
            .setSigningKey(token)
            .parseClaimsJws(jwt)
            .getBody();
        return body;
    }
}
