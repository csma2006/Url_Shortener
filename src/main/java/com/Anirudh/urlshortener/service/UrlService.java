package com.Anirudh.urlshortener.service;
import com.Anirudh.urlshortener.model.UrlMapping;
import com.Anirudh.urlshortener.repository.UrlMappingRepository;
import org.springframework.stereotype.Service;

import java.util.*;
import java.lang.String;

@Service
public class UrlService {
      private final UrlMappingRepository repository;
      public UrlService(UrlMappingRepository repository){
          this.repository = repository;
      }
      private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890abcdefghijklmnopqrstuvwxyz";
      public String generateShortCode(String longUrl){
          Random random = new Random();
          StringBuilder sb = new StringBuilder();
          for(int i=0;i<5;i++){
              int index = random.nextInt(CHARACTERS.length());
              sb.append(CHARACTERS.charAt(index));
          }
          String shortcode = sb.toString();
          UrlMapping mapping = new UrlMapping();
          mapping.setShortCode(shortcode);
          mapping.setLongUrl(longUrl);
          repository.save(mapping);
          return shortcode;
      }
      public String getLongUrl(String shortCode) {
        UrlMapping mapping = repository.findByShortCode(shortCode);
        return mapping.getLongUrl();
        }

}


