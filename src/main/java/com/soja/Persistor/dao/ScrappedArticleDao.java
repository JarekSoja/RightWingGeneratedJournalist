package com.soja.Persistor.dao;

import com.soja.Persistor.ScrappedArticle;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;

@Transactional
@Repository
public interface ScrappedArticleDao extends CrudRepository<ScrappedArticle, Integer> {
}
