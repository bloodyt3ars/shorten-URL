package com.example.shorten_url.repository;

import com.example.shorten_url.model.Url;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UrlRepository extends JpaRepository<Url, Long> {
    public boolean existsUrlByLongUrl(String longUrl);
    public Url getUrlByLongUrl(String longUrl);

    public Url getUrlByToken(String token);
}
