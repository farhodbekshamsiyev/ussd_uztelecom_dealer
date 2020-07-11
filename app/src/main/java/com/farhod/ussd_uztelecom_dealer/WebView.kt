package com.farhod.ussd_uztelecom_dealer

import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import kotlinx.android.synthetic.main.activity_web_view.*

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class WebView : AppCompatActivity() {

    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_view)
        val titleName = intent.getStringExtra(ARG_PARAM1)
        val webSite = intent.getStringExtra(ARG_PARAM2)

        setSupportActionBar(toolbar_webview as Toolbar?)
        supportActionBar?.title = titleName
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val webV: WebView = web_view
        webV.webViewClient = WebViewClient()
        webV.settings.javaScriptEnabled = true
        webV.settings.domStorageEnabled = true
        webV.overScrollMode = WebView.OVER_SCROLL_IF_CONTENT_SCROLLS
        webV.loadUrl(webSite)

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

}