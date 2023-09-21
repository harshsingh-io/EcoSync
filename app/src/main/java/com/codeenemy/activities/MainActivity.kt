package com.codeenemy.ecosync.activities

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatDelegate
import com.codeenemy.ecosync.R
import com.codeenemy.ecosync.databinding.ActivityMainBinding
import com.codeenemy.ecosync.databinding.ActivityMyProfileBinding
import com.codeenemy.ecosync.models.User
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : BaseActivity() {
    private var binding: ActivityMainBinding? = null
    private lateinit var bottomNavigationView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        bottomNavigationView = findViewById(R.id.bottomNavigationView)

        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.home -> {
                    startActivity(Intent(this, MainActivity::class.java))
                    return@setOnNavigationItemSelectedListener true
                }

                R.id.statistic -> {
                    startActivity(Intent(this, StatisticActivity::class.java))
                    return@setOnNavigationItemSelectedListener true
                }

                R.id.user_profile -> {
                    startActivity(Intent(this, UserProfileActivity::class.java))
                    return@setOnNavigationItemSelectedListener true
                }

                else -> return@setOnNavigationItemSelectedListener false
            }
        }
        bottomNavigationView.selectedItemId = R.id.home
    }

    fun updateNavigationUserDetails(user: User) {
        val intent = Intent(this, ActivityMyProfileBinding::class.java)
        intent.putExtra("user", user)
        startActivity(intent)
    }
}