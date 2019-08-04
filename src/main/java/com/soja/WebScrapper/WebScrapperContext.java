package com.soja.WebScrapper;

import com.soja.WebScrapper.ScrappingStrategy;
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
