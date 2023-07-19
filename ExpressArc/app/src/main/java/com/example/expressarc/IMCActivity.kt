package com.example.expressarc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.expressarc.databinding.ActivityImcBinding

class IMCActivity : AppCompatActivity() {

    private lateinit var binding: ActivityImcBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityImcBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}