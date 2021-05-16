package com.example.foodapp.movie.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.foodapp.Movie.Fragments.NowPlayingFragmentAdapter
import com.example.foodapp.Movie.Fragments.TopRatedFragmentAdapter
import com.example.foodapp.Movie.ViewModel.TopRatedMoviesViewModel
import com.example.foodapp.R
import com.example.foodapp.databinding.MovieFragmentBinding

class TopRatedFragment : Fragment() {
    private lateinit var binding : MovieFragmentBinding
    private lateinit var adapter: TopRatedFragmentAdapter
    private lateinit var viewModel : TopRatedMoviesViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel = ViewModelProvider(this).get(TopRatedMoviesViewModel::class.java)
        binding = DataBindingUtil.inflate(inflater, R.layout.movie_fragment, container, false)

        viewModel.getData()
        viewModel.movieList.observe(viewLifecycleOwner, {
            adapter.setDataList(it)
        })

        adapter = TopRatedFragmentAdapter(activity)

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