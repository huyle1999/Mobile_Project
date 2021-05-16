package com.thesis.android_challenge_w3.activity.recycleview

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Restaurant(var Name: String = "", var Address: String = "", var PicturePath: Int) : Parcelable