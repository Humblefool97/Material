package com.example.sharedelementtransition

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        GameListFragment.addFragmentToActivity(R.id.fragmentContainer,supportFragmentManager)
    }
}
