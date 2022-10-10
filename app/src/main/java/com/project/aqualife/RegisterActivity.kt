package com.project.aqualife

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.project.aqualife.databinding.RegisterActivityBinding

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding : RegisterActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = RegisterActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val register = binding.register

        register.setOnClickListener {
            finish()
        }
    }
}