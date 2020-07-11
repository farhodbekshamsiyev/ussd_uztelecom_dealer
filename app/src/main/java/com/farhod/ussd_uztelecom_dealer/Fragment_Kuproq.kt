package com.farhod.ussd_uztelecom_dealer

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_kuproq.*


class Fragment_Kuproq : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val root: View = inflater.inflate(R.layout.fragment_kuproq, container, false)
        val toolbar: Toolbar = root.findViewById(R.id.toolbar_kuproq)
        (activity as AppCompatActivity).setSupportActionBar(toolbar)
        (activity as AppCompatActivity).supportActionBar?.title = "Ko'proq"
        (activity as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        kuproq_card_yangiliklar.setOnClickListener(listener)
        kuproq_card_aksiya.setOnClickListener(listener)
        kuproq_card_xabar.setOnClickListener(listener)
        kuproq_card_yordam.setOnClickListener(listener)
        kuproq_card_ilova_haqida.setOnClickListener(listener)
        kuproq_card_uzimei.setOnClickListener(listener)

    }

    private val listener = View.OnClickListener { view ->
        when (view.id) {
            R.id.kuproq_card_yangiliklar -> openActivity("Yangiliklar", getString(R.string.url_yangiliklar))

            R.id.kuproq_card_aksiya -> openActivity("Aksiyalar", getString(R.string.url_aksiya))

            R.id.kuproq_card_xabar -> openActivity("Xabarnomalar", getString(R.string.url_xabar))

            R.id.kuproq_card_yordam -> openActivity("Yordam", getString(R.string.url_yordam))

            R.id.kuproq_card_ilova_haqida -> openActivity("Ommaviy oferta", getString(R.string.url_oferta))

            R.id.kuproq_card_uzimei -> openActivity("UzImei", getString(R.string.url_uzimei))
        }
    }

    private fun openActivity(titlebar: String, web_name: String) {
        val intent = Intent(context, WebView::class.java)
        intent.putExtra("param1", titlebar)
        intent.putExtra("param2", web_name)
        startActivity(intent)
    }

    companion object {
        fun newInstance() = Fragment_Kuproq()
    }

}