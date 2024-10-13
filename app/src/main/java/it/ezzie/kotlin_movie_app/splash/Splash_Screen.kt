package it.ezzie.kotlin_movie_app.splash

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import it.ezzie.kotlin_movie_app.MainActivity
import it.ezzie.kotlin_movie_app.R
import it.ezzie.kotlin_movie_app.databinding.ActivitySplashScreenBinding

class Splash_Screen : AppCompatActivity() {
    private lateinit var binding : ActivitySplashScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initSplash();
    }

    private fun initSplash() {
        val splashImg = binding.splashScreen
        splashImg.alpha = 0f
        splashImg.animate().setDuration(2000).alpha(1f).withEndAction {
            overridePendingTransition(android.R.animator.fade_in, android.R.animator.fade_out)
            finish()
            var intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}