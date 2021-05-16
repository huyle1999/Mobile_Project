package com.thesis.android_challenge_w3.recycleview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.thesis.android_challenge_w3.R
import com.thesis.android_challenge_w3.Restaurant.favoriteList
import com.thesis.android_challenge_w3.databinding.ActivityRestaurantsBinding
import kotlinx.android.synthetic.main.activity_restaurants.*
import kotlinx.android.synthetic.main.restaurantlist_fragment_layout_favorite.*
import kotlinx.android.synthetic.main.restaurantlist_fragment_layout_top.*

class RestaurantsActivity : AppCompatActivity() {

    private lateinit var binding : ActivityRestaurantsBinding
    private lateinit var viewModel: RestaurantViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_restaurants)
        viewModel = ViewModelProvider(this).get(RestaurantViewModel::class.java)
        
        loadFragment(RestaurantListFragmentTop())

        restaurantBottomNavigationBar.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.Top_btn->{
                    loadFragment(RestaurantListFragmentTop())
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.Favorite_btn->{
                    loadFragment(RestaurantListFragmentFavorite(favoriteList))
                    return@setOnNavigationItemSelectedListener true
                }
                else -> {
                    return@setOnNavigationItemSelectedListener false
                }
            }
        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.restaurant_activity_menubar,menu)
        return true
    }

    private fun loadFragment(fragment : Fragment)
    {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.listRestaurant_fragment_container,fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}