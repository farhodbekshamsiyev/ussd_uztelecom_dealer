package com.farhod.ussd_uztelecom_dealer

import android.os.Bundle
import android.os.Handler
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.layout_loading.*

class MainActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {

    private var currentFragment: Fragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Handler().postDelayed(this::offDisplay, 1000L)

        if (savedInstanceState == null) {
            openFragmentAsosiy()
        }

        btm_nav_view.setOnNavigationItemSelectedListener(this)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.asosiy -> openFragmentAsosiy()
            R.id.tariflar -> openFragmentTariflar()
            R.id.xizmatlar -> openFragmentXizmatlar()
            R.id.paketlar -> openFragmentPaketlar()
            R.id.kuproq -> openFragmentKuproq()
            else -> return false
        }

        return true
    }

    private fun openFragmentAsosiy() {
        if (Fragment_Asosiy::class.java != currentFragment?.javaClass) {
            startFragment(Fragment_Asosiy.newInstance())
        }
    }

    private fun openFragmentTariflar() {
        if (Fragment_Tariflar::class.java != currentFragment?.javaClass) {
            startFragment(Fragment_Tariflar.newInstance())
        }
    }

    private fun openFragmentXizmatlar() {
        if (Fragment_Xizmatlar::class.java != currentFragment?.javaClass) {
            startFragment(Fragment_Xizmatlar.newInstance())
        }
    }

    private fun openFragmentPaketlar() {
        if (Fragment_Paketlar::class.java != currentFragment?.javaClass) {
            startFragment(Fragment_Paketlar.newInstance())
        }
    }

    private fun openFragmentKuproq() {
        if (Fragment_Kuproq::class.java != currentFragment?.javaClass) {
            startFragment(Fragment_Paketlar.newInstance())
        }
    }

    private fun startFragment(fragment: Fragment) {
        currentFragment = fragment
        supportFragmentManager.beginTransaction()
            .replace(R.id.frame_layout, fragment, fragment.javaClass.simpleName)
            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
            .commit()
    }

    private fun onDisplay() {
        linear_layout_loading.visibility = View.VISIBLE
    }

    private fun offDisplay() {
        linear_layout_loading.visibility = View.INVISIBLE
    }
}