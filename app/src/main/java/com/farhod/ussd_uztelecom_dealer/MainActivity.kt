package com.farhod.ussd_uztelecom_dealer

import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
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

        var joriyFragment: Fragment = Fragment_Asosiy.newInstance()
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.frame_layout, joriyFragment, joriyFragment.tag)
            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
            .commit()

        val bottomNavigation: BottomNavigationView = findViewById(R.id.btm_nav_view)
        bottomNavigation.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {

                R.id.asosiy -> {
//                    currentFragment = supportFragmentManager.findFragmentById(R.id.frame_layout)
                    joriyFragment = Fragment_Asosiy.newInstance()
                }
                R.id.tariflar -> {
//                    currentFragment = supportFragmentManager.findFragmentById(R.id.frame_layout)
                    joriyFragment = Fragment_Tariflar.newInstance()
                }
                R.id.xizmatlar -> {
//                    currentFragment = supportFragmentManager.findFragmentById(R.id.frame_layout)
                    joriyFragment = Fragment_Xizmatlar.newInstance()
                }
                R.id.paketlar -> {
//                    currentFragment = supportFragmentManager.findFragmentById(R.id.frame_layout)
                    joriyFragment = Fragment_Paketlar.newInstance()
                }
                R.id.kuproq -> {
//                    currentFragment = supportFragmentManager.findFragmentById(R.id.frame_layout)
                    joriyFragment = Fragment_Kuproq.newInstance()
                }

            }
            if (!joriyFragment.isVisible) {
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.frame_layout, joriyFragment, joriyFragment.tag)
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .commit()
               } else {
                Toast.makeText(this, joriyFragment.toString(), Toast.LENGTH_SHORT).show()
            }

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