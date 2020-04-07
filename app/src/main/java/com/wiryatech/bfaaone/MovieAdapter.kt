package com.wiryatech.bfaaone

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.item_movie.view.*

class MovieAdapter internal constructor(private val context: Context) : BaseAdapter(){

    internal var movies = arrayListOf<Movie>()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var itemView = convertView
        if (itemView == null) {
            itemView = LayoutInflater.from(context).inflate(R.layout.item_movie, parent, false)
        }

        val viewHolder = ViewHolder(itemView as View)

        val movie = getItem(position) as Movie
        viewHolder.bind(movie)
        return itemView
    }

    override fun getItem(position: Int): Any {
        return movies[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return movies.size
    }

    inner class ViewHolder constructor(private val view: View) {
        internal fun bind(movie: Movie) {
            with(view) {
                tv_title.text = movie.title
                tv_overview.text = movie.overview
                iv_poster.setImageResource(movie.poster!!)
            }
        }
    }

}