package com.example.expressarc.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.expressarc.databinding.ItemListCalcResultBinding
import com.example.expressarc.roomModel.Calc
import java.text.SimpleDateFormat
import java.util.Locale

class AdapterListCalcResult(
    private val list: List<Calc>
    ): RecyclerView.Adapter<AdapterListCalcResult.CalcViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AdapterListCalcResult.CalcViewHolder {
        val binding = ItemListCalcResultBinding.inflate(LayoutInflater.from(parent.context),parent, false)
        return CalcViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AdapterListCalcResult.CalcViewHolder, position: Int) {
        val item = list[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int = list.size

    inner class CalcViewHolder(itemListCalcBinding: ItemListCalcResultBinding): ViewHolder(itemListCalcBinding.root) {
        private val txtID: TextView
        private val txtRes: TextView
        private val txtDate: TextView
        private val txtType: TextView

        init {
            txtID = itemListCalcBinding.txtDate
            txtRes = itemListCalcBinding.txtRes
            txtDate = itemListCalcBinding.txtDate
            txtType = itemListCalcBinding.txtType
        }

        fun bind(itemCalc: Calc) {

            val sdf = SimpleDateFormat("dd/MM/yyyy HH:mm", Locale("pt", "BR"))
            val data = sdf.format(itemCalc.createdDate)

            txtID.text = itemCalc.id.toString()
            txtRes.text = itemCalc.res.toString()
            txtDate.text = data
            txtType.text = itemCalc.type
        }
    }
}