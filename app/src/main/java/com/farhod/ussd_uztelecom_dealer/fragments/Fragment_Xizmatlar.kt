package com.farhod.ussd_uztelecom_dealer.fragments

import android.content.Context
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.content.res.AppCompatResources
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.farhod.ussd_uztelecom_dealer.MainActivity
import com.farhod.ussd_uztelecom_dealer.R
import com.farhod.ussd_uztelecom_dealer.adapter.RecyclerViewAdapter_Xizmatlar
import com.farhod.ussd_uztelecom_dealer.inputStreamToString
import com.farhod.ussd_uztelecom_dealer.model.ChildItemDataClass
import com.farhod.ussd_uztelecom_dealer.model.ModelGSON
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_xizmatlar.*


class Fragment_Xizmatlar : Fragment() {

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setHasOptionsMenu(true)
        return inflater.inflate(R.layout.fragment_xizmatlar, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (activity as AppCompatActivity).setSupportActionBar(toolbar_xizmatlar as Toolbar?)
        (activity as AppCompatActivity).supportActionBar?.title = "Barcha xizmatlar"
        (activity as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val preferences = (activity as AppCompatActivity).getSharedPreferences("ussd_dealer", Context.MODE_PRIVATE)
        val strData = preferences.getString("data", "")

//        val myJson =
//            inputStreamToString((activity as AppCompatActivity).resources.openRawResource(R.raw.ussdcodes))
        val myModel = Gson().fromJson(strData, ModelGSON::class.java)

        val listItem = ArrayList<ChildItemDataClass>()
        myModel?.xizmatlar?.standartXizmatlar?.let { listItem.addAll(it) }

        recycler_xizmatlar.layoutManager = LinearLayoutManager(context)
        recycler_xizmatlar.adapter = RecyclerViewAdapter_Xizmatlar(listItem, context)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                (activity as MainActivity).btm_nav_view.selectedItemId = R.id.asosiy
                (activity as MainActivity).startFragment(Fragment_Asosiy.newInstance())
            }
        }
        return super.onOptionsItemSelected(item)
    }

    companion object {
        fun newInstance() =
            Fragment_Xizmatlar()
    }
}