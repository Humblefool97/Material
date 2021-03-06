package com.example.sharedelementtransition

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.transition.TransitionInflater
import kotlinx.android.synthetic.main.fragment_detail.*

class GameDetailFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val argBundle = arguments
        argBundle?.run {
            detailToolbar.title = getString("TITLE")
            (activity as AppCompatActivity).setSupportActionBar(detailToolbar)
            detailImage.setImageResource(getInt("RES_ID"))
            description.text = getString("DESC")
        }
    }

    companion object {
        fun addFragment(
            context: Context,
            container: Int,
            fm: FragmentManager,
            resId: Int,
            title: String,
            desc: String) {
            val bundle = Bundle().also {
                it.putInt("RES_ID", resId)
                it.putString("TITLE", title)
                it.putString("DESC", desc)
            }
            val gameDetailFragment = GameDetailFragment()
            gameDetailFragment.arguments = bundle
            val ft = fm.beginTransaction()
            ft.replace(container, gameDetailFragment)
            ft.commit()
        }
    }
}