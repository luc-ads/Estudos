package com.example.expressarc

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.expressarc.databinding.ActivityMainBinding
import com.example.expressarc.interfaceMain.OnClickForAdapter
import com.example.expressarc.model.MainItem
import com.example.expressarc.recycler.AdapterMain

class MainActivity : AppCompatActivity()
    //Forma 1 para onClick
    //, OnClickForAdapter
{

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

        binding.rvMain.adapter = AdapterMain(this, listName, object : OnClickForAdapter {
            // Forma 2 - colocando um objeto para existir junto com a existência desse adapter
            override fun onClick(itemPosition: Int) {
                if (itemPosition % 2 == 0) {
                startActivity(Intent(this@MainActivity, IMCActivity::class.java))
            } else {
                Toast.makeText(this@MainActivity, "Não foi possível mudar a activity", Toast.LENGTH_SHORT).show()
            }
            }
        })
        binding.rvMain.layoutManager = GridLayoutManager(this, 2)

    }

    //Forma 1 - abertura com a interface sendo agregada na Activity
//    override fun onClick(itemPosition: Int) {
//        if (itemPosition % 2 == 0){
//            startActivity(Intent(this, IMCActivity::class.java))
//        } else {
//            Toast.makeText(this, "Não foi possível mudar a activity", Toast.LENGTH_SHORT).show()
//        }
//    }
}