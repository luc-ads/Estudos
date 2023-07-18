package com.example.expressarc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.expressarc.databinding.ActivityMainBinding
import java.util.Random

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            sorteio(binding.editNumber.text.toString())
        }
    }

    private fun sorteio(valorDigitado: String) {

        if (valorDigitado.isEmpty()) {
            toastAlert("Insira um valor entre 6 e 15!")
            return
        }

        val convertValue = valorDigitado.toInt()
        if (convertValue < 6 || convertValue > 15) {
            toastAlert("Insira um valor entre 6 e 15!")
            return
        }

        val numbers = mutableSetOf<Int>()
        val random = Random()

        while (true) {
            val numberThis = random.nextInt(60)

            numbers.add(numberThis + 1)
            if (numbers.size == convertValue) break
        }

        binding.txtResult.text = numbers.joinToString(" - ")
    }

    private fun toastAlert(alertMessage: String) {
        Toast.makeText(this, alertMessage, Toast.LENGTH_SHORT).show()
    }
}