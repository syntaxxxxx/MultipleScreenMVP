package com.example.multiplescreen.webview

import com.example.multiplescreen.base.BasePresenter

class WebViewPresenter(var webView: WebViewContract.View? = null)
    : BasePresenter<WebViewContract.View> {

    override fun onAttach(view: WebViewContract.View) {
        webView = view
    }

    override fun onDettach() {
        webView = null
    }
}