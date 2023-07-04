package com.example.shorten_url.component;

import org.springframework.stereotype.Component;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Component
public class Tokenizer {
    private static final String CHARACTERS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final int TOKEN_LENGTH = 6;
    private static final String HASH_ALGORITHM = "MD5";

    //private static Map<String, String> tokenToURLMap = new HashMap<>();

    public static String encode(String url) {
        String token = generateToken();
        String hashedToken = hashToken(token);
        //tokenToURLMap.put(hashedToken, url);
        return hashedToken;
    }

/*    public static String decode(String token) {
        return tokenToURLMap.get(token);
    }*/

    private static String generateToken() {
        Random random = new Random();
        StringBuilder tokenBuilder = new StringBuilder();

        for (int i = 0; i < TOKEN_LENGTH; i++) {
            int index = random.nextInt(CHARACTERS.length());
            char randomChar = CHARACTERS.charAt(index);
            tokenBuilder.append(randomChar);
        }
        return tokenBuilder.toString();
    }

    private static String hashToken(String token) {
        try {
            MessageDigest md = MessageDigest.getInstance(HASH_ALGORITHM);
            byte[] tokenBytes = token.getBytes();
            byte[] hashBytes = md.digest(tokenBytes);
            return Base64.getUrlEncoder().withoutPadding().encodeToString(hashBytes).substring(0,8);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }
}
