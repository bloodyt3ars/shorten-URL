package com.example.shorten_url.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Entity
@Table(name = "url")
public class Url {
    @Id
    private Long id;
    @Column(name = "long_url")
    String longUrl;
    @Column(name = "token")
    String token;
    LocalDateTime createdAt;
    LocalDateTime expiryAt;

    public Url() {
    }

    public Url(Long id, String longUrl, String token, LocalDateTime createdAt, LocalDateTime expiryAt) {
        this.id = id;
        this.longUrl = longUrl;
        this.token = token;
        this.createdAt = createdAt;
        this.expiryAt = expiryAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLongUrl() {
        return longUrl;
    }

    public void setLongUrl(String longUrl) {
        this.longUrl = longUrl;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getExpiryAt() {
        return expiryAt;
    }

    public void setExpiryAt(LocalDateTime expiryAt) {
        this.expiryAt = expiryAt;
    }
}
