package com.soja.Persistor.dto;

import java.sql.Blob;
import java.time.LocalDate;

public class ScrappedArticleDto {

    private Blob articleText;
    private String articleLead;
    private LocalDate dateOfScrapping;
    private String url;

    public ScrappedArticleDto(Blob articleText, String articleLead, LocalDate dateOfScrapping, String url) {
        this.articleText = articleText;
        this.articleLead = articleLead;
        this.dateOfScrapping = dateOfScrapping;
        this.url = url;
    }

    public Blob getArticleText() {
        return articleText;
    }

    public void setArticleText(Blob articleText) {
        this.articleText = articleText;
    }

    public String getArticleLead() {
        return articleLead;
    }

    public void setArticleLead(String articleLead) {
        this.articleLead = articleLead;
    }

    public LocalDate getDateOfScrapping() {
        return dateOfScrapping;
    }

    public void setDateOfScrapping(LocalDate dateOfScrapping) {
        this.dateOfScrapping = dateOfScrapping;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
