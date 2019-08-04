package com.soja.Persistor.mapper;

import com.soja.Persistor.ScrappedArticle;
import com.soja.Persistor.dto.ScrappedArticleDto;
import com.soja.WebScrapper.scrappingstrategy.impl.WPolityceScrappingStrategy;
import org.hibernate.Hibernate;

import javax.sql.rowset.serial.SerialBlob;
import java.sql.Blob;
import java.sql.SQLException;

public class ScrappedArticleMapper {

    public ScrappedArticle mapToScrappedArticle(final ScrappedArticleDto scrappedArticleDto) {
        return new ScrappedArticle(
                scrappedArticleDto.getArticleText(),
                scrappedArticleDto.getArticleLead(),
                scrappedArticleDto.getDateOfScrapping(),
                scrappedArticleDto.getUrl()
        );
    }

    public ScrappedArticleDto mapToScrappedArticle(final ScrappedArticle scrappedArticle) {
        return new ScrappedArticleDto(
                scrappedArticle.getArticleText(),
                scrappedArticle.getArticleLead(),
                scrappedArticle.getDateOfScrapping(),
                scrappedArticle.getUrl()
        );
    }

    public ScrappedArticle mapToScrappedArticle(final WPolityceScrappingStrategy.ArticleToPersist articleToPersist) {
        return new ScrappedArticle(
                convertFromString(articleToPersist.getArticleText()),
                articleToPersist.getArticleHeader(),
                articleToPersist.getDateOfScrapping(),
                articleToPersist.getUrl()
        );
    }

    private Blob convertFromString(String toConvert) {
        try {
            Blob b = new SerialBlob(toConvert.getBytes());
            return b;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

}
