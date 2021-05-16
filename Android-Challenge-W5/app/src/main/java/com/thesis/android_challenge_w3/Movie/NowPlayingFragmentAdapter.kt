package com.thesis.android_challenge_w3.Movie

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.thesis.android_challenge_w3.R

class NowPlayingFragmentAdapter(c: Context? = null) : RecyclerView.Adapter<NowPlayingFragmentAdapter.ViewHolder>(){

    private val LIST_ITEM : Int = 0
    private val GRID_ITEM : Int = 1
    private var isSwitch : Boolean = false
    val data = mutableListOf<Movie>()
    val con = c



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view : View = if(viewType == GRID_ITEM)
            layoutInflater.inflate(R.layout.movie_linear_item, parent, false)
        else
            layoutInflater.inflate(R.layout.movie_grid_item, parent, false)
        return ViewHolder(view)
    }

    fun switchItemView() : Boolean
    {
        isSwitch = !isSwitch
        return isSwitch
    }

    override fun getItemViewType(position: Int): Int {
        return if (isSwitch){
            LIST_ITEM
        }else{
            GRID_ITEM
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = data[position]
        holder.title.text = item.title
        holder.description.text = item.overview
        Picasso.get().load("https://image.tmdb.org/t/p/w500" + item.posterPath).into(holder.poster)
        holder.poster.setOnClickListener{
            val intent = Intent(con, MovieDetailActivity::class.java)
            intent.putExtra("movie_detail",item)
            con?.startActivity(intent)
        }
        Log.d("AAA",item.toString())
    }

    override fun getItemCount(): Int {
        return data.size
    }

    fun setDataList(listData: List<Movie>){
        data.clear()
        data.addAll(listData)
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val poster: ImageView = itemView.findViewById<ImageButton>(R.id.poster_img)
        val title: TextView = itemView.findViewById(R.id.title_txt)
        val description: TextView = itemView.findViewById(R.id.description_txt)
    }
}