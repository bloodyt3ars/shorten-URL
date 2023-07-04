package com.example.shorten_url.component;

import com.example.shorten_url.model.Url;
import com.example.shorten_url.repository.UrlRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class TokenExpirationChecker {

    private final UrlRepository urlRepository;

    public TokenExpirationChecker(UrlRepository urlRepository) {
        this.urlRepository = urlRepository;
    }


    @Scheduled(fixedRate = 3600000)
    public void checkTokenExpiration() {
        LocalDateTime now = LocalDateTime.now();
        List<Url> urls = urlRepository.findAll();
        for (Url url:urls) {
            if (now.compareTo(url.getExpiryAt())>0) {
                urlRepository.delete(url);
            }
        }
    }
}
