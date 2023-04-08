package com.example.newrecycler

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.newrecycler.databinding.ActivityBuahDetailsBinding
import kotlinx.android.synthetic.main.activity_buah_details.*

class BuahDetailsActivity : AppCompatActivity() {
    lateinit var binding : ActivityBuahDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_buah_details)

        buah_name.text = getIntent().getStringExtra("BUAHNAME")
        buah_description.text = getIntent().getStringExtra("BUAHDESC")
        getIntent().getStringExtra("BUAHLOGO")?.let { image_buah.setImageResource(it.toInt()) }

    }
}
