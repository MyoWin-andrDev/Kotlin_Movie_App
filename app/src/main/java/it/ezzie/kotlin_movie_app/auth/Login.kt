package it.ezzie.kotlin_movie_app.auth

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import it.ezzie.kotlin_movie_app.R
import it.ezzie.kotlin_movie_app.databinding.ActivityLoginBinding

class Login : AppCompatActivity() {
    private lateinit var binding : ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnCreate.setOnClickListener{
            var intent = Intent(this, SignUp::class.java)
            startActivity(intent)
            finish()
        }
    }
}