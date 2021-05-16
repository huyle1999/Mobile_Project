package com.thesis.android_challenge_w3.activity.signup

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.thesis.android_challenge_w3.R
import androidx.databinding.DataBindingUtil
import com.thesis.android_challenge_w3.databinding.ActivitySignUpBinding
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.thesis.android_challenge_w3.activity.signin.SignInActivity
import java.util.regex.Pattern


/**
 * Created by Viet Hua on 04/03/2021.
 */

class SignUpActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignUpBinding
    private lateinit var viewModel: SignUpViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        setupViewModelBinding()

        binding.edtEmail.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if(android.util.Patterns.EMAIL_ADDRESS.matcher(binding.edtEmail.text.toString()).matches())
                    binding.btnSignUp.isEnabled = true
                else{
                    binding.btnSignUp.isEnabled = false
                    binding.edtEmail.setError("Invalid Email")
                }
            }

            override fun afterTextChanged(s: Editable?) {
            }

        })
        binding.edtPassword.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
//                if(binding.edtPassword.length() >= 8){
//                    binding.btnSignUp.isEnabled = true
//                }
//                else{
//                    binding.btnSignUp.isEnabled = false
//                    showToastMessage("Password should be at least 8 characters");
//                }
                //fun isValidPassword(data: Any, updateUI: Boolean = true): Boolean {
                    val str = binding.edtPassword.text.toString()
                    binding.btnSignUp.isEnabled = true

                    // Password policy check
                    // Password should be minimum minimum 8 characters long
                    if (str.length < 8) {
                        binding.btnSignUp.isEnabled = false
                        binding.edtPassword.setError("Password should be minimum minimum 8 characters long.")
                    }
                    // Password should contain at least one number
                    var exp = ".*[0-9].*"
                    var pattern = Pattern.compile(exp, Pattern.CASE_INSENSITIVE)
                    var matcher = pattern.matcher(str)
                    if (!matcher.matches()) {
                        binding.btnSignUp.isEnabled = false
                        binding.edtPassword.setError("Password should contain at least one number.")
                    }

                    // Password should contain at least one capital letter
                    exp = ".*[A-Z].*"
                    pattern = Pattern.compile(exp)
                    matcher = pattern.matcher(str)
                    if (!matcher.matches()) {
                        binding.btnSignUp.isEnabled = false
                        binding.edtPassword.setError("Password should contain at least one capital letter.")
                    }

                    // Password should contain at least one small letter
                    exp = ".*[a-z].*"
                    pattern = Pattern.compile(exp)
                    matcher = pattern.matcher(str)
                    if (!matcher.matches()) {
                        binding.btnSignUp.isEnabled = false
                        binding.edtPassword.setError("Password should contain at least one small letter.")

                    }

                    // Password should contain at least one special character
                    // Allowed special characters : "~!@#$%^&*()-_=+|/,."';:{}[]<>?"
                    exp = ".*[~!@#\$%\\^&*()\\-_=+\\|\\[{\\]};:'\",<.>/?].*"
                    pattern = Pattern.compile(exp)
                    matcher = pattern.matcher(str)
                    if (!matcher.matches()) {
                        binding.btnSignUp.isEnabled = false
                        binding.edtPassword.setError("Password should contain at least one special character.")
                    }

                    // Set error if required
                }
            //}

            override fun afterTextChanged(s: Editable?) {
            }

        })
    }

    override fun onStop() {
        super.onStop()
        viewModel.clear()
    }

    private fun setupViewModelBinding() {
        viewModel = ViewModelProvider(this).get(SignUpViewModel::class.java)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_sign_up)
        binding.lifecycleOwner = this
        binding.signUpViewModel = viewModel
        binding.apply {
            btnSignIn.setOnClickListener {
                startLoginActivity()
            }
        }

        viewModel.isSignUpSucceed.observe(this, Observer {
            it?.let {
                if (it) {
                    showToastMessage("Sign Up Successful")
                    startLoginActivity()
                }
            }
        })

        viewModel.errorMessage.observe(this, Observer { message ->
            message?.let {
                Toast.makeText(this@SignUpActivity, message, Toast.LENGTH_SHORT).show()
            }
        })

    }

    private fun startLoginActivity() {
        val intent = Intent(
            this@SignUpActivity,
            SignInActivity::class.java
        )
        startActivity(intent)
    }

    private fun showToastMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}


