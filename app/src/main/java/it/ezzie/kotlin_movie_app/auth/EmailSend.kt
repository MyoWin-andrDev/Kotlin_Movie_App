package it.ezzie.kotlin_movie_app.auth

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import it.ezzie.kotlin_movie_app.R
import it.ezzie.kotlin_movie_app.databinding.ActivityEmailSendBinding

class EmailSend : AppCompatActivity() {
    private lateinit var binding : ActivityEmailSendBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityEmailSendBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initBtn()
    }

    private fun initBtn() {
        binding.btnBackToLogin.setOnClickListener{
            val intent = Intent(this, Login::class.java)
            startActivity(intent)
        }
    }
}