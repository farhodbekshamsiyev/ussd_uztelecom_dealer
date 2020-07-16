package com.farhod.ussd_uztelecom_dealer.fragments

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.content.res.AppCompatResources.getDrawable
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.farhod.ussd_uztelecom_dealer.MainActivity
import com.farhod.ussd_uztelecom_dealer.R
import com.farhod.ussd_uztelecom_dealer.WebView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.cardview_1.*
import kotlinx.android.synthetic.main.fragment_kuproq.*


class Fragment_Kuproq : Fragment() {

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setHasOptionsMenu(true)
        return inflater.inflate(R.layout.fragment_kuproq, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (activity as AppCompatActivity).setSupportActionBar(toolbar_kuproq as Toolbar?)
        (activity as AppCompatActivity).supportActionBar?.title = "Ko'proq"
        (activity as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)

        kuproq_card_yangiliklar.setOnClickListener(listener)
        kuproq_card_aksiya.setOnClickListener(listener)
        kuproq_card_xabar.setOnClickListener(listener)
        kuproq_card_yordam.setOnClickListener(listener)
        kuproq_card_ilova_haqida.setOnClickListener(listener)
        kuproq_card_uzimei.setOnClickListener(listener)

    }

    private val listener = View.OnClickListener { view ->
        when (view.id) {
            R.id.kuproq_card_yangiliklar -> openActivity(
                "Yangiliklar", getString(
                    R.string.url_yangiliklar
                )
            )

            R.id.kuproq_card_aksiya -> openActivity(
                "Aksiyalar", getString(
                    R.string.url_aksiya
                )
            )

            R.id.kuproq_card_xabar -> openActivity(
                "Xabarnomalar", getString(
                    R.string.url_xabar
                )
            )

            R.id.kuproq_card_yordam -> openActivity(
                "Yordam", getString(
                    R.string.url_yordam
                )
            )

            R.id.kuproq_card_ilova_haqida -> openActivity(
                "Ommaviy oferta", getString(
                    R.string.url_oferta
                )
            )

            R.id.kuproq_card_uzimei -> openActivity(
                "UzImei", getString(
                    R.string.url_uzimei
                )
            )
        }
    }

    private fun openActivity(titlebar: String, web_name: String) {
        val intent = Intent(context, WebView::class.java)
        intent.putExtra("param1", titlebar)
        intent.putExtra("param2", web_name)
        startActivity(intent)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                (activity as MainActivity).btm_nav_view.selectedItemId = R.id.asosiy
                (activity as MainActivity).startFragment(Fragment_Asosiy.newInstance())
            }
        }
//        btm_nav_view.itemIconTintList = null;
        return super.onOptionsItemSelected(item)
    }

    companion object {
        fun newInstance() =
            Fragment_Kuproq()
    }

}