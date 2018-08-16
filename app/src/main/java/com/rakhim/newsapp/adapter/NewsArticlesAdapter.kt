package com.rakhim.newsapp.adapter

import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView

import com.rakhim.newsapp.R
import com.rakhim.newsapp.model.NewsArticles
import com.rakhim.newsapp.utils.inflate
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.row_news_article.view.*


 class NewsArticlesAdapter(
        private val listener: (NewsArticles) -> Unit,
        /**
         * List of news articles
         */
        var newsArticles: MutableList<NewsArticles>

) : RecyclerView.Adapter<NewsArticlesAdapter.NewsHolder>() {



     /**
     * Inflate the view
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = NewsHolder(parent.inflate(R.layout.row_news_article))

    /**
     * Bind the view with the data
     */
    override fun onBindViewHolder(newsHolder: NewsHolder, position: Int) = newsHolder.bind(newsArticles[position], listener)

    /**
     * Number of items in the list to display
     */
    override fun getItemCount() = newsArticles.size

    /**
     * View Holder Pattern
     */
    class NewsHolder(itemView: View) : androidx.recyclerview.widget.RecyclerView.ViewHolder(itemView) {

        /**
         * Binds the UI with the data and handles clicks
         */
        fun bind(newsArticle: NewsArticles, listener: (NewsArticles) -> Unit) = with(itemView) {
            //news_title.text = newsArticle.title
            //news_description.text = newsArticle.description
            tvNewsItemTitle.text = newsArticle.title
            tvNewsAuthor.text = newsArticle.author
            //TODO: need to format date
            //tvListItemDateTime.text = getFormattedDate(newsArticle.publishedAt)
            tvListItemDateTime.text = newsArticle.publishedAt
            Glide.with(context)
                    .load(newsArticle.urlToImage)
                    .apply(RequestOptions()
                            .placeholder(R.drawable.img_test_one)
                            .error(R.drawable.img_test_one)
                            .diskCacheStrategy(DiskCacheStrategy.ALL))
                    .into(ivNewsImage)
            setOnClickListener { listener(newsArticle) }


        }

    }

    /**
     * Swap function to set new data on updating
     */

    fun removeAt(position: Int) {
        newsArticles.removeAt(position)
        notifyItemRemoved(position)
    }

    fun replaceItems(items: MutableList<NewsArticles>) {
        newsArticles = items
        notifyDataSetChanged()
    }
}