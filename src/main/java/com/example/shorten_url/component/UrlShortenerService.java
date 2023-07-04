package com.example.shorten_url.component;

import com.example.shorten_url.model.Url;
import com.example.shorten_url.repository.UrlRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UrlShortenerService {


    private final UrlRepository urlRepository;

    public UrlShortenerService(UrlRepository urlRepository) {
        this.urlRepository = urlRepository;
    }

    private Url createToken(String longUrl){
            String token = Tokenizer.encode(longUrl);
            LocalDateTime createdAt = LocalDateTime.now();
            LocalDateTime expiryAt = createdAt.plusHours(24);
            Url url = new Url();
            url.setToken(token);
            url.setLongUrl(longUrl);
            url.setCreatedAt(createdAt);
            url.setExpiryAt(expiryAt);
            urlRepository.save(url);
            return url;
    }

    public Url getToken(String longUrl){
        if (checkIfExists(longUrl)){
            Url url = urlRepository.getUrlByLongUrl(longUrl);
            return url;
        }
        else {
            Url url = createToken(longUrl);
            return url;
        }
    }
    public Url getLongUrl(String token){
        Url url = urlRepository.getUrlByToken(token);
        if (url != null) {
            return url;
        }
        return null;
    }

    private boolean checkIfExists(String url){
        return urlRepository.existsUrlByLongUrl(url);
    }
}
