package com.rakhim.newsapp.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.rakhim.newsapp.model.NewsArticles


@Database(entities = arrayOf(NewsArticles::class), version = 1)
abstract class NewsDatabase : RoomDatabase() {

    /**
     * Get news article DAO
     */
    abstract fun newsArticlesDao(): NewsArticlesDao
}