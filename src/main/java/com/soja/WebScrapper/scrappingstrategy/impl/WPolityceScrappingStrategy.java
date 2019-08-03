package com.soja.WebScrapper.scrappingstrategy.impl;

import com.soja.Persistor.Persistor;
import com.soja.WebScrapper.scrappingstrategy.ScrappingStrategy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.TextNode;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class WPolityceScrappingStrategy implements ScrappingStrategy {

    private final String BASE_ADDRESS = "https://wpolityce.pl/";
    private final String ADDRESS_TO_BUILD = "https://wpolityce.pl";

    private Persistor persistor = new Persistor();

    @Override
    public void scrape() {

        List<String> articleAddresses = getArticleAddresses();
        persistor.persistLinks(articleAddresses);

        for (String address : articleAddresses) {
            Optional<Document> optionalDocument = Optional.ofNullable(getArticleContent(address));

            if (optionalDocument.isPresent()) {
                Document doc = optionalDocument.get();
                Elements textElements = doc.getElementsByTag("article");
                for (Element e : textElements) {
                    List<TextNode> textNodes = e.textNodes();
                    for (TextNode t : textNodes) {
                        System.out.println(t.toString());
                    }
                }
            }
        }

        //TODO Krok 1: Pozyskanie adresów http poszczególnych artykułów
        //TODO Krok 2: Iteracja po adresach pozyskanych wyżej
        //TODO Krok 3: Scrapping każego z adresów
        //TODO Krok 4: Persystencja
    }

    private List<String> getArticleAddresses() {
        Document document;
        List<String> result = new ArrayList<>();
        try {
            document = Jsoup.connect(BASE_ADDRESS).timeout(60000).get();
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
        Elements elements = document.getElementsByTag("a");
        for (Element e : elements) {
            String temp = e.attr("href").toString();
            if (temp.startsWith("/polityka") && temp.length() > 9) {
                result.add(ADDRESS_TO_BUILD + temp);
            }
        }
        return result;
    }

    private Document getArticleContent(String address) {
        try {
            return Jsoup.connect(address).timeout(6000).get();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

}
