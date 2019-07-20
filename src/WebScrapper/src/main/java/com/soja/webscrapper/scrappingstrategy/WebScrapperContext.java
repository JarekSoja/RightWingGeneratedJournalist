package com.soja.webscrapper.scrappingstrategy;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class WebScrapperContext {

    public void scrapeSingleWebsite(ScrappingStrategy strategy) {
            strategy.scrape();
    }

    public enum Source {
        W_SIECI,
        TYGODNIK_SOLIDARNOSC,
        W_POLITYCE
    }
}
