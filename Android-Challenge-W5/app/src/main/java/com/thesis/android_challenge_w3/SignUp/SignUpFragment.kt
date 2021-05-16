package com.thesis.android_challenge_w3.SignUp

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Patterns
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.lifecycle.ViewModelProvider
import com.thesis.android_challenge_w3.Login.LoginFragment
import com.thesis.android_challenge_w3.R
import com.thesis.android_challenge_w3.activity.signup.SignUpViewModel
import com.thesis.android_challenge_w3.databinding.SignUpFragmentBinding


class SignUpFragment : Fragment() {
    private lateinit var binding : SignUpFragmentBinding
    private lateinit var viewModel : SignUpViewModel
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = SignUpFragmentBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(SignUpViewModel::class.java)
        binding.apply {
            SignUpButton.setOnClickListener{
                var passwordFlag = false
                var emailFlag = false
                val textEmail = SignupEmailEntered.text.toString()
                if (textEmail.isEmpty()){
                    SignupEmailEntered.error = "Your email must match !"
                }
                else if (!isEmailValid(textEmail)){
                    SignupEmailEntered.error = "Your email is invalid !";
                } else emailFlag=true
                val textPassword = SignupPasswordEntered.text.toString()
                if (textPassword.isEmpty())
                    SignupPasswordEntered.error = "Your passwords must match !"
                else if (textPassword.length < 8) {
                    SignupPasswordEntered.error = "Your passwords must be at least 8 characters in length !"
                } else if (!checkString(textPassword)) {
                    SignupPasswordEntered.error = "Your passwords must have Capital letters, Lowercase letters, Number and Special characters !"
                } else passwordFlag=true
                if (emailFlag&&passwordFlag){
                    Toast.makeText(activity, "Sign up successfully!\n", Toast.LENGTH_SHORT).show()
                    parentFragmentManager.commit {
                        setReorderingAllowed(true)
                        val args = Bundle()
                        args.putSerializable("SignedUpAccount", account)
                        val fragment = LoginFragment()
                        fragment.arguments = args
                        add(R.id.frag_container_view, fragment)
                        addToBackStack(null)
                    }
                } else if (!emailFlag&&!passwordFlag)
                    Toast.makeText(
                        activity, "Your email is invalid !" +
                                "\nYour password is invalid !", Toast.LENGTH_SHORT
                    ).show()
                else if (!emailFlag&&passwordFlag)
                    Toast.makeText(activity, "Your email is invalid !", Toast.LENGTH_SHORT).show()
                else Toast.makeText(
                    activity,
                    "Your password is invalid !",
                    Toast.LENGTH_SHORT
                ).show()

            }

            SignupEmailEntered.addTextChangedListener(object : TextWatcher {
                override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                    val text = SignupEmailEntered.text.toString()
                    if (text.isEmpty())
                        SignupEmailEntered.error = "Your email must match !"
                    else if (!isEmailValid(text))
                        SignupEmailEntered.error = "Your email is invalid !";
                }

                override fun beforeTextChanged(
                    s: CharSequence,
                    start: Int,
                    count: Int,
                    after: Int
                ) {
                }

                override fun afterTextChanged(s: Editable) {}
            })
            SignupPasswordEntered.addTextChangedListener(object : TextWatcher {
                override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                    val text = SignupPasswordEntered.text.toString()
                    if (text.isEmpty())
                        SignupPasswordEntered.error = "Your passwords must match !"
                    else if (text.length < 8) {
                        SignupPasswordEntered.error =
                            "Your passwords must be at least 8 characters in length !"
                    } else {
                        if (!checkString(text)) {
                            SignupPasswordEntered.error =
                                "Your passwords must have Capital letters, Lowercase letters, Number and Special characters !"
                        }
                    }

                }

                override fun beforeTextChanged(
                    s: CharSequence,
                    start: Int,
                    count: Int,
                    after: Int
                ) {
                }

                override fun afterTextChanged(s: Editable) {}
            })
            GoToLoginFormSignUp.setOnClickListener{
                parentFragmentManager.commit {
                    setReorderingAllowed(true)
                    val args = Bundle()
                    args.putSerializable("SignedUpAccount", account)
                    val fragment = LoginFragment()
                    fragment.arguments = args
                    add(R.id.frag_container_view, fragment)
                    addToBackStack(null)
                }
            }
            //binding.account = viewModel.account
        }


    }
    fun isEmailValid(email: CharSequence?): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }
    private fun checkString(str: String): Boolean {
        var ch: Char
        var capitalFlag = false
        var lowerCaseFlag = false
        var numberFlag = false
        var specialFlag = false
        val special = arrayListOf('!', '@', '$', '%', '^', '&', '*', '(', ')')
        for (element in str) {
            ch = element
            when {
                Character.isDigit(ch) -> {
                    numberFlag = true
                }
                Character.isUpperCase(ch) -> {
                    capitalFlag = true
                }
                Character.isLowerCase(ch) -> {
                    lowerCaseFlag = true
                }

            }
            for (i in special) {
                if (str.contains(i)) specialFlag = true
            }
            if (numberFlag && capitalFlag && lowerCaseFlag && specialFlag) return true
        }
        return false
    }
}