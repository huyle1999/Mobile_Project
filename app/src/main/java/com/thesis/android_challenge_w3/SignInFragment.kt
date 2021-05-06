package com.thesis.android_challenge_w3

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.thesis.android_challenge_w3.activity.signin.SignInViewModel
import com.thesis.android_challenge_w3.databinding.ActivitySignInBinding
import kotlinx.android.synthetic.main.fragment_sign_in.*
import kotlinx.android.synthetic.main.onboarding_three_fragment.*

class SignInFragment : Fragment(){

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sign_in, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btn_sign_up.setOnClickListener {

            parentFragmentManager.commit {
                setReorderingAllowed(true)
                replace<SignUpFragment>(R.id.frag_container_view)
                addToBackStack(null)
            }
        }

    }
}