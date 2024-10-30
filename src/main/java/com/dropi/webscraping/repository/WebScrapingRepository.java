package com.dropi.webscraping.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.dropi.webscraping.model.ScrapedData;

public interface WebScrapingRepository extends JpaRepository<ScrapedData, Long> {
}
