package com.rakhim.newsapp.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.rakhim.newsapp.api.NewsSourceService
import com.rakhim.newsapp.db.DatabaseCreator
import com.rakhim.newsapp.model.NewsArticles
import com.rakhim.newsapp.model.network.Resource
import com.rakhim.newsapp.repo.NewsRepository

/**
 * A container for [NewsArticles] related data to show on the UI.
 */
class NewsArticleViewModel(application: Application) : AndroidViewModel(application) {

    private var newsArticles: LiveData<Resource<MutableList<NewsArticles>?>>

    init {
        // TODO: Inject repository using DI.
        val newsRepository = NewsRepository(
                DatabaseCreator.database(application).newsArticlesDao(),
                NewsSourceService.getNewsSourceService()
        )
        newsArticles = newsRepository.getNewsArticles()
    }

    /**
     * Return news articles to observe on the UI.
     */
    fun getNewsArticles() = newsArticles
}