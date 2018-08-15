package com.rakhim.newsapp.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.rakhim.newsapp.model.NewsArticles

/**
 * Abstracts access to the news database
 */
//TODO: Use inheritance for code re-usability.
@Dao
interface NewsArticlesDao {

    /**
     * Insert articles into the database
     */
    @Insert
    fun insertArticles(articles: MutableList<NewsArticles>): List<Long>

    /**
     * Get all the articles from database
     */
    @Query("SELECT * FROM news_article")
    fun getNewsArticles(): LiveData<MutableList<NewsArticles>>
}