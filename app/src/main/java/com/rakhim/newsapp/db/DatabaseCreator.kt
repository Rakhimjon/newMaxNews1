package com.rakhim.newsapp.db

import android.content.Context
import androidx.room.Room


object DatabaseCreator {

    /**
     * Create database instance when the singleton instance is created for the
     * first time.
     */
    fun database(context: Context): NewsDatabase {
        return Room.databaseBuilder(context, NewsDatabase::class.java, "news-db").build()
    }

}