package it.ezzie.kotlin_movie_app.auth

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.auth.FirebaseAuth
import it.ezzie.kotlin_movie_app.MainActivity
import it.ezzie.kotlin_movie_app.R
import it.ezzie.kotlin_movie_app.databinding.ActivityLoginBinding
import it.ezzie.kotlin_movie_app.view.HomePage

class Login : AppCompatActivity() {
    private lateinit var binding : ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initBtnListener();

    }

    private fun initBtnListener() {
        binding.btnLogIn.setOnClickListener{
            val mail = binding.emailLayout.editText!!.text.toString()
            val password = binding.passwordLayout.editText!!.text.toString()
            if(TextUtils.isEmpty(mail) && TextUtils.isEmpty(password)){
                binding.emailLayout.error = "Please Enter Email"
                binding.emailLayout.requestFocus()
                binding.passwordLayout.error = "Please Enter Password"
                binding.passwordLayout.requestFocus()
            }
            else if(TextUtils.isEmpty(mail)){
                binding.emailLayout.error = "Please Enter Email"
                binding.emailLayout.requestFocus()
            }
            else if(TextUtils.isEmpty(password)){
                binding.passwordLayout.error = "Please Enter Password"
                binding.passwordLayout.requestFocus()
            }

            else{
                loginAccount(mail, password)
            }
        }
        binding.btnCreate.setOnClickListener{
            var intent = Intent(this, SignUp::class.java)
            startActivity(intent)
        }
        binding.forgetPwdText.setOnClickListener{
            val intent = Intent(this, ForgetPassword::class.java)
            startActivity(intent)
        }
    }
    private fun loginAccount(mail : String, password : String){
        FirebaseAuth.getInstance().signInWithEmailAndPassword(mail, password).addOnCompleteListener { task ->
            if(task.isSuccessful){
                Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, HomePage::class.java)
                startActivity(intent)
            }
            else{
                Toast.makeText(this, "Login Failed", Toast.LENGTH_SHORT).show()
            }
        }
    }
}