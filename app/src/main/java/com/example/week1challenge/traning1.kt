package com.example.week1challenge

import android.os.Bundle
import android.support.wearable.activity.WearableActivity

class traning1 : WearableActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_traning1)

        // Enables Always-on
        setAmbientEnabled()
    }
}