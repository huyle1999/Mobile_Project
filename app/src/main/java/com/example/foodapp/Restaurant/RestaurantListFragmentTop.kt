package com.example.foodapp.Restaurant

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.foodapp.R
import com.example.foodapp.databinding.RestaurantlistFragmentLayoutTopBinding
import kotlinx.android.synthetic.main.restaurantlist_fragment_layout_favorite.*
import kotlinx.android.synthetic.main.restaurantlist_fragment_layout_favorite.FavRetaurantList
import kotlinx.android.synthetic.main.restaurantlist_fragment_layout_top.*

class RestaurantListFragmentTop : Fragment(){
    private lateinit var binding: RestaurantlistFragmentLayoutTopBinding
    private lateinit var adapter : RestaurantsAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.restaurantlist_fragment_layout_top,container,false)
        adapter = RestaurantsAdapter()
        binding.retaurantList.adapter = adapter
        adapter.data = getRestaurants()
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
                if (item.title == "List") {
                    item.icon = resources.getDrawable(R.drawable.ic_grid)
                    item.title = "Grid"
                    retaurantList.layoutManager = GridLayoutManager(activity,2)
                    return true
                } else {
                    item.icon = resources.getDrawable(R.drawable.ic_list)
                    item.title = "List"
                    retaurantList.layoutManager = LinearLayoutManager(activity)
                    return true
                }
                adapter.notifyDataSetChanged()

            }
            else -> return false
        }
    }
}