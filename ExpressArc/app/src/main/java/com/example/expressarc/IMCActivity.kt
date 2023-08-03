package com.example.expressarc

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.annotation.StringRes
import androidx.appcompat.app.AlertDialog
import com.example.expressarc.databinding.ActivityImcBinding
import com.example.expressarc.roomModel.Calc

class IMCActivity : AppCompatActivity() {

    private lateinit var binding: ActivityImcBinding
    private var resultCalcImc = 0.0
    private var resultRangeImc: Int = 0

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

                resultCalcImc = calcImc(editImcWeight.text.toString().toInt(), editImcHeight.text.toString().toInt())
                resultRangeImc = rangeImcResult(resultCalcImc)
                AlertDialog.Builder(this@IMCActivity)
                    //.setTitle(getString(R.string.imc_response, resultRangeImc))
                    .setTitle("Seu IMC: $resultRangeImc")
                    .setMessage(resultRangeImc)
                    .setPositiveButton(R.string.ok) { dialog, _ ->
                        dialog.dismiss()
                    }
                    .setNegativeButton(R.string.save) { dialog, _  ->
                        val app = (application as App)
                        val dao = app.db.calcDao()
                        Thread {
                            dao.insert(
                                Calc(
                                    type = "imc",
                                    res = resultCalcImc
                                )
                            )
                        }.start()

                    }
                    .create()
                    .show()

                val service = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                service.hideSoftInputFromWindow(currentFocus?.windowToken, 0)
            }
        }
    }

    @StringRes
    private fun rangeImcResult(resultCalcImc: Double): Int {
        return when {
            resultCalcImc < 15.0 -> R.string.imc_severely_low_weight
            resultCalcImc < 16.0 -> R.string.imc_very_low_weight
            resultCalcImc < 18.5 -> R.string.imc_low_weight
            resultCalcImc < 25.0 -> R.string.normal
            resultCalcImc < 30.0 -> R.string.imc_high_weight
            resultCalcImc < 35.0 -> R.string.imc_so_high_weight
            resultCalcImc < 40.0 -> R.string.imc_severely_high_weight
            else -> R.string.imc_extreme_weight
        }
    }

    private fun calcImc(weight: Int, height: Int): Double {
        return weight / ( ( height / 100.0 ) * (height / 100.0) )
    }
}