package com.soja.persistor.dao;

import com.soja.persistor.ScrappedArticle;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;

@Transactional
@Repository
public interface ScrappedArticleDao extends CrudRepository<ScrappedArticle, Integer> {
}
