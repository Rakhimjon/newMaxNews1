package com.rakhim.newsapp.model

import com.google.gson.annotations.SerializedName

data class NewsSource(
        @SerializedName("status") var status: String = "",
        @SerializedName("source") var source: String = "",
        @SerializedName("sortBy") var sortBy: String = "",
        @SerializedName("articles") var articles: List<NewsArticles> = emptyList())




