package com.farhod.ussd_uztelecom_dealer.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.farhod.ussd_uztelecom_dealer.R
import com.farhod.ussd_uztelecom_dealer.adapter.ExpandableAdapter
import com.farhod.ussd_uztelecom_dealer.data_classes.Group_Expandable
import com.farhod.ussd_uztelecom_dealer.inputStreamToString
import com.farhod.ussd_uztelecom_dealer.model.ChildItemDataClass
import com.farhod.ussd_uztelecom_dealer.model.ModelGSON
import com.google.gson.Gson
import kotlinx.android.synthetic.main.fragment_daqiqalar.*


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class Fragment_Daqiqalar : Fragment() {
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
        return inflater.inflate(R.layout.fragment_daqiqalar, container, false)
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
        myModel?.daqiqalar?.standartPaketlar?.let { listItem.addAll(it) }

        val parent_1 = Group_Expandable("Standart paketlar", listItem)
        listGroup.add(parent_1)

        recycler_daqiqalar.layoutManager = LinearLayoutManager(context)
        recycler_daqiqalar.adapter = ExpandableAdapter(listGroup, context)

    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Fragment_Daqiqalar().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}