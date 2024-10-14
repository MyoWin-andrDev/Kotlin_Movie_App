package it.ezzie.kotlin_movie_app.auth

import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
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
        binding.btnSignUp.setOnClickListener{
            var mail = binding.emailLayout.editText!!.text.toString()
            var password = binding.passwordLayout.editText!!.text.toString()

            if(TextUtils.isEmpty(mail)){
                binding.emailError.text = "Please enter email address"
                binding.emailError.requestFocus()
            }
            else if(TextUtils.isEmpty(password)){
                binding.passwordError.text = "Please enter password"
                binding.passwordError.requestFocus()
            }
            else{
                Toast.makeText(this, "Created Successfully", Toast.LENGTH_SHORT).show()
            }
        }
    }
}