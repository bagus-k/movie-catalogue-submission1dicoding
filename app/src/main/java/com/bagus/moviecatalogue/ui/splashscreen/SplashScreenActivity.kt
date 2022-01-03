package com.bagus.moviecatalogue.ui.splashscreen

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.bagus.moviecatalogue.R
import com.bagus.moviecatalogue.databinding.ActivitySplashScreenBinding
import com.bagus.moviecatalogue.ui.home.HomeActivity

class SplashScreenActivity : AppCompatActivity() {

    private val SPLASH_TIME_OUT = 1000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val splashScreenBinding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(splashScreenBinding.root)

        if (supportActionBar != null) {
            supportActionBar!!.hide()
        }

        splashScreenBinding.splashScreenLogo.setImageResource(R.drawable.movie_logo)

        Handler().postDelayed({
            val intent = Intent(this@SplashScreenActivity, HomeActivity::class.java)
            startActivity(intent)
            finish()
        }, SPLASH_TIME_OUT.toLong())
    }
}