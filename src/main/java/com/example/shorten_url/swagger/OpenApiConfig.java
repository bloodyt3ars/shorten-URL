package com.example.shorten_url.swagger;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(
        info = @Info(
                title = "Pet проект",
                description = "Приложение, которое позволяет укоротить ссылку", version = "1.0.0",
                contact = @Contact(
                        name = "Antonov Vladimir",
                        url = "https://t.me/bloodyt3ars"
                )
        )
)
public class OpenApiConfig {
}