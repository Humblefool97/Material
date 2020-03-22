package com.example.materialmotion

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.layout_list_item.view.*

class ItemAdapter(private val context: Context, private val itemList: List<String>) :
    RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.layout_list_item, parent, false)
        return ItemViewHolder(view)
    }

    override fun getItemCount(): Int = itemList.size

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val textToBeDisplayed = itemList[position]
        holder.bind(textToBeDisplayed)
    }

    inner class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val listItemText: TextView = view.textItem

        fun bind(text: String) {
            listItemText.text = text
        }
    }
}