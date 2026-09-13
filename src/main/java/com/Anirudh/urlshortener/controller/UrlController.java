package com.Anirudh.urlshortener.controller;
import com.Anirudh.urlshortener.service.UrlService;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/api/urls")

public class UrlController {
    private final UrlService urlService;
    private UrlController(UrlService urlservice){
        this.urlService = urlservice;
    }
    @PostMapping
    public String createShortUrl(@RequestBody String longURL){
        String shortul = urlService.generateShortCode(longURL);
        return shortul;
    }
    @GetMapping("/{shortCode}")
    public String redirect(@PathVariable String shortCode){
        return urlService.getLongUrl(shortCode);
    }
}
