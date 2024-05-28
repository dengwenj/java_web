package vip.dengwj;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

//@SpringBootTest
class TliasApplicationTests {

    @Test
    void contextLoads() {
    }

    /**
     * 生成 JWT 令牌
     */
    @Test
    public void gJWT() {
        Map<String, Object> map = new HashMap<>();
        map.put("id", 1);
        map.put("name", "朴睦");

        String jwt = Jwts.builder()
            .signWith(SignatureAlgorithm.HS256, "pumuww") // 签名算法，pumuww(秘钥)
            .setClaims(map) // 自定义载荷
            .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60)) // 一小时
            .compact();
        System.out.println(jwt);
        parseJWT(jwt);// eyJhbGciOiJIUzI1NiJ9.eyJuYW1lIjoi5py0552mIiwiaWQiOjEsImV4cCI6MTcxNjYzNDc4Nn0.5cFjPofoPDMozk2mppFS9JaypPMJi3Zenrc4d4ePytU
    }

    /**
     * 解析 JWT 令牌
     */
    public void parseJWT(String jwt) {
        Claims data = Jwts.parser()
            .setSigningKey("pumuww") // 秘钥
            .parseClaimsJws(jwt)
            .getBody();
        System.out.println(data + "ww");
    }
}
