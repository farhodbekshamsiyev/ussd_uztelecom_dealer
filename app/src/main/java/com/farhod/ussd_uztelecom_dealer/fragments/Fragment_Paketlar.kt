package com.farhod.ussd_uztelecom_dealer.fragments

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.farhod.ussd_uztelecom_dealer.MainActivity
import com.farhod.ussd_uztelecom_dealer.R
import com.farhod.ussd_uztelecom_dealer.adapter.TabsPagerAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.fragment_paketlar.*


class Fragment_Paketlar : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_paketlar, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        paketlar_tablayout.tabMode = TabLayout.MODE_FIXED
        paketlar_viewpager.adapter = TabsPagerAdapter(
            (activity as AppCompatActivity).supportFragmentManager,
            lifecycle,
            3
        )
        paketlar_viewpager.isUserInputEnabled = true
        TabLayoutMediator(paketlar_tablayout, paketlar_viewpager) { tab, position ->
            when (position) {
                0 -> tab.text = "Internet"
                1 -> tab.text = "Daqiqalar"
                2 -> tab.text = "SMS"
            }
        }.attach()
    }

    companion object {
        fun newInstance() =
            Fragment_Paketlar()
    }
}