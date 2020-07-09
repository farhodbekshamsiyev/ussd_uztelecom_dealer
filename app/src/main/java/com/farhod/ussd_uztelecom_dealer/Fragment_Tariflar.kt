package com.farhod.ussd_uztelecom_dealer

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class Fragment_Tariflar : Fragment() {
    //salom
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setHasOptionsMenu(true)
        val root: View = inflater.inflate(R.layout.fragment_tariflar, container, false)
        val toolbar: Toolbar = root.findViewById(R.id.toolbar_tariflar)
        (activity as AppCompatActivity).setSupportActionBar(toolbar)
        (activity as AppCompatActivity).supportActionBar?.setTitle("Barcha tariflar")
        (activity as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)
//        toolbar.inflateMenu(R.menu.nav_menu)

        val recyclerView: RecyclerView = root.findViewById(R.id.recycler_tariflar)
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

        val adapter = RecycleriViewAdapter(tariflar, context)
        recyclerView.adapter = adapter

        return root
    }

    override fun onCreateOptionsMenu(menu: Menu, menuInflater: MenuInflater): Unit {
        menuInflater.inflate(R.menu.nav_menu, menu)
        super.onCreateOptionsMenu(menu, menuInflater)
//        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_phone -> Toast.makeText(context, "Item selected", Toast.LENGTH_SHORT).show()
        }
        return super.onOptionsItemSelected(item)
    }

}