package com.example.shorten_url.model;

import jakarta.persistence.*;
import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


@Entity
@Table(name = "url")
@Schema(description = "Сущность URL")
public class Url {
    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    @Schema(description = "id", example = "1")
    private Long id;

    @Schema(description = "Исходная ссылка", example = "https://github.com/bloodyt3ars")
    private String longUrl;
    @Schema(description = "Полученный токен", example = "o03dfuza")
    private String token;
    @Schema(description = "Создан", example = "2023-07-04 15:27:16")
    private LocalDateTime createdAt;
    @Schema(description = "Истекает", example = "2023-07-05 15:27:16")
    private LocalDateTime expiryAt;

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

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return "Url{" +
                "id=" + id +
                ", longUrl='" + longUrl + '\'' +
                ", token='" + token + '\'' +
                ", createdAt=" + createdAt.format(formatter) +
                ", expiryAt=" + expiryAt.format(formatter) +
                '}';
    }
}
