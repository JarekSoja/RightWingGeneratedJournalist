package com.soja.webscrapper.scrappingstrategy.impl;

import com.soja.webscrapper.scrappingstrategy.ScrappingStrategy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class WPolityceScrappingStrategy implements ScrappingStrategy {

    private final String BASE_ADDRESS = "https://wpolityce.pl/";
    private final String SINGLE_PAGE_ACCESSOR_CLASS = "nu-widget-article-list__link";
    private final String SINGLE_PAGE_ACCESSOR_CLASS_2 = "nu-tile__link";

    @Override
    public void scrape() {

        Document document;

        //TODO Krok 1: Pozyskanie adresów http poszczególnych artykułów
        //TODO Krok 2: Iteracja po adresach pozyskanych wyżej
        //TODO Krok 3: Scrapping każego z adresów
        //TODO Krok 4: Persystencja

        try {
            document = Jsoup.connect(BASE_ADDRESS).timeout(6000).get();
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        System.out.println(document.title());

        Elements articleAddresses = document.getElementsByClass(SINGLE_PAGE_ACCESSOR_CLASS);
        Elements articleAddresses2 = document.getElementsByTag(SINGLE_PAGE_ACCESSOR_CLASS_2);

            for (Element e : articleAddresses) {
                try {
                    System.out.println(e);
                    Document tabDocument = Jsoup.connect(e.text()).get();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
    }
}
