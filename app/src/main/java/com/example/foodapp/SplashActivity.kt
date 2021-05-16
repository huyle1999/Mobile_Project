package com.example.foodapp

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.foodapp.Movie.NowPlayingMoviesViewModel

class SplashActivity : AppCompatActivity() {
    lateinit var mainViewModel: NowPlayingMoviesViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        mainViewModel = ViewModelProvider(this).get(NowPlayingMoviesViewModel::class.java)
        val handler= Handler()
        Handler().postDelayed({
            // You can declare your desire activity here to open after finishing splash screen. Like MainActivity
            val intent=Intent(this,MainActivity::class.java)
            startActivity(intent);
            finish()
        },5000)
    }

    override fun onStart() {
        super.onStart()
        mainViewModel.getData()
    }
}