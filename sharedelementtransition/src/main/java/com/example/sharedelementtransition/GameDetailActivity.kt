package com.example.sharedelementtransition

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class GameDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        intent.extras?.run {
            val resId = getInt(KEY_RESOURCE_ID)
            val title = getString(KEY_TITLE,"")
            val desc = getString(KEY_DESCRIPTION, "")
            GameDetailFragment.addFragment(
                this@GameDetailActivity,
                R.id.detailContainer,
                supportFragmentManager,
                resId,
                title,
                desc
            )
        }
    }

    companion object{
        const val KEY_RESOURCE_ID = "RES_ID"
        const val KEY_TITLE = "TITLE"
        const val KEY_DESCRIPTION = "DESC"
    }
}