package com.teamh.hiserver.auth.util;

import com.teamh.hiserver.user.repository.UserRepository;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Base64;
import java.util.Date;

@Component
@Slf4j(topic = "JwtUtil")
public class JwtUtil implements InitializingBean {
    public static final String AUTHORIZATION_HEADER = "AccessToken";
    public static final String BEARER_PREFIX = "Bearer ";
    private static final long ATK_TIME = 1000L * 60 * 60;

    @Value("${jwt.secret.key}")
    private String secretKey;

    private Key key;

    private final UserRepository userRepository;

    public JwtUtil(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public void afterPropertiesSet() {
        byte[] keyBytes = Base64.getDecoder().decode(secretKey);
        this.key = Keys.hmacShaKeyFor(keyBytes);
    }
    public String createAccessToken(String username) {
        return BEARER_PREFIX +
                Jwts.builder()
                        .subject(username)
                        .expiration(new Date(System.currentTimeMillis() + ATK_TIME))
                        .issuedAt(new Date(System.currentTimeMillis()))
                        .signWith(key)
                        .compact();
    }
    public void addJwtToCookie(String userInfo, HttpServletResponse response) throws UnsupportedEncodingException {
        String token = createAccessToken(userInfo);
        token = URLEncoder.encode(token, StandardCharsets.UTF_8).replaceAll("\\+", "%20");
        Cookie cookie = new Cookie(AUTHORIZATION_HEADER, token);
        cookie.setPath("/");
        response.addCookie(cookie);
    }

    public void validateToken(String token){
        String subToken= token.substring(8);
        System.out.println("subToken = " + subToken);
    }

    public String getUser(String token){
       return token.substring(8);
    }
}
