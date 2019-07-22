package com.example.multiplescreen.splash

import com.example.multiplescreen.base.BasePresenter
import java.util.logging.Handler

class SplashPresenter(var splashView: SplashContract.View? = null) : BasePresenter<SplashContract.View>,
    SplashContract.Presenter {

    override fun onAttach(view: SplashContract.View) {
        splashView = view
    }

    override fun onDettach() {
        splashView = null
    }

    override fun delaySplash(timer: Long) {
        android.os.Handler().postDelayed(Runnable {
            splashView?.toActivity()
            splashView?.welcomeMessage()
        }, timer)
    }
}