package com.thesis.android_challenge_w3

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.thesis.android_challenge_w3.R
import kotlinx.android.synthetic.main.onboarding_one_fragment.*

class OnBoardingOneFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.onboarding_one_fragment, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btn_next.setOnClickListener {
            parentFragmentManager.commit {
                setReorderingAllowed(true)
                replace<OnBoardingTwoFragment>(R.id.frag_container_view)
                addToBackStack(null)
            }
        }
    }
}



