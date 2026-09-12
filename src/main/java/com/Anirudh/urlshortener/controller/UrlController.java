package com.Anirudh.urlshortener.controller;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/api/urls")
public class UrlController {
    @PostMapping public String createShortUrl(@RequestBody String longUrl) {
         return "short-url";
    }
}
