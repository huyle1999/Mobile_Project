package com.example.foodapp.Restaurant

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.foodapp.R
import com.squareup.picasso.Picasso

class FavoriteListAdapter(val data : List<Restaurant>) : RecyclerView.Adapter<FavoriteListAdapter.ViewHolder>() {

    val LIST_ITEM : Int = 0
    val GRID_ITEM : Int = 1
    var isSwitch : Boolean = false

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var layoutInflater = LayoutInflater.from(parent.context)
        val view : View = if(viewType == LIST_ITEM)
            layoutInflater.inflate(R.layout.restaurant_linear_item, parent, false)
        else
            layoutInflater.inflate(R.layout.restaurant_grid_item, parent, false)
        return ViewHolder(view)
    }


    override fun getItemCount(): Int {
        return data.size
    }

    fun switchItemView() : Boolean
    {
        isSwitch = !isSwitch
        return isSwitch
    }

    override fun getItemViewType(position: Int): Int {
        return if (isSwitch){
            LIST_ITEM;
        }else{
            GRID_ITEM;
        }
    }

    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val name = itemView.findViewById<TextView>(R.id.restaurantName)!!
        val address = itemView.findViewById<TextView>(R.id.restaurantAddress)!!
        val picture = itemView.findViewById<ImageView>(R.id.restaurantPic)!!
        val isFav = itemView.findViewById<CheckBox>(R.id.favorite_btn)!!
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var item = data[position]
        holder.name.text = item.name
        holder.address.text = item.address
        Picasso.get().load(item.pictureLink).into(holder.picture)
        holder.isFav.visibility = View.GONE
    }
}