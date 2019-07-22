package com.example.multiplescreen.base

interface BasePresenter<T : BaseView> {

    fun onAttach(view: T)
    fun onDettach()

}