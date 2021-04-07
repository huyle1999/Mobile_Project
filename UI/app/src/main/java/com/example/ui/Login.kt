package com.example.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import kotlinx.android.synthetic.main.activity_login.*

class Login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

       // val etEmail = findViewById<TextInputEditText>(R.id.textInputEditText)
      //  val etPassword = findViewById<TextInputEditText>(R.id.textInputEditText2)

        val login = findViewById<ImageButton>(R.id.imageButton6)
        if(login!=null && textInputEditText!=null && textInputEditText2!=null){
            login.setOnClickListener {
                val email = textInputEditText.text.toString()
                val password = textInputEditText2.text.toString()

                if(email == "ronaldo@gmail.com" && password == "123456"){
                    val intent = Intent(this, Profile::class.java)
                    startActivity(intent)
                }else{
                    Toast.makeText(applicationContext,
                            "email hoac password khong dung", Toast.LENGTH_SHORT).show()
                }
            }
        }
        var buttonSignIn = findViewById<TextView>(R.id.textView26)
        buttonSignIn.setOnClickListener {
            val intent = Intent(this, SignUp::class.java)
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()
        supportActionBar?.hide();
       /* window.decorView.apply {
            // Hide both the navigation bar and the status bar.
            // SYSTEM_UI_FLAG_FULLSCREEN is only available on Android 4.1 and higher, but as
            // a general rule, you should design your app to hide the status bar whenever you
            // hide the navigation bar.
            systemUiVisibility = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or View.SYSTEM_UI_FLAG_FULLSCREEN
        }*/
    }
}