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
import androidx.recyclerview.widget.RecyclerView
import com.farhod.ussd_uztelecom_dealer.MainActivity
import com.farhod.ussd_uztelecom_dealer.R
import com.farhod.ussd_uztelecom_dealer.adapter.ExpandableAdapter
import com.farhod.ussd_uztelecom_dealer.adapter.RecycleriViewAdapter
import com.farhod.ussd_uztelecom_dealer.data_classes.Group_Expandable
import com.farhod.ussd_uztelecom_dealer.data_classes.TarifData
import com.farhod.ussd_uztelecom_dealer.inputStreamToString
import com.farhod.ussd_uztelecom_dealer.model.ChildItemDataClass
import com.farhod.ussd_uztelecom_dealer.model.ModelGSON
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_daqiqalar.*
import kotlinx.android.synthetic.main.fragment_tariflar.*


class Fragment_Tariflar : Fragment() {

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setHasOptionsMenu(true)
        return inflater.inflate(R.layout.fragment_tariflar, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (activity as AppCompatActivity).setSupportActionBar(toolbar_tariflar as Toolbar?)
        (activity as AppCompatActivity).supportActionBar?.title = "Barcha tariflar"
        (activity as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)
//        toolbar.inflateMenu(R.menu.nav_menu)

        val preferences = (activity as AppCompatActivity).getSharedPreferences("ussd_dealer", Context.MODE_PRIVATE)
        val strData = preferences.getString("data", "")

//        val myJson =
//            inputStreamToString((activity as AppCompatActivity).resources.openRawResource(R.raw.ussdcodes))
        val myModel = Gson().fromJson(strData, ModelGSON::class.java)

        val listItem = ArrayList<ChildItemDataClass>()
        myModel?.barcha?.standartPaketlar?.let { listItem.addAll(it) }

        recycler_tariflar.layoutManager = LinearLayoutManager(context)
        recycler_tariflar.adapter = RecycleriViewAdapter(listItem, context)
    }

//    override fun onCreateOptionsMenu(menu: Menu, menuInflater: MenuInflater): Unit {
//        menuInflater.inflate(R.menu.nav_menu, menu)
//        super.onCreateOptionsMenu(menu, menuInflater)
//    }

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
            Fragment_Tariflar()
    }
}