package com.example.expressarc

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.expressarc.databinding.ActivityMainBinding
import com.example.expressarc.model.MainItem
import com.example.expressarc.recycler.AdapterMain

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    val listName = mutableListOf<MainItem>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        binding.linearImc.setOnClickListener {
//            startActivity(Intent(this, IMCActivity::class.java))
//        }

        repeat(20) {
            listName.add(
                MainItem(
                    id = 1,
                    drawableId = R.drawable.ic_launcher_background,
                    textStringId = R.string.imc_response,
                    color = Color.GREEN
                ),
            )
        }

        binding.rvMain.adapter = AdapterMain(this, listName)
        binding.rvMain.layoutManager = GridLayoutManager(this, 2)

    }
}