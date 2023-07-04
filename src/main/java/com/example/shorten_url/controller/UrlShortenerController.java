package com.example.shorten_url.controller;

import com.example.shorten_url.component.UrlShortenerService;
import com.example.shorten_url.model.Url;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@RestController
@RequestMapping("/api/v1/urls")
@Tag(name="urls", description="В этом разделе находятся методы, которые позволяют сокращать ссылку и делать обратное преобразование")
public class UrlShortenerController {


    private final UrlShortenerService urlService;

    public UrlShortenerController(UrlShortenerService urlService) {
        this.urlService = urlService;
    }

    @PostMapping("")
    @Operation(
            summary = "Получение короткого токена",
            description = "Пользователь получает короткий токен",
            operationId = "createShortUrl",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Нужно передать ссылку, которую хотите сократить",
                    required = true,
                    content = @Content(
                            schema = @Schema(type = "string"),
                            examples = {@ExampleObject(name = "ссылка", value = "https://github.com/bloodyt3ars")}
                    )
            )
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Successful operation",
                    content = @Content(schema = @Schema(implementation = Url.class)))
    })
    public ResponseEntity<?> createShortUrl(@RequestBody
                                                String longUrl){
        Url url = urlService.getToken(longUrl);
        return new ResponseEntity<>(url.toString(), HttpStatus.OK);
    }

    @GetMapping("/{token}")
    @Operation(
            summary = "Перенаправление пользователя на url",
            description = "Пользователь перенаправляется на url",
            operationId = "redirectToLongUrl"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation"),
            @ApiResponse(responseCode = "404", description = "not found")
    })
    public ResponseEntity<?> redirectToLongUrl(@PathVariable
                                                   @Parameter(
                                                           description = "Нужно передать короткий токен",
                                                           example = "o03dfuza"
                                                   )
                                                   String token){
        Url longUrl = urlService.getLongUrl(token);
        if (longUrl != null) {
            RedirectView redirectView = new RedirectView();
            redirectView.setUrl(longUrl.getLongUrl());
            return ResponseEntity.status(HttpStatus.FOUND).header(HttpHeaders.LOCATION, longUrl.getLongUrl())
                    .build();
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
