package com.soja.WebScrapper.scrappingstrategy;

import org.springframework.stereotype.Component;

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
