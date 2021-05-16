package com.thesis.android_challenge_w3.Movie

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.thesis.android_challenge_w3.R
import com.thesis.android_challenge_w3.databinding.MovieFragmentBinding

class NowPlayingFragment : Fragment() {
    private lateinit var binding: MovieFragmentBinding
    private lateinit var adapter: NowPlayingFragmentAdapter
    private lateinit var viewModel: NowPlayingMoviesViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel = ViewModelProvider(this).get(NowPlayingMoviesViewModel::class.java)
        binding = DataBindingUtil.inflate(inflater, R.layout.movie_fragment, container, false)

        viewModel.getData()
        viewModel.movieList.observe(viewLifecycleOwner, {
            adapter.setDataList(it)
        })

        adapter = NowPlayingFragmentAdapter(activity)

        binding.apply {
            npMovieList.adapter = adapter

        }

        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.npMovieList.layoutManager = LinearLayoutManager(activity)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.displayMode -> {
                adapter.switchItemView()
                return if (item.title == "List") {
                    item.title = "Grid"
                    binding.npMovieList.layoutManager = LinearLayoutManager(activity)
                    true
                } else {
                    item.title = "List"
                    binding.npMovieList.layoutManager = GridLayoutManager(activity,2)
                    true
                }
                adapter.notifyDataSetChanged()
            }
            else -> return false
        }
        return super.onOptionsItemSelected(item)

    }

}