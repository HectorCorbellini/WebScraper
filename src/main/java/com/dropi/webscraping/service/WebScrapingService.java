package com.dropi.webscraping.service;

import com.dropi.webscraping.model.ScrapedData;
import com.dropi.webscraping.repository.WebScrapingRepository;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class WebScrapingService {

    private final WebScrapingRepository webScrapingRepository;

    @Autowired
    public WebScrapingService(WebScrapingRepository webScrapingRepository) {
        this.webScrapingRepository = webScrapingRepository;
    }

    public void scrape(String url) {
        try {
            // Fetch and parse the HTML document from the URL
            Document document = Jsoup.connect(url).get();
            String title = document.title();
            String description = document.select("meta[name=description]").attr("content");

            // Save scraped data to the database
            ScrapedData data = new ScrapedData();
            data.setTitle(title);
            data.setDescription(description);

            webScrapingRepository.save(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
