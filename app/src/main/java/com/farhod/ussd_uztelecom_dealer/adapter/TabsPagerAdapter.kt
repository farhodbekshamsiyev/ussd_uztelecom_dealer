package com.farhod.ussd_uztelecom_dealer.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.farhod.ussd_uztelecom_dealer.fragments.Fragment_Daqiqalar
import com.farhod.ussd_uztelecom_dealer.fragments.Fragment_Internet
import com.farhod.ussd_uztelecom_dealer.fragments.Fragment_SMS

class TabsPagerAdapter(
    fr_manager: FragmentManager,
    lifecycle: Lifecycle,
    private var tabCount: Int
) : FragmentStateAdapter(fr_manager, lifecycle) {

    override fun createFragment(position: Int): Fragment {
        when (position) {
            0 -> return Fragment_Internet.newInstance("internet", "")
            1 -> return Fragment_Daqiqalar.newInstance("daqiqalar", "")
            2 -> return Fragment_SMS.newInstance("sms", "")
            else -> return Fragment_Internet.newInstance("internet", "")
        }
    }

    override fun getItemCount() = tabCount
}