package com.soja.webscrapper.scrappingstrategy;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class WebScrapperContext {

    public void scrapeTargetWebsite(ScrappingData.Source source) {

        ScrappingData data = ScrappingData.buildScrappingData(source);

        try {
            Document document = Jsoup.connect(data.getBaseAddress()).get();
            System.out.printf("Title: %s\n", document.title());

            String texts = document.getElementsByClass("publication-link").text();

            Elements tabAdresses = document.getElementsByClass(data.getTabClass());

            for (Element e : tabAdresses) {
                Document tabDocument = Jsoup.connect(e.text()).get();
                System.out.printf("Title: %s\n", tabDocument.title());
                System.out.printf("Title: %s\n", tabDocument.title());
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
