package com.example.expressarc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.expressarc.roomModel.Calc
import java.lang.IllegalStateException

class ListCalcActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_calc)

        val type = intent?.extras?.getString("type") ?: throw IllegalStateException("parameter imc from intent not found")

        Thread {

            val app = application as App
            val dao = app.db.calcDao()
            val result = dao.getRegisterByType(type)

            runOnUiThread {
                result.forEach {
                    Log.i("resultCalcList", it.toString())
                }
            }

        }.start()

    }
}