package com.soja.WebScrapper.scrappingstrategy.impl;

import com.soja.Persistor.PersistorController;
import com.soja.WebScrapper.scrappingstrategy.ScrappingStrategy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class WPolityceScrappingStrategy implements ScrappingStrategy {


    //TODO Krok 1: Pozyskanie adresów http poszczególnych artykułów  ZROBIONE
    //TODO Krok 2: Iteracja po adresach pozyskanych wyżej  ZROBIONE
    //TODO Krok 3: Scrapping każego z adresów  ZROBIONE
    //TODO Krok 4: Persystencja
    //TODO Krok 5: Rozbudowanie całości o scrapping innych kategorii poprzez wyodrębnienie ustawień podkategorii,
    // które w tej chwili są hardkodowane w constructArticleToPersist()

    private final String BASE_ADDRESS = "https://wpolityce.pl/";

    private PersistorController persistorController = new PersistorController();

    @Override
    public void scrape() {

        List<String> articleAddresses = getArticleAddresses();

        for (String address : articleAddresses) {
            ArticleToPersist articleToPersist = constructArticleToPersist(address);
            persistorController.persist(articleToPersist);
        }
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
            String temp = e.attr("href");
            if (temp.startsWith("/polityka") && temp.length() > 9) {
                result.add(BASE_ADDRESS + temp);
            }
        }
        return result;
    }

    private ArticleToPersist constructArticleToPersist(String address) {

        Optional<Document> optionalDocument = Optional.ofNullable(getJSoupDOcumentOutOfSingleArticle(address));
        ArticleToPersist result = new ArticleToPersist();

        if (optionalDocument.isPresent()) {
            Document document = optionalDocument.get();
            Elements articleBody = document.getElementsByClass("articleBody-body");
            Elements articleHeader = document.getElementsByTag("header");
            String article = articleBody.get(0).text();
            String header = articleHeader.get(2).text();

            result.setUrl(address);
            result.setArticleHeader(header);
            result.setArticleText(article);
            result.setDateOfScrapping(LocalDate.now());
        }
        return result;
    }

    private Document getJSoupDOcumentOutOfSingleArticle(String address) {
        try {
            return Jsoup.connect(address).timeout(6000).get();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static class ArticleToPersist {

        private LocalDate dateOfScrapping;
        private String url;
        private String articleText;
        private String articleHeader;

        public LocalDate getDateOfScrapping() {
            return dateOfScrapping;
        }

        private void setDateOfScrapping(LocalDate dateOfScrapping) {
            this.dateOfScrapping = dateOfScrapping;
        }

        public String getUrl() {
            return url;
        }

        private void setUrl(String url) {
            this.url = url;
        }

        public String getArticleText() {
            return articleText;
        }

        private void setArticleText(String articleText) {
            this.articleText = articleText;
        }

        public String getArticleHeader() {
            return articleHeader;
        }

        private void setArticleHeader(String articleHeader) {
            this.articleHeader = articleHeader;
        }
    }
}
