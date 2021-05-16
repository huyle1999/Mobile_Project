package com.thesis.android_challenge_w3

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.add
import androidx.fragment.app.commit
import com.thesis.android_challenge_w3.activity.recycleview.RecycleViewList
import com.thesis.android_challenge_w3.activity.recycleview.RecycleViewListViewModel
import com.thesis.android_challenge_w3.activity.recycleview.Restaurant
import com.thesis.android_challenge_w3.activity.recycleview.RestaurantAdapter
import com.thesis.android_challenge_w3.activity.signin.SignInViewModel
import com.thesis.android_challenge_w3.databinding.ActivitySignInBinding

class MainActivity : AppCompatActivity() {

    companion object {
        const val USER_KEY = "USER_KEY"
    }

    private lateinit var binding: ActivitySignInBinding
    private lateinit var viewModel: SignInViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.commit { setReorderingAllowed(true)
            add<OnBoardingOneFragment>(R.id.frag_container_view)}

    }

}

