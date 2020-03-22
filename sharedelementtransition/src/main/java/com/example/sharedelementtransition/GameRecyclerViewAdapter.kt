package com.example.sharedelementtransition

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.sharedelementtransition.model.Game
import kotlinx.android.synthetic.main.layout_list_item.view.*

class GameRecyclerViewAdapter(
    private val context: Context,
    private val onItemSelectedCB: (Int,View) -> Unit
) :
    RecyclerView.Adapter<GameRecyclerViewAdapter.GameListViewHolder>() {
    private var gameList = emptyList<Game>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameListViewHolder {
        val view = LayoutInflater.from(context).inflate(
            R.layout.layout_list_item, parent,
            false
        )
        return GameListViewHolder(view)
    }

    override fun getItemCount(): Int = gameList.size

    override fun onBindViewHolder(holder: GameListViewHolder, position: Int) {
        val game = gameList[position]
        holder.bind(game.image, game.description, position)
    }

    fun setGameList(newGameList: List<Game>) {
        gameList = newGameList
        notifyDataSetChanged()
    }

    inner class GameListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val gameImageView: ImageView = itemView.listImageView
        val gameDesTextView: TextView = itemView.listTextView

        fun bind(imageResId: Int, text: String, pos: Int) {
            gameImageView.setImageResource(imageResId)
            gameDesTextView.text = text
            itemView.setOnClickListener {
                onItemSelectedCB.invoke(pos,gameImageView)
            }
        }
    }
}