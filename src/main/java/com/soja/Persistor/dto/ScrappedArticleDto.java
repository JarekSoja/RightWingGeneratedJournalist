package com.soja.Persistor.dto;

import java.sql.Blob;
import java.time.LocalDate;

public class ScrappedArticleDto {

    private int id;
    private Blob articleText;
    private String articleLead;
    private LocalDate dateOfScrapping;

    public ScrappedArticleDto(int id, Blob articleText, String articleLead, LocalDate dateOfScrapping) {
        this.id = id;
        this.articleText = articleText;
        this.articleLead = articleLead;
        this.dateOfScrapping = dateOfScrapping;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
}
