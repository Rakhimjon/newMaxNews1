package com.rakhim.newsapp.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.rakhim.newsapp.R
import com.rakhim.newsapp.adapter.NewsArticlesAdapter
import com.rakhim.newsapp.ui.NewsArticleViewModel
import com.rakhim.newsapp.utils.getViewModel
import com.rakhim.newsapp.utils.load
import com.rakhim.newsapp.utils.observe
import com.rakhim.newsapp.utils.toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.empty_layout.*
import kotlinx.android.synthetic.main.progress_layout.*


class MainActivity : AppCompatActivity() {

    private val newsArticleViewModel by lazy { getViewModel<NewsArticleViewModel>() }

    /**
     * Starting point of the activity
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Setting up RecyclerView and adapter
        news_list.setEmptyView(empty_view)
        news_list.setProgressView(progress_view)

        val adapter = NewsArticlesAdapter {
            toast("Clicked on item")
        }
        news_list.adapter = adapter
        news_list.layoutManager = androidx.recyclerview.widget.LinearLayoutManager(this)

        // Observing for data change
        newsArticleViewModel.getNewsArticles().observe(this) {
            it.load(news_list) {
                // Update the UI as the data has changed
                it?.let { adapter.replaceItems(it) }
            }
        }

    }
}
