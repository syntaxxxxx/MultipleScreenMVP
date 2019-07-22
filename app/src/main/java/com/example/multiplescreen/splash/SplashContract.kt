package com.example.multiplescreen.splash

import com.example.multiplescreen.base.BaseView

interface SplashContract {

    interface Presenter {
        fun delaySplash(timer: Long)
    }

    interface View : BaseView {
        fun toActivity()
        fun welcomeMessage()
    }
}