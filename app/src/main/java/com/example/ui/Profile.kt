package com.example.ui

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.databinding.DataBindingUtil
import com.example.ui.databinding.ActivityProfileBinding
import kotlinx.android.synthetic.main.activity_profile.*
import kotlinx.android.synthetic.main.custom_dialog.view.*

class Profile : AppCompatActivity() {

    private  lateinit var binding: ActivityProfileBinding
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_profile)
        binding.textView30.setOnClickListener {
            val mDialogView = LayoutInflater.from(this).inflate(R.layout.custom_dialog, null)
            val mBuilder = AlertDialog.Builder(this)
                    .setView(mDialogView)
                    .setTitle("Login Form")
            val  mAlertDialog = mBuilder.show()
            mDialogView.button2.setOnClickListener {
                val fullname = mDialogView.editTextTextPersonName7.text.toString()
                val email = mDialogView.editTextTextPersonName8.text.toString()
                val phonenumber = mDialogView.editTextTextPersonName9.text.toString()

                editTextTextPersonName3.setText(fullname)
                editTextTextPersonName4.setText(email)
                editTextTextPersonName5.setText(phonenumber)
            }

            binding.editTextTextPersonName3.setText(intent.getStringExtra("Name"))
            binding.editTextTextPersonName4.setText(intent.getStringExtra("Email"))
        }
        //binding.account = DataStore("", "", "")

//        val fullname = intent.getStringExtra("Name")
//        val email = intent.getStringExtra("Email")

//        binding.editTextTextPersonName3.setText(intent.getStringExtra("Name"))
//        binding.editTextTextPersonName4.setText(intent.getStringExtra("Email"))


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