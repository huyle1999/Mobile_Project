package com.example.week1challenge

import android.os.Bundle
import android.support.wearable.activity.WearableActivity

class Login : WearableActivity() {

    fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // Enables Always-on
        setAmbientEnabled()
    }
}