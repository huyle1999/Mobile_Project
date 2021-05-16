package com.thesis.android_challenge_w3.activity.recycleview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.thesis.android_challenge_w3.R
import com.thesis.android_challenge_w3.databinding.ActivityRecycleViewListBinding
import com.thesis.android_challenge_w3.model.getDataset

class RecycleViewList : AppCompatActivity() {
    private lateinit var binding : ActivityRecycleViewListBinding
    private lateinit var viewModel: RecycleViewListViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_recycle_view_list)
        viewModel = ViewModelProvider(this).get(RecycleViewListViewModel::class.java)
        //setContentView(R.layout.activity_recycle_view_list)

        val adapter = RestaurantAdapter()
        binding.rcList.adapter = adapter
        adapter.data = getDataset()
    }
}