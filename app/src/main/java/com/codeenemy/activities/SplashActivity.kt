package com.codeenemy.ecosync.activities

import android.content.Intent
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager
import androidx.appcompat.app.AppCompatDelegate
import com.codeenemy.ecosync.databinding.ActivitySplashBinding
import com.codeenemy.ecosync.firebase.FirestoreClass

class SplashActivity : AppCompatActivity() {
    private var binding: ActivitySplashBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
    
        val typeFace: Typeface = Typeface.createFromAsset(assets, "charlie-display-bold.ttf")
        binding?.tvAppName?.typeface = typeFace

        Handler().postDelayed({
            var currentUserID = FirestoreClass().getCurrentUserId()

                startActivity(Intent(this, IntroActivity::class.java))
            finish()
        }, 2500)
    }
}