package com.example.multiplescreen.login

import android.content.Context
import com.example.multiplescreen.base.BaseView

interface LoginContract {

    interface Presenter{
        fun login(name : String, context: Context?)
    }

    interface View : BaseView {
        fun isEmpty()
        fun intentToHome()
    }
}