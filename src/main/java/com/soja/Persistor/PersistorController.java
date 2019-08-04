package com.soja.Persistor;

import com.soja.Persistor.dao.GeneratedTweetDao;
import com.soja.Persistor.dao.ScrappedArticleDao;
import com.soja.Persistor.mapper.ScrappedArticleMapper;
import com.soja.WebScrapper.scrappingstrategy.WPolityceScrappingStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersistorController {

    @Autowired
    GeneratedTweetDao generatedTweetDao;

    @Autowired
    ScrappedArticleDao scrappedArticleDao;

    @Autowired
    ScrappedArticleMapper scrappedArticleMapper;

    public void persist(WPolityceScrappingStrategy.ArticleToPersist article) {
        scrappedArticleDao.save(scrappedArticleMapper.mapToScrappedArticle(article));
    }
}
