package com.example.foodapp.Welcome

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.example.foodapp.R
import com.example.foodapp.SignUp.SignUpFragment

class WelcomeFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.welcome_fragment, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val button = view.findViewById<Button>(R.id.dangnhap1)
        button.setOnClickListener {
            //val intent = Intent(activity,SignUpActivity::class.java)
            //startActivity(intent)
            parentFragmentManager.commit {
                setReorderingAllowed(true)
                replace<SignUpFragment>(R.id.frag)
                addToBackStack(null)
            }
        }
    }
}