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
import it.ezzie.kotlin_movie_app.R
import it.ezzie.kotlin_movie_app.databinding.ActivityForgetPasswordBinding

class ForgetPassword : AppCompatActivity() {
    private lateinit var binding : ActivityForgetPasswordBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityForgetPasswordBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initListener();
    }
    private fun initListener(){
        binding.btnSendEmail.setOnClickListener {
            val mail = binding.emailLayout.editText!!.text.toString()
            if(TextUtils.isEmpty(mail)){
                binding.emailLayout.error = "Please Enter Email"
                binding.emailLayout.requestFocus()
            }
            else{
                forgetPassword(mail)
            }
        }

    }
    private fun forgetPassword(mail : String){
        FirebaseAuth.getInstance().sendPasswordResetEmail(mail).addOnCompleteListener { task ->
            if(task.isSuccessful){
                val intent = Intent(this, EmailSend::class.java)
                startActivity(intent)
            }
            else{
                Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
            }
        }
    }
}