package com.example.foodapp.Profile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.foodapp.R
import com.example.foodapp.UserAccount
import com.example.foodapp.databinding.ActivityProfileBinding
import kotlinx.android.synthetic.main.edit_profile_dialog.view.*
import kotlinx.android.synthetic.main.activity_profile.*

class ProfileActivity : AppCompatActivity() {

    private lateinit var binding : ActivityProfileBinding
    private lateinit var viewModel : ProfileViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_profile)
        viewModel = ViewModelProvider(this).get(ProfileViewModel::class.java)
        back_from_profile.setOnClickListener{
            finish()
        }

        var intent = intent
        viewModel.account.value = intent.getSerializableExtra("account") as UserAccount

        binding.apply {
            edit_profile_button.setOnClickListener{changeInfo()}
            newname.setOnClickListener{changeInfo()}
            newnumber.setOnClickListener{changeInfo()}
            newemail.setOnClickListener{changeInfo()}
            account = viewModel.account.value
        }
        val accObserver = Observer<UserAccount>{ newData ->
            Username.text = newData.name
            newname.text = newData.name
            newemail.text = newData.email
            newnumber.text = newData.password
        }
        viewModel.account.observe(this, accObserver)
    }

    private fun changeInfo() {
        val mDialogView = LayoutInflater.from(this).inflate(R.layout.edit_profile_dialog, null)
        //AlertDialogBuilder
        val mBuilder = AlertDialog.Builder(this).setView(mDialogView).setTitle("Edit Profile")
        //show dialog
        val  mAlertDialog = mBuilder.show()
        //login button click of custom layout
        mDialogView.change_confirm_button.setOnClickListener {
            //get text from EditTexts of custom layout
            viewModel.account.value?.name = mDialogView.dialogNameEt.text.toString()
            viewModel.account.value?.email = mDialogView.dialogEmailEt.text.toString()
            viewModel.account.value?.password = mDialogView.dialogPasswEt.text.toString()

            Toast.makeText(this@ProfileActivity,"Profile updated",Toast.LENGTH_SHORT).show()

            //set the input text in TextView
            viewModel.account.postValue(viewModel.account.value)
            mAlertDialog.dismiss()
        }
    }
}