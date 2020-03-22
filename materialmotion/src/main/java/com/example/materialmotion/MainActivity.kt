package com.example.materialmotion

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        configureAdapter()
    }

    private fun configureAdapter(){
        val stringList = resources.getStringArray(R.array.Items)
        val adapter = ItemAdapter(this,stringList.toList())
        itemRecyclerView.adapter = adapter
        itemRecyclerView.layoutManager = LinearLayoutManager(this)
    }
}
