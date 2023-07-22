package com.example.expressarc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.expressarc.databinding.ActivityMainBinding
import com.example.expressarc.recycler.AdapterMain

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    val listName = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        binding.linearImc.setOnClickListener {
//            startActivity(Intent(this, IMCActivity::class.java))
//        }

        repeat(10) {
            listName.add("Lucas Pereira da Silva $it")
        }

        binding.rvMain.adapter = AdapterMain()
        binding.rvMain.layoutManager = LinearLayoutManager(this)
    }
}