package com.rakhim.newsapp.api

import androidx.lifecycle.LiveData

import com.rakhim.newsapp.BuildConfig
import com.rakhim.newsapp.model.NewsSource
import com.rakhim.newsapp.model.network.Resource
import com.rakhim.newsapp.utils.LiveDataCallAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET


interface NewsSourceService {

    /**
     * Retrieves all the latest news article from Google news.
     */
    @GET("articles?source=google-news&apiKey=" + BuildConfig.NEWS_API_KEY)
    fun getNewsSource(): LiveData<Resource<NewsSource>>

    /**
     * Kinda like a static block in Java
     */
    companion object Factory {
        private const val BASE_URL = "https://newsapi.org/v1/"


        fun getNewsSourceService(): NewsSourceService {
            return Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(LiveDataCallAdapterFactory())
                    .build()
                    .create(NewsSourceService::class.java)
        }
    }
}
