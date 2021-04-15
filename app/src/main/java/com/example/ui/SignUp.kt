package com.example.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PatternMatcher
import android.util.Patterns
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.ui.databinding.ActivitySignUpBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class SignUp : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    private lateinit var binding : ActivitySignUpBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_sign_up)
//        var buttonSignIn = findViewById<TextView>(R.id.textView17)
        binding.textView17.setOnClickListener {
            val intent = Intent(this, Login::class.java)
            startActivity(intent)
        }
        binding.imageButton6.setOnClickListener {
            signUpUser()
        }

        auth = FirebaseAuth.getInstance()
    }

    private fun signUpUser(){
        if(binding.editTextTextPersonName2.text.toString().isEmpty()){
            binding.editTextTextPersonName2.error = "Please enter email"
            binding.editTextTextPersonName2.requestFocus()
            return
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(binding.editTextTextPersonName2.text.toString()).matches()){
            binding.editTextTextPersonName2.error = "Please enter valid email"
            binding.editTextTextPersonName2.requestFocus()
            return
        }
        if(binding.editTextTextPassword.text.toString().isEmpty()){
            binding.editTextTextPassword.error = "Please enter password"
            binding.editTextTextPassword.requestFocus()
            return
        }

        auth.createUserWithEmailAndPassword(binding.editTextTextPersonName2.text.toString(), binding.editTextTextPassword.text.toString())
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    val user = auth.currentUser
                    user?.sendEmailVerification()
                        ?.addOnCompleteListener { task ->
                            if (task.isSuccessful) {
                                //startActivity(Intent(this, Login::class.java))
                                intent.putExtra("Name", binding.editTextTextPersonName.text.toString())
                                intent.putExtra("Email",binding.editTextTextPersonName2.text.toString())
                                val intent = Intent(this, Login::class.java)
                                intent.putExtra("Phone"," ")
                                startActivity(intent)
                                finish()
                            }
                        }
                    //startActivity(Intent(this, Login::class.java))
                    //finish()
                } else {
                    Toast.makeText(baseContext, "Sign Up failed. Try again after",
                        Toast.LENGTH_SHORT).show()
                }
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
    public override fun onStart() {
        super.onStart()
        // Check if user is signed in (non-null) and update UI accordingly.
        val currentUser = auth.currentUser
        updateUI(currentUser)
    }

    fun updateUI(currentUser: FirebaseUser?){

    }
}