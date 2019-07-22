package com.example.multiplescreen.login

import android.content.Context
import com.example.multiplescreen.SessionManager
import com.example.multiplescreen.base.BasePresenter
import kotlin.math.log

class LoginPresenter(var loginView: LoginContract.View? = null)
    : BasePresenter<LoginContract.View>, LoginContract.Presenter {

    override fun onAttach(view: LoginContract.View) {
        loginView = view
    }

    override fun onDettach() {
        loginView = null
    }

    override fun login(name : String, context: Context?) {

        if (name.isEmpty()) {
            loginView?.isEmpty()

        } else{

            // simpan inputan user ke session nya
            val session= SessionManager(context)
            session.nama = name
            loginView?.intentToHome()

        }
    }
}