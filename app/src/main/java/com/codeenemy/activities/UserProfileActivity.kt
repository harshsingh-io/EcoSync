package com.codeenemy.ecosync.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.codeenemy.ecosync.R
import com.codeenemy.ecosync.databinding.ActivityUserProfileBinding
import com.codeenemy.ecosync.models.User

class UserProfileActivity : AppCompatActivity() {

    private var binding: ActivityUserProfileBinding? = null
    var user = intent.getStringExtra("user")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserProfileBinding.inflate(layoutInflater)
        setContentView(binding?.root)
    }

    private fun updateProfileDetails(user: User) {
        Glide
            .with(this)
            .load(user.image)
            .centerCrop()
            .placeholder(R.drawable.ic_user_place_holder)
            .into(binding?.profileImage!!);
        binding?.tvUserName?.text = user.name
        binding?.tvUserEmail?.text = user.email
    }
}
