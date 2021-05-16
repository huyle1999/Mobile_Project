package com.example.foodapp.OnBoarding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import androidx.fragment.app.add
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.example.foodapp.R
import com.example.foodapp.Welcome.WelcomeFragment

class AllOnBoardingFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.all_on_boarding_fragment, container, false)
        return view
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        childFragmentManager.commit {
            setReorderingAllowed(true)
            add<OnBoardingFragment>(R.id.on_boarding_frag)
        }
        val button = view.findViewById<ImageButton>(R.id.movewel)
        button.setOnClickListener {
            parentFragmentManager.commit {
                setReorderingAllowed(true)
                replace<WelcomeFragment>(R.id.frag)
                addToBackStack(null)
            }
        }
    }


}