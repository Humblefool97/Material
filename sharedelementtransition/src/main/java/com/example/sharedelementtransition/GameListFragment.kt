package com.example.sharedelementtransition

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityOptionsCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sharedelementtransition.model.Game
import kotlinx.android.synthetic.main.layout_fragment_game_list.*

class GameListFragment : Fragment() {
    private lateinit var gameList: List<Game>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupData()
    }

    private fun setupData() {
        val list: ArrayList<Game> = ArrayList<Game>()
        val descriptionArray = resources.getStringArray(R.array.imageDesc)
        val nameArray = resources.getStringArray(R.array.gameName)
        for (i in 0..2) {
            val game = Game().also {
                it.image = when (i) {
                    0 -> R.drawable.image_aso
                    1 -> R.drawable.image_daysgone
                    2 -> R.drawable.image_spidey
                    else -> {
                        -1
                    }
                }
                it.description = descriptionArray[i]
                it.name = nameArray[i]
            }
            list.add(game)
        }
        gameList = list
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.layout_fragment_game_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        gameRecyclerView.layoutManager = LinearLayoutManager(activity)
        val adapter = GameRecyclerViewAdapter(activity as Context, ::onItemSelected)

        gameRecyclerView.adapter = adapter
        adapter.setGameList(gameList)
        setToolBar()

    }

    private fun setToolBar() {
        toolbar.title = "Shared Element Transition"
        (activity as AppCompatActivity).setSupportActionBar(toolbar)
        (activity as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    fun onItemSelected(position: Int, sharedView: View) {
        /*  GameDetailFragment.addFragment(activity!!,
              R.id.fragmentContainer
              , activity!!.supportFragmentManager,
              gameList[position].image, gameList[position].name, gameList[position].description
          )*/
        with(gameList[position]) {
            val resId = image
            val title = name
            val description = description
            val bundle = Bundle().also {
                it.putInt(GameDetailActivity.KEY_RESOURCE_ID,resId)
                it.putString(GameDetailActivity.KEY_TITLE,title)
                it.putString(GameDetailActivity.KEY_DESCRIPTION,description)
            }
            val intent = Intent(activity,GameDetailActivity::class.java).also {
               it.putExtras(bundle)
            }
            val transitionName = getString(R.string.transition_string_image)
            val options = activity?.let { ActivityOptionsCompat.makeSceneTransitionAnimation(it,sharedView,transitionName) }
            startActivity(intent,options?.toBundle())
        }

    }


    companion object {
        fun addFragmentToActivity(containerId: Int, fragmentManager: FragmentManager) {
            val gameListFragment = GameListFragment()
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(containerId, gameListFragment)
            fragmentTransaction.commit()
        }
    }
}