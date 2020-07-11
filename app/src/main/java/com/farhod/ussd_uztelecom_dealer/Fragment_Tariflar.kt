package com.farhod.ussd_uztelecom_dealer

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_tariflar.*


class Fragment_Tariflar : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setHasOptionsMenu(true)
        val root: View = inflater.inflate(R.layout.fragment_tariflar, container, false)

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (activity as AppCompatActivity).setSupportActionBar(toolbar_tariflar as Toolbar?)
        (activity as AppCompatActivity).supportActionBar?.title = "Barcha tariflar"
        (activity as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)
//        toolbar.inflateMenu(R.menu.nav_menu)

//        recycler_tariflar.layoutParams
//        nega recycler_tariflar im ni maydonlari chiqmayapti
//        misol uchun layoutManager degan maydoni yo'qolib qolmoqda
        val recyclerView: RecyclerView = view.findViewById(R.id.recycler_tariflar)
        recyclerView.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

        val tariflar = ArrayList<TarifData>()

        tariflar.add(
            TarifData(
                "Oddiy 10",
                "10 MB",
                "10 MIN",
                "10 SMS",
                "10 000 so\'m oyiga"
            )
        )
        tariflar.add(
            TarifData(
                "Street",
                "6500 MB",
                "750 MIN",
                "750 SMS",
                "39 900 so\'m oyiga"
            )
        )
        tariflar.add(
            TarifData(
                "Onlime",
                "10 000 MB",
                "1000 MIN",
                "1000 SMS",
                "49 900 so\'m oyiga"
            )
        )
        tariflar.add(
            TarifData(
                "Flash",
                "16 000 MB",
                "1500 MIN",
                "1500 SMS",
                "69 900 so\'m oyiga"
            )
        )
        tariflar.add(
            TarifData(
                "Ishbilarmon",
                "25 000 MB",
                "Cheksiz",
                "3000 SMS",
                "99 000 so\'m oyiga"
            )
        )
        tariflar.add(
            TarifData(
                "Street Upgrade",
                "20 000 MB",
                "3000 MIN",
                "3000 SMS",
                "119 700 so\'m oyiga"
            )
        )
        tariflar.add(TarifData("Royal", "Cheksiz*", "Cheksiz*", "5000 SMS", "149 900 so\'m oyiga"))
        tariflar.add(
            TarifData(
                "Flash Upgrade",
                "56 000 MB",
                "6000 MIN",
                "6000 SMS",
                "209 700 so\'m oyiga"
            )
        )

        recyclerView.adapter = RecycleriViewAdapter(tariflar, context)
    }

//    override fun onCreateOptionsMenu(menu: Menu, menuInflater: MenuInflater): Unit {
//        menuInflater.inflate(R.menu.nav_menu, menu)
//        super.onCreateOptionsMenu(menu, menuInflater)
//    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> (activity as AppCompatActivity).supportFragmentManager.popBackStack()
        }
        return super.onOptionsItemSelected(item)
    }

    companion object {
        fun newInstance() = Fragment_Tariflar()
    }

}