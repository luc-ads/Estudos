package com.example.expressarc.recycler

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.expressarc.databinding.ItemRecyclerBinding
import com.example.expressarc.model.MainItem

class AdapterMain(private val context: Context, private val list: List<MainItem>
): RecyclerView.Adapter<AdapterMain.MainViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val binding = ItemRecyclerBinding.inflate(LayoutInflater.from(parent.context),parent, false)
        return MainViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val item = list[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class MainViewHolder(itemRecycler: ItemRecyclerBinding): ViewHolder(itemRecycler.root) {

        private val txtNameButton: TextView
        private val button = itemRecycler.btnClique

        init {
            txtNameButton = itemRecycler.txtNameButton
        }

        fun bind(mainItem: MainItem) {
            txtNameButton.setText(mainItem.textStringId)
            button.setOnClickListener {
                Toast.makeText(context, "Clicou no button", Toast.LENGTH_SHORT).show()
            }
            button.setImageResource(mainItem.drawableId)
        }
    }
}