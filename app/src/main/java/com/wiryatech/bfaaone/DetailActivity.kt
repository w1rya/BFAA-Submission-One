package com.wiryatech.bfaaone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_MOVIE = "extra_movie"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val movie = intent.getParcelableExtra<Movie>(EXTRA_MOVIE)

        Glide.with(this)
            .load(movie?.poster)
            .into(iv_poster)
        tv_title.text = movie?.title
        tv_overview.text = movie?.overview
        tv_score.text = movie?.score
        tv_genre.text = movie?.genre
        tv_date.text = movie?.date
        tv_duration.text = movie?.duration
        tv_slogan.text = movie?.slogan

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }
}