package com.example.week1challenge

import android.os.Bundle
import android.support.wearable.activity.WearableActivity

class Signup : WearableActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        // Enables Always-on
        setAmbientEnabled()
    }
}