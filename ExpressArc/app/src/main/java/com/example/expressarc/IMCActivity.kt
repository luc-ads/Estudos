package com.example.expressarc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.example.expressarc.databinding.ActivityImcBinding

class IMCActivity : AppCompatActivity() {

    private lateinit var binding: ActivityImcBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityImcBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initValues()
    }

    private fun initValues() {
        with(binding) {
            btnImcSend.setOnClickListener {
                if (editImcWeight.text.toString().isEmpty() || editImcHeight.text.toString().isEmpty() || editImcWeight.text.toString().startsWith("0") || editImcHeight.text.toString().startsWith("0")) {
                    Toast.makeText(this@IMCActivity, getString(R.string.message_error_edit_text), Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }

                calcImc(editImcWeight.text.toString().toInt(), editImcHeight.text.toString().toInt())
            }
        }
    }

    private fun calcImc(weight: Int, height: Int) {

    }
}