package com.soja.Persistor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Blob;
import java.time.LocalDate;

@Entity
@Table(name = "ARTICLES")
public class ScrappedArticle {

    private int id;
    private Blob articleText;
    private String articleLead;
    private LocalDate dateOfScrapping;

    public ScrappedArticle() {
    }

    public ScrappedArticle(int id, Blob articleText, String articleLead, LocalDate dateOfScrapping) {
        this.id = id;
        this.articleText = articleText;
        this.articleLead = articleLead;
        this.dateOfScrapping = dateOfScrapping;
    }

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "ID", unique = true)
    public int getId() {
        return id;
    }

    @Column(name = "TEXT")
    public Blob getArticleText() { return articleText; }

    @Column(name = "LEAD")
    public String getArticleLead() {
        return articleLead;
    }

    @Column(name = "SCRAPPING_DATE")
    public LocalDate getDateOfScrapping() {
        return dateOfScrapping;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setArticleText(Blob articleText) {
        this.articleText = articleText;
    }

    public void setArticleLead(String articleLead) {
        this.articleLead = articleLead;
    }

    public void setDateOfScrapping(LocalDate dateOfScrapping) {
        this.dateOfScrapping = dateOfScrapping;
    }
}
