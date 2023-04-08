package com.example.newrecycler

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newrecycler.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), OnBuahItemClickListner{

    lateinit var binding: ActivityMainBinding
    lateinit var buahlist: ArrayList<Buah>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        buahlist = ArrayList()
        addCars()

        buahRecycler.layoutManager = LinearLayoutManager(this)
        buahRecycler.addItemDecoration(DividerItemDecoration(this,1))
        buahRecycler.adapter = BuahAdapter(buahlist,this)
    }

    fun addCars(){
        buahlist.add(Buah("Mangga","Warna Hijau kekuningan dengan rasaManis, Enak, dan Lezat", R.drawable.mangga) )
        buahlist.add(Buah("Manggis","Warna Ungu dengan rasa Manis, Enak, dan Lezat", R.drawable.manggis) )
        buahlist.add(Buah("Anggur","Warna Ungu dengan rasa Manis, Enak, dan Lezat", R.drawable.anggur) )
        buahlist.add(Buah("Apel","Warna Merah dengan rasa Manis, Enak, dan Lezat", R.drawable.apel) )
        buahlist.add(Buah("Pisang","Warna Kuning dengan rasa Manis, Enak, dan Lezat", R.drawable.pisang) )
        buahlist.add(Buah("Alpukat","Manis, Enak, dan Lezat jika dibuat jus", R.drawable.alpukat) )
        buahlist.add(Buah("Semangka","Hijau luar dalam Merah Manis, Enak, dan Lezat", R.drawable.semangka) )
    }

    override fun onItemClick(item: Buah, position: Int) {
        val intent = Intent(this, BuahDetailsActivity::class.java)
        intent.putExtra("BUAHNAME", item.name)
        intent.putExtra("BUAHDESC", item.description)
        intent.putExtra("BUAHLOGO", item.logo.toString())
        startActivity(intent)


    }
}
