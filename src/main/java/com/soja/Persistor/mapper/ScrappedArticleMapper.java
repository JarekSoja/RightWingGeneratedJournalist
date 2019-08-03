package com.soja.Persistor.mapper;

import com.soja.Persistor.ScrappedArticle;
import com.soja.Persistor.dto.ScrappedArticleDto;

public class ScrappedArticleMapper {

    public ScrappedArticle mapToScrappedArticle(final ScrappedArticleDto scrappedArticleDto) {
        return new ScrappedArticle(
                scrappedArticleDto.getId(),
                scrappedArticleDto.getArticleText(),
                scrappedArticleDto.getArticleLead(),
                scrappedArticleDto.getDateOfScrapping()
        );
    }

    public ScrappedArticleDto mapToScrappedArticle(final ScrappedArticle scrappedArticle) {
        return new ScrappedArticleDto(
                scrappedArticle.getId(),
                scrappedArticle.getArticleText(),
                scrappedArticle.getArticleLead(),
                scrappedArticle.getDateOfScrapping()
        );
    }
}
