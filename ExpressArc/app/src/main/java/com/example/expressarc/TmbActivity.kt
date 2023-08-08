package com.example.expressarc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.expressarc.databinding.ActivityTmbBinding

class TmbActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTmbBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTmbBinding.inflate(layoutInflater)
        setContentView(binding.root)




    }
}