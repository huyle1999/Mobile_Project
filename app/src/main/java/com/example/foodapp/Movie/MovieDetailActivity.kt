package com.example.foodapp.Movie

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.foodapp.R
import com.example.foodapp.databinding.AcitivityDetailMovieBinding
import com.squareup.picasso.Picasso

class MovieDetailActivity : AppCompatActivity() {
    private lateinit var binding : AcitivityDetailMovieBinding
    private lateinit var viewModel: DetailMoviesViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.acitivity_detail_movie)
        viewModel = ViewModelProvider(this).get(DetailMoviesViewModel::class.java)

        val intent = intent
        val movie : Movie = intent.getSerializableExtra("movie_detail") as Movie
        binding.apply {
            Picasso.get().load("https://image.tmdb.org/t/p/w500" + movie.posterPath).into(detailMovieImg)
            titleMovieTxt.text = movie.title
            dateCount.text= movie.releaseDate
            rateArrangeCount.text = movie.voteAverage.toString()
            rateCount.text = movie.voteCount.toString()
            popularityCount.text = movie.popularity.toString()
            movieOverview.text = movie.overview

        }
    }

}