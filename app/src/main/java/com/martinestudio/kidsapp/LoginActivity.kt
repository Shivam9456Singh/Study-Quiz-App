package com.martinestudio.kidsapp

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.martinestudio.kidsapp.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private val binding: ActivityLoginBinding by lazy {
        ActivityLoginBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val signUp = binding.SignUpText
        signUp.setOnClickListener {
            signUp.animate().apply {
                duration = 1000
                withStartAction {
                    signUp.setTextColor(resources.getColor(R.color.green))
                }
                withEndAction {
                    signUp.setTextColor(resources.getColor(R.color.black))
                }
                start()
            }
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }

        val enteredPhone = binding.enteredPhone
        val enteredPassword = binding.enteredPassword
        val passwordReset = binding.tvForgotPassword

//        passwordReset.setOnClickListener {
//            val intent = Intent(this,ForgotPasswordActivity::class.java)
//            startActivity(intent)
//        }
    }
}