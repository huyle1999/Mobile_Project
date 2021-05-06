package com.thesis.android_challenge_w3

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.fragment.app.replace

import kotlinx.android.synthetic.main.fragment_sign_up.btn_sign_in

class SignUpFragment : Fragment(){

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sign_up, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btn_sign_in.setOnClickListener {
            parentFragmentManager.commit {
                setReorderingAllowed(true)
                replace<SignInFragment>(R.id.frag_container_view)
                addToBackStack(null)
            }
        }

    }
}