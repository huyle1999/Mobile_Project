package com.example.foodapp.Login

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.foodapp.Movie.MovieActivity
import com.example.foodapp.UserAccount
import com.example.foodapp.databinding.LogInFragmentBinding
import kotlinx.android.synthetic.main.log_in_fragment.*


class LoginFragment : Fragment() {
    private lateinit var binding : LogInFragmentBinding
    private lateinit var viewModel: LoginViewModel
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
        binding = LogInFragmentBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        back_from_login.setOnClickListener {
            parentFragmentManager.popBackStack()
        }
        val args = arguments
        val loginAccount : UserAccount = args?.getSerializable("SignedUpAccount") as UserAccount
        binding.apply {
            LoginButton.setOnClickListener{
                if(LoginEmailEntered.text.toString() != loginAccount.email)
                    Toast.makeText(
                        activity,
                        "This email is not existed!",
                        Toast.LENGTH_SHORT
                    ).show()
                else if(LoginPasswordEntered.text.toString() != loginAccount.password)
                    Toast.makeText(activity, "Wrong password", Toast.LENGTH_SHORT).show()
                else
                {
                    //val intent = Intent(activity, RestaurantsActivity::class.java)
                    val intent = Intent(activity, MovieActivity::class.java)
                    //intent.putExtra("account",loginAccount)

                    startActivity(intent)
                }
            }
            binding.inputAccount = viewModel.account
        }

    }
}
