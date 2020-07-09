package com.farhod.ussd_uztelecom_dealer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val updateHandler = Handler()
        val runnable = Runnable {
            offDisplay()
        }
        updateHandler.postDelayed(runnable, 1000)

        var joriyFragment: Fragment = Fragment_Asosiy()
        supportFragmentManager
            .beginTransaction()
            .add(R.id.frame_layout, joriyFragment)
            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
            .commit()

        val bottomNavigation: BottomNavigationView = findViewById(R.id.btm_nav_view)
        bottomNavigation.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {

                R.id.asosiy -> {
                    joriyFragment = Fragment_Asosiy()
                }
                R.id.tariflar -> {
                    joriyFragment = Fragment_Tariflar()
                }
                R.id.xizmatlar -> {
                    joriyFragment = Fragment_Xizmatlar()
                }
                R.id.paketlar -> {
                    joriyFragment = Fragment_Paketlar()
                }
                R.id.kuproq -> {
                    joriyFragment = Fragment_Kuproq()
                }

            }
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.frame_layout, joriyFragment)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .commit()

            true
        }
    }

    private fun onDisplay() {
        val loadingon = findViewById<LinearLayout>(R.id.linear_layout_loading)
        loadingon?.visibility = View.VISIBLE
    }

    private fun offDisplay() {
        val loadingon = findViewById<LinearLayout>(R.id.linear_layout_loading)
        loadingon?.visibility = View.INVISIBLE
    }
}