package com.soja.Persistor.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.soja.Persistor.GeneratedTweet;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface GeneratedTweetDao extends CrudRepository<GeneratedTweet, Integer> {
}
