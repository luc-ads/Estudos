package com.example.expressarc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.example.expressarc.databinding.ActivityImcBinding

class IMCActivity : AppCompatActivity() {

    private lateinit var binding: ActivityImcBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityImcBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.txtOne.setOnClickListener {
            binding.txtOne.setBackgroundColor(ContextCompat.getColor(this, R.color.pink))
            binding.txtTwo.setBackgroundColor(ContextCompat.getColor(this, R.color.white_gray))
            binding.txtThree.setBackgroundColor(ContextCompat.getColor(this, R.color.white_gray))
        }
        binding.txtTwo.setOnClickListener {
            binding.txtOne.setBackgroundColor(ContextCompat.getColor(this, R.color.white_gray))
            binding.txtTwo.setBackgroundColor(ContextCompat.getColor(this, R.color.pink))
            binding.txtThree.setBackgroundColor(ContextCompat.getColor(this, R.color.white_gray))
        }
        binding.txtThree.setOnClickListener {
            binding.txtOne.setBackgroundColor(ContextCompat.getColor(this, R.color.white_gray))
            binding.txtTwo.setBackgroundColor(ContextCompat.getColor(this, R.color.white_gray))
            binding.txtThree.setBackgroundColor(ContextCompat.getColor(this, R.color.pink))
        }
    }
}