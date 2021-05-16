package com.example.foodapp.Profile

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.foodapp.UserAccount

class ProfileViewModel : ViewModel() {
    var account : MutableLiveData<UserAccount> = MutableLiveData()
    init {
        account.value = UserAccount("", "","")
    }
}