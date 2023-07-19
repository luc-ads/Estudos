package com.example.expressarc

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.expressarc.databinding.ActivityMainBinding
import java.util.Random

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var prefs: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        prefs = getSharedPreferences("db", Context.MODE_PRIVATE)
        val result = prefs.getString("numbers", null)

        result.let {
            binding.txtResult.text = "Última aposta feita: $it"
        }

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

        val editor = prefs.edit()
        editor.putString("numbers", binding.txtResult.text.toString())
        editor.apply()
    }

    private fun toastAlert(alertMessage: String) {
        Toast.makeText(this, alertMessage, Toast.LENGTH_SHORT).show()
    }
}