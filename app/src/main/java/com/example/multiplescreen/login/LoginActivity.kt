package com.example.multiplescreen.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.multiplescreen.MainActivity
import com.example.multiplescreen.R
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(), LoginContract.View {

    lateinit var presenter: LoginPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        initPresenter()
        initBtnListener()
    }

    private fun initPresenter() {
        presenter = LoginPresenter()
    }

    private fun initBtnListener() {
        btn_submit.setOnClickListener {
            presenter.login(edt_nama.text.toString().trim(), this@LoginActivity)
        }
    }

    override fun onAttachView() {
        presenter.onAttach(this)
    }

    override fun onDettachView() {
        presenter.onDettach()
    }

    override fun isEmpty() {
        Toast.makeText(
            this,
            "tidak boleh kosong",
            Toast.LENGTH_SHORT).show()
    }

    override fun intentToHome() {
        startActivity(Intent(
            this@LoginActivity,
            MainActivity::class.java))
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
