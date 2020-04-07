package com.wiryatech.bfaaone

import android.content.Intent
import android.content.res.TypedArray
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: MovieAdapter

    private lateinit var dataTitle: Array<String>
    private lateinit var dataOverview: Array<String>
    private lateinit var dataPoster: TypedArray
    private lateinit var dataScore: Array<String>
    private lateinit var dataGenre: Array<String>
    private lateinit var dataDate: Array<String>
    private lateinit var dataDuration: Array<String>
    private lateinit var dataSlogan: Array<String>

    private var movies = ArrayList<Movie>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = MovieAdapter(this)
        lv_movie.adapter = adapter

        prepare()
        addItem()

        lv_movie.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
            Toast.makeText(this@MainActivity, movies[position].title, Toast.LENGTH_SHORT).show()

            val movieDetail = Movie()
            movieDetail.poster = dataPoster.getResourceId(position, -1)
            movieDetail.title = dataTitle[position]
            movieDetail.overview = dataOverview[position]
            movieDetail.score = dataScore[position]
            movieDetail.genre = dataGenre[position]
            movieDetail.date = dataDate[position]
            movieDetail.duration = dataDuration[position]
            movieDetail.slogan = dataSlogan[position]

            val detailIntent = Intent(this@MainActivity, DetailActivity::class.java)
            detailIntent.putExtra(DetailActivity.EXTRA_MOVIE, movieDetail)
            startActivity(detailIntent)
        }
    }

    private fun prepare() {
        dataTitle = resources.getStringArray(R.array.data_title)
        dataOverview = resources.getStringArray(R.array.data_overview)
        dataPoster = resources.obtainTypedArray(R.array.data_poster)
        dataScore = resources.getStringArray(R.array.data_score)
        dataGenre = resources.getStringArray(R.array.data_genre)
        dataDate = resources.getStringArray(R.array.data_date)
        dataDuration = resources.getStringArray(R.array.data_duration)
        dataSlogan = resources.getStringArray(R.array.data_slogan)
    }

    private fun addItem() {
        for (position in dataTitle.indices) {
            val movie = Movie(
                dataPoster.getResourceId(position, -1),
                dataTitle[position],
                dataOverview[position],
                dataScore[position],
                dataGenre[position],
                dataDate[position],
                dataDuration[position],
                dataSlogan[position]
            )
            movies.add(movie)
        }
        adapter.movies = movies
    }
}