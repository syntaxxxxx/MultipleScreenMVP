package com.example.multiplescreen.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.multiplescreen.MainActivity
import com.example.multiplescreen.R

class SplashActivity : AppCompatActivity(), SplashContract.View {

    override fun toActivity() {
        startActivity(
            Intent(
                this@SplashActivity, MainActivity::class.java
            )
        )
        finish()
    }

    override fun welcomeMessage() {
        Toast.makeText(this, "Hi selamat", Toast.LENGTH_LONG).show()
    }

    lateinit var presenter: SplashPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        initPresenter()

        presenter.delaySplash(1000)
    }

    private fun initPresenter() {
        presenter = SplashPresenter()
    }

    override fun onAttachView() {
        presenter.onAttach(this)

    }

    override fun onDettachView() {
        presenter.onDettach()
    }

    override fun onStart() {
        super.onStart()
        onAttachView()
    }

    override fun onDestroy() {
        super.onDestroy()
        onDettachView()
    }
}