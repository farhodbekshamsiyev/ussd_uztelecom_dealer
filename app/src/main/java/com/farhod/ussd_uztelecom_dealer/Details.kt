package com.farhod.ussd_uztelecom_dealer

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.text.Html
import android.view.View
import android.webkit.WebView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.text.HtmlCompat
import kotlinx.android.synthetic.main.activity_details.*


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"
private const val ARG_PARAM3 = "param3"
private const val ARG_PARAM4 = "param4"
private const val ARG_PARAM5 = "param5"
private const val ARG_PARAM6 = "param6"
private const val ARG_PARAM7 = "param7"
private const val ARG_PARAM8 = "param8"
private const val ARG_PARAM9 = "param9"

class Details : AppCompatActivity() {

    private var title: String? = null
    private var titleType: String? = null
    private var descshort: String? = null
    private var desclong: String? = null
    private var cost: String? = null
    private var type: String? = null
    private var activate: String? = null
    private var deactivate: String? = null
    private var check: String? = null
    private var TELEPHONE_SCHEME = "tel:"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        tvTitle.text = title
        title = intent.getStringExtra(ARG_PARAM1)
        titleType = intent.getStringExtra(ARG_PARAM2)
        descshort = intent.getStringExtra(ARG_PARAM3)
        desclong = intent.getStringExtra(ARG_PARAM4)
        cost = intent.getStringExtra(ARG_PARAM5)
        type = intent.getStringExtra(ARG_PARAM6)
        activate = intent.getStringExtra(ARG_PARAM7)
        deactivate = intent.getStringExtra(ARG_PARAM8)
        check = intent.getStringExtra(ARG_PARAM9)

        tvTitleType.text = titleType
        tvTitle.text = title
        tvCosts.text = cost
        btBuy.text = type
        val webV = tvDescription
        webV.fitsSystemWindows = true
        webV.settings.domStorageEnabled = true
        webV.loadDataWithBaseURL(null, desclong, "text/html", "utf-8", null)

        tvUSSDCodeActive.text = activate
        tvUSSDCodeDeActive.text = deactivate
        tvUSSDCodeCheck.text = check
        if (tvUSSDCodeActive.text == "null") llActivating.visibility = View.GONE
        if (tvUSSDCodeDeActive.text == "null") llDeactivating.visibility = View.GONE
        if (tvUSSDCodeCheck.text == "null") llChechkingBalance.visibility = View.GONE

        llActivating.setOnClickListener(listener)
        llDeactivating.setOnClickListener(listener)
        llChechkingBalance.setOnClickListener(listener)
        btBuy.setOnClickListener(listener)

        ivClose.setOnClickListener {
            onBackPressed()
        }
    }

    private val listener = View.OnClickListener { view ->
        when (view.id) {
            R.id.llActivating -> dialPhone(activate)
            R.id.llDeactivating -> dialPhone(deactivate)
            R.id.llChechkingBalance -> dialPhone(check)
            R.id.btBuy -> dialPhone(activate)
            else -> dialPhone("*107#")
        }
    }

    fun dialPhone(number: String?) {
        val intent = Intent(Intent.ACTION_DIAL, Uri.parse(TELEPHONE_SCHEME + Uri.encode(number)))
        startActivity(intent)
    }
}