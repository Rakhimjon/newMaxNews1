package com.rakhim.newsapp.repo

import androidx.lifecycle.LiveData
import com.rakhim.newsapp.AppExecutors
import com.rakhim.newsapp.api.NewsSourceService
import com.rakhim.newsapp.db.NewsArticlesDao
import com.rakhim.newsapp.model.NewsArticles
import com.rakhim.newsapp.model.NewsSource
import com.rakhim.newsapp.model.network.Resource


class NewsRepository(
        private val newsDao: NewsArticlesDao,
        private val newsSourceService: NewsSourceService,
        private val appExecutors: AppExecutors = AppExecutors()
) {

    /**
     * Fetch the news articles from database if exist else fetch from web
     * and persist them in the database
     */
    fun getNewsArticles(): LiveData<Resource<MutableList<NewsArticles>?>> {
        return object : NetworkBoundResource<MutableList<NewsArticles>, NewsSource>(appExecutors) {
            override fun shouldFetch(data: MutableList<NewsArticles>?): Boolean {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun saveCallResult(item: NewsSource) {
                newsDao.insertArticles(item.articles)
            }

            override fun shouldFetch(data: List<NewsArticles>?) = true

            override fun loadFromDb() = newsDao.getNewsArticles()

            override fun createCall() = newsSourceService.getNewsSource()
        }.asLiveData()
    }

}