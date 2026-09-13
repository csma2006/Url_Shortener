package com.Anirudh.urlshortener.repository;

import com.Anirudh.urlshortener.model.UrlMapping;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UrlMappingRepository extends JpaRepository<UrlMapping,Long> {
    UrlMapping findByShortCode(String shortcode);
}
