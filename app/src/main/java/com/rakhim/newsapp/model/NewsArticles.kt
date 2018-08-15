package com.rakhim.newsapp.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName


@Entity(tableName = "news_article")
data class NewsArticles(
        @PrimaryKey(autoGenerate = true) var id: Int = 0,
        @SerializedName("author") var author: String? = null,
        @SerializedName("title") var title: String = "",
        @SerializedName("description") var description: String = "",
        @SerializedName("url") var url: String = "",
        @SerializedName("urlToImage") var urlToImage: String? = null,
        @SerializedName("publishedAt") var publishedAt: String? = null)