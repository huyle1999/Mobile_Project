package com.thesis.android_challenge_w3.recycleview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.thesis.android_challenge_w3.R
import com.thesis.android_challenge_w3.Restaurant.favoriteList
import com.thesis.android_challenge_w3.activity.recycleview.Restaurant

class RestaurantsAdapter : RecyclerView.Adapter<RestaurantsAdapter.ViewHolder>(){

    val LIST_ITEM : Int = 0
    val GRID_ITEM : Int = 1
    var isSwitch : Boolean = false

    var data : List<Restaurant> = listOf()
        set(value){
            field = value
            notifyDataSetChanged()
        }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var layoutInflater = LayoutInflater.from(parent.context)
        var view : View
        if(viewType == LIST_ITEM)
            view = layoutInflater.inflate(R.layout.restaurant_linear_item, parent, false)
        else
            view = layoutInflater.inflate(R.layout.restaurant_grid_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var item = data[position]
        holder.name.text = item.Name
        holder.address.text = item.Address
        holder.picture.setImageResource(item.PicturePath)
//        Picasso.get().load(item.PicturePath).into(holder.picture)
//
//        if(favoriteList.contains(data[position])) holder.isFav.isChecked = true
//
//        holder.isFav.setOnCheckedChangeListener { buttonView, isChecked ->
//            if(isChecked)
//            {
//                if(!favoriteList.contains(data[position]))
//                favoriteList += data[position]
//            }
//            else
//            {
//                favoriteList -= data[position]
//            }
//        }
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
        if (isSwitch){
            return LIST_ITEM;
        }else{
            return GRID_ITEM;
        }
    }

    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val name = itemView.findViewById<TextView>(R.id.restaurantName)!!
        val address = itemView.findViewById<TextView>(R.id.restaurantAddress)!!
        val picture = itemView.findViewById<ImageView>(R.id.restaurantPic)!!
        val isFav = itemView.findViewById<CheckBox>(R.id.favorite_btn)!!
    }
}