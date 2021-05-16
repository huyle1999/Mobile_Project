package com.example.foodapp.OnBoarding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.foodapp.R
import com.synnapps.carouselview.CarouselView
import com.synnapps.carouselview.ImageListener

class OnBoardingFragment : Fragment() {
    var sampleImages = intArrayOf(
        R.drawable.inview1,
        R.drawable.inview2,
        R.drawable.inview3
    )
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.on_boarding_fragment,container,false)
        val carouselView = view.findViewById<CarouselView>(R.id.carouselView)
        carouselView.pageCount = sampleImages.size
        carouselView.setImageListener(imageListener)
        return view
    }
    var imageListener: ImageListener = ImageListener { position, imageView -> //
        // You can use Glide or Picasso here

        imageView.setImageResource(sampleImages[position])

    }

}