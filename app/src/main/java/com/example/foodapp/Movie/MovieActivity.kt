package com.example.foodapp.Movie

import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.foodapp.Movie.Fragments.NowPlayingFragment
import com.example.foodapp.R
import com.example.foodapp.movie.Fragments.TopRatedFragment
import kotlinx.android.synthetic.main.activity_movie.*
import kotlinx.android.synthetic.main.activity_restaurants.*

class MovieActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie)

        loadFragment(NowPlayingFragment())

        movieBottomNavigationBar.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.Nowplaying_btn->{
                    loadFragment(NowPlayingFragment())
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.Toprated_btn->{
                    loadFragment(TopRatedFragment())
                    return@setOnNavigationItemSelectedListener true
                }
                else -> {
                    return@setOnNavigationItemSelectedListener false
                }
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        //reused
        menuInflater.inflate(R.menu.restaurant_activity_menubar,menu)
        return true
    }

    private fun loadFragment(fragment : Fragment)
    {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.movie_listview,fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

}