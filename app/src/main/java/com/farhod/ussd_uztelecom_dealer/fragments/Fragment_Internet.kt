package com.farhod.ussd_uztelecom_dealer.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.farhod.ussd_uztelecom_dealer.R
import com.farhod.ussd_uztelecom_dealer.adapter.ExpandableAdapter
import com.farhod.ussd_uztelecom_dealer.data_classes.Group_Expandable
import com.farhod.ussd_uztelecom_dealer.inputStreamToString
import com.farhod.ussd_uztelecom_dealer.model.ChildItemDataClass
import com.farhod.ussd_uztelecom_dealer.model.ModelGSON
import com.google.gson.Gson
import kotlinx.android.synthetic.main.fragment_internet.*

//import com.farhod.ussd_uztelecom_dealer.adapter.ExpandableCardviewAdapter

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class Fragment_Internet : Fragment() {
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_internet, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val preferences = (activity as AppCompatActivity).getSharedPreferences("ussd_dealer", Context.MODE_PRIVATE)
        val strData = preferences.getString("data", "")

//        val myJson =
//            inputStreamToString((activity as AppCompatActivity).resources.openRawResource(R.raw.ussdcodes))
        val myModel = Gson().fromJson(strData, ModelGSON::class.java)

        val listGroup = ArrayList<Group_Expandable>()

        val listItem = ArrayList<ChildItemDataClass>()
        myModel?.internet?.standartPaketlar?.let { listItem.addAll(it) }

        val parent_1 = Group_Expandable("Standart paketlar", listItem)
        listGroup.add(parent_1)

        val listItem2 = ArrayList<ChildItemDataClass>()
        myModel?.internet?.kunlikPaketlar?.let { listItem2.addAll(it) }

        val parent_2 = Group_Expandable("Kunlik paketlar", listItem2)
        listGroup.add(parent_2)

        val listItem3 = ArrayList<ChildItemDataClass>()
        myModel?.internet?.tasixPaketlar?.let { listItem3.addAll(it) }

        val parent_3 = Group_Expandable("TAS-IX uchun paketlar", listItem3)
        listGroup.add(parent_3)

        val listItem4 = ArrayList<ChildItemDataClass>()
        myModel?.internet?.tungiPaketlar?.let { listItem4.addAll(it) }

        val parent_4 = Group_Expandable("Tungi Internet", listItem4)
        listGroup.add(parent_4)

        recycler_internet.layoutManager = LinearLayoutManager(context)
        recycler_internet.adapter = ExpandableAdapter(listGroup, context)

    }

    public companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Fragment_Internet().apply {
                arguments = bundleOf(
                    Pair(ARG_PARAM1, param1),
                    Pair(ARG_PARAM2, param2)
                )
            }
    }
}