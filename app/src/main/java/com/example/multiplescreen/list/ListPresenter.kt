package com.example.multiplescreen.list

import android.content.Context
import com.example.multiplescreen.R
import com.example.multiplescreen.base.BasePresenter
import com.example.multiplescreen.model.Player

class ListPresenter(
    val context: Context?,
    var players: MutableList<Player> = mutableListOf()
    , var listView: ListContract.View? = null
) :
    BasePresenter<ListContract.View>, ListContract.Presenter {

    override fun onAttach(view: ListContract.View) {
        listView = view
    }

    override fun onDettach() {
        listView = null
    }

    override fun getData(player: List<Player>) {

        // get data dari resource ny
        val namePlayer = context?.resources?.getStringArray(R.array.player_name)
        val imagesPlayer = context?.resources?.obtainTypedArray(R.array.images_Player)

        // clear data nya
        players.clear()

        // proses looping dari resource ny
        for (i in namePlayer?.indices!!) {
            players.add(
                Player(
                    imagesPlayer?.getResourceId(i, 0)!!,
                    namePlayer[i]
                )
            )
        }
    }
}