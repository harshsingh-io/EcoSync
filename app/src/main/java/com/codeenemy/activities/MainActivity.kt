package com.codeenemy.ecosync.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.Fragment
import com.codeenemy.ecosync.R
import com.codeenemy.ecosync.databinding.ActivityMainBinding
import com.codeenemy.fragments.HomeFragment
import com.codeenemy.fragments.StatisticFragment
import com.codeenemy.fragments.UserProfileFragment

class MainActivity : AppCompatActivity() {
    private var binding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        openFragment(HomeFragment())
        binding?.bottomNavigationView?.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.home -> {
                    openFragment(HomeFragment())
//                    return@setOnNavigationItemSelectedListener true
                }

                R.id.statistic -> {
                    openFragment(StatisticFragment())
//                    return@setOnNavigationItemSelectedListener true
                }

                R.id.user_profile -> {
                    openFragment(UserProfileFragment())
//                    return@setOnNavigationItemSelectedListener true
                }

                else -> {

                }
            }
            true
        }
    }

    private fun openFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val transaction = fragmentManager.beginTransaction()
        transaction.replace(R.id.frame_layout, fragment)
        transaction.commit()
    }

    override fun onDestroy() {
        super.onDestroy()
        if (binding!=null){
            binding=null
        }
    }

}