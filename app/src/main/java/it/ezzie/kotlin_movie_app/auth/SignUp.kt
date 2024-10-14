package it.ezzie.kotlin_movie_app.auth

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import it.ezzie.kotlin_movie_app.R
import it.ezzie.kotlin_movie_app.databinding.ActivitySignUpBinding

class SignUp : AppCompatActivity() {
    private lateinit var binding : ActivitySignUpBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initEditText();
    }
    private fun initEditText(){
        var mail = binding.emailInput!!.text
        var password = binding.passwordInput.text
    }
}