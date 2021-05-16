package com.thesis.android_challenge_w3.recycleview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.thesis.android_challenge_w3.R
import com.thesis.android_challenge_w3.activity.recycleview.Restaurant
import com.thesis.android_challenge_w3.databinding.RestaurantlistFragmentLayoutFavoriteBinding
import kotlinx.android.synthetic.main.restaurantlist_fragment_layout_favorite.*

class RestaurantListFragmentFavorite(val data: List<Restaurant>)  : Fragment(){
    private lateinit var binding : RestaurantlistFragmentLayoutFavoriteBinding
    private lateinit var adapter : FavoriteListAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.restaurantlist_fragment_layout_favorite,container,false)
        adapter = FavoriteListAdapter(data)
        binding.FavRetaurantList.adapter = adapter
        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        super.onOptionsItemSelected(item)
        when (item.itemId) {
            R.id.displayMode -> {
                adapter.switchItemView()
                return if (item.title == "List") {
                    item.icon = resources.getDrawable(R.drawable.ic_grid)
                    item.title = "Grid"

                    FavRetaurantList.layoutManager = GridLayoutManager(activity,2)

                    true
                } else {
                    item.icon = resources.getDrawable(R.drawable.ic_list)
                    item.title = "List"
                    FavRetaurantList.layoutManager = LinearLayoutManager(activity)
                    true
                }
            }
            else -> return false
        }
    }
}