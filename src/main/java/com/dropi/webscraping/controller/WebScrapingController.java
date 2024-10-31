package com.dropi.webscraping.controller;

import com.dropi.webscraping.service.WebScrapingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebScrapingController {

    private final WebScrapingService webScrapingService;

    @Autowired
    public WebScrapingController(WebScrapingService webScrapingService) {
        this.webScrapingService = webScrapingService;
    }

    @GetMapping("/scrape")
    public String scrape(@RequestParam String url) {
        webScrapingService.scrape(url);
        return "Scraping started for URL: " + url;
    }
}
