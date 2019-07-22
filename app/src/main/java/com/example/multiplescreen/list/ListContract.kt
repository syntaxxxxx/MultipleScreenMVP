package com.example.multiplescreen.list

import com.example.multiplescreen.base.BaseView
import com.example.multiplescreen.model.Player

interface ListContract {

    interface Presenter{
        fun getData(player: List<Player>)
    }

    interface View : BaseView {

    }

}