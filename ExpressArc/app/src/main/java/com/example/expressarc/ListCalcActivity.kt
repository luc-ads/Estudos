package com.example.expressarc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.expressarc.databinding.ActivityListCalcBinding
import com.example.expressarc.recycler.AdapterListCalcResult
import java.lang.IllegalStateException

class ListCalcActivity : AppCompatActivity() {

    private lateinit var binding: ActivityListCalcBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListCalcBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initValues()
    }

    private fun initValues() {

        val type = intent?.extras?.getString("type") ?: throw IllegalStateException("parameter imc from intent not found")

        Thread {
            val app = application as App
            val dao = app.db.calcDao()
            val result = dao.getRegisterByType(type)

            runOnUiThread {
                result.forEach {
                    Log.i("resultCalcList", it.toString())
                }
                binding.rvListCalc.adapter = AdapterListCalcResult(result)
            }

        }.start()


    }
}