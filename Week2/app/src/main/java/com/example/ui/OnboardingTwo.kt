package com.example.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton

class OnboardingTwo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboarding_two)

        var imagebutton = findViewById<ImageButton>(R.id.imageButton)
        imagebutton.setOnClickListener {
            val intent = Intent(this, OnboardingThree::class.java)
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()
        supportActionBar?.hide();
//        window.decorView.apply {
//            // Hide both the navigation bar and the status bar.
//            // SYSTEM_UI_FLAG_FULLSCREEN is only available on Android 4.1 and higher, but as
//            // a general rule, you should design your app to hide the status bar whenever you
//            // hide the navigation bar.
//            systemUiVisibility = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or View.SYSTEM_UI_FLAG_FULLSCREEN
//        }
    }
}