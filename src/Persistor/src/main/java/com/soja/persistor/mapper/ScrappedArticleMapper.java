package com.soja.persistor.mapper;

import com.soja.persistor.ScrappedArticle;
import com.soja.persistor.dto.ScrappedArticleDto;

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
