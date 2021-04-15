package com.example.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.view.View
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.ui.databinding.ActivityLoginBinding
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.android.synthetic.main.activity_login.*

class Login : AppCompatActivity() {
    private  lateinit var binding: ActivityLoginBinding
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

       // val etEmail = findViewById<TextInputEditText>(R.id.textInputEditText)
      //  val etPassword = findViewById<TextInputEditText>(R.id.textInputEditText2)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)
      //  val login = findViewById<ImageButton>(R.id.imageButton6)
        if(binding.imageButton6!=null && binding.textInputEditText!=null && binding.textInputEditText2!=null){
            binding.imageButton6.setOnClickListener {
//                val email = textInputEditText.text.toString()
//                val password = textInputEditText2.text.toString()
//
//                if(email == "ronaldo@gmail.com" && password == "123456"){
//                    val intent = Intent(this, Profile::class.java)
//                    startActivity(intent)
//                }else{
//                    Toast.makeText(applicationContext,
//                            "email hoac password khong dung", Toast.LENGTH_SHORT).show()
//                }
                doLogin()
            }
            auth = FirebaseAuth.getInstance()
        }
        binding.textView26.setOnClickListener {
            val intent = Intent(this, SignUp::class.java)
            startActivity(intent)
        }
    }

    private  fun doLogin(){
        if(binding.textInputEditText.text.toString().isEmpty()){
            binding.textInputEditText.error = "Please enter email"
            binding.textInputEditText.requestFocus()
            return
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(binding.textInputEditText.text.toString()).matches()){
            binding.textInputEditText.error = "Please enter valid email"
            binding.textInputEditText.requestFocus()
            return
        }
        if(binding.textInputEditText2.text.toString().isEmpty()){
            binding.textInputEditText2.error = "Please enter password"
            binding.textInputEditText2.requestFocus()
            return
        }

        auth.signInWithEmailAndPassword(binding.textInputEditText.text.toString(), binding.textInputEditText2.text.toString())
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    val user = auth.currentUser
                    updateUI(user)
                } else {

                    updateUI(null)
                }
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

    public override fun onStart() {
        super.onStart()
        // Check if user is signed in (non-null) and update UI accordingly.
        val currentUser = auth.currentUser
        updateUI(currentUser)
    }

    private fun updateUI(currentUser: FirebaseUser?){
        if(currentUser != null){
            if(currentUser.isEmailVerified) {
                //var intent = intent
                //val fullname = intent.getStringExtra("Name")
                //val email = intent.getStringExtra("Email")
                startActivity(Intent(this, Profile::class.java))
               // startActivity(intent)
            }else{
                Toast.makeText(baseContext, "Please verify your email address.",
                    Toast.LENGTH_SHORT).show()
            }
        }
        else{
            Toast.makeText(baseContext, "Login failed.",
                Toast.LENGTH_SHORT).show()
        }
    }
}