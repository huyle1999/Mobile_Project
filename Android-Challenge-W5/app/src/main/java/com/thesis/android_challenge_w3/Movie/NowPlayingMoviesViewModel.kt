package com.thesis.android_challenge_w3.Movie

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class NowPlayingMoviesViewModel : ViewModel() {

    var movieList = MutableLiveData<List<Movie>>()

    fun getData() {
        viewModelScope.launch {
            val movieResp = RestClient.getInstance().API.listNowPlayingMovie(
                "en-US",
                1,
                "7329758a578ec893b84930c8f1cc3919"
            )
            Log.e("TAG", movieResp.results.toString())
            movieList.value = movieResp.results!!
        }
    }
}