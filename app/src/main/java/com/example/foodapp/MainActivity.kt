package com.example.foodapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.add
import androidx.fragment.app.commit
import com.example.foodapp.OnBoarding.AllOnBoardingFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.acitivity_main)
        supportFragmentManager.commit {
            setReorderingAllowed(true)
            add<AllOnBoardingFragment>(R.id.frag)
        }
    }
}
