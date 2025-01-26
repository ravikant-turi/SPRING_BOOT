package com.example.spsecurity.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.*;
import java.util.function.Function;

@Service
@Component
public class JwtService {


    String secretKey="";
    JwtService() throws NoSuchAlgorithmException {
        KeyGenerator keyGenerator=KeyGenerator.getInstance("HmacSha256");
        SecretKey secretKey1=keyGenerator.generateKey();
        secretKey   =Base64.getEncoder().encodeToString(secretKey1.getEncoded());
    }

    public String generateToken(String username) {
        Map<String, Object> claims = new HashMap<>(); // Corrected type


        return Jwts
                .builder()
                .setClaims(claims) // Adding all claims (empty or with custom claims)
                .setSubject(username) // Setting the subject (user identifier)
                .setIssuedAt(new Date(System.currentTimeMillis())) // Token issuance time
                .setExpiration(new Date(System.currentTimeMillis() + 60 * 60 * 1000)) // 1-hour expiration
                .signWith(getKey()) // Signing the token
                .compact();
    }


    private Key getKey() {
        byte []bytesKey= Decoders.BASE64.decode(secretKey);
        return Keys.hmacShaKeyFor(bytesKey);
    }






    public String extractUserName(String token) {

        return extractClaim(token, Claims::getSubject);
    }
    private <T>T extractClaim(String token, Function<Claims,T> claimResolver){
        final Claims claims=extractAllClaims(token);
        System.out.println("calaims  of allClaim extraction "+ claims);
        return claimResolver.apply(claims);
    }
    private  Claims  extractAllClaims(String token){

        return  Jwts.parserBuilder()
                .setSigningKey(getKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
    public boolean validatetoken(String token, UserDetails userDetails) {
               final String userName=extractUserName(token);
        System.out.println("valideate  is : " + userName.equals(userDetails.getUsername()) + "istokentExpired" + isTokentExpired((token)));
               return (userName.equals(userDetails.getUsername())&& !isTokentExpired(token));
    }
    public boolean isTokentExpired(String token){
        return  extractExpiration(token).before(new Date());
    }
    private  Date extractExpiration(String token){
         return  extractClaim(token,Claims::getExpiration);
    }



}
