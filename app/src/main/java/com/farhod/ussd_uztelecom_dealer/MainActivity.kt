package com.farhod.ussd_uztelecom_dealer

import android.annotation.SuppressLint
import android.content.Context
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.farhod.ussd_uztelecom_dealer.fragments.*
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.lessons.udemy.kotlincode.ReadData
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.layout_loading.*
import java.io.IOException
import java.io.InputStream


private var currentFragment: Fragment? = null
private var backPressedTime: Long = 0
private var backToast: Toast? = null

private const val CONTEXT: String = "662ede816988e58fb6d057d9d85605e0"

class MainActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {


    @SuppressLint("CommitPrefEdits")
    @RequiresApi(Build.VERSION_CODES.KITKAT)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            startFragment(Fragment_Asosiy.newInstance(), Fragment_Asosiy::class.java.simpleName)
        }

        val prefs = this.getSharedPreferences(
            "ussd_dealer", Context.MODE_PRIVATE
        )
        val editor = prefs.edit()
        if (prefs.getString("data", null).isNullOrEmpty()) {
            val varargS =
                inputStreamToString(this.resources.openRawResource(R.raw.sampleout))
            val dValue: String? = ReadData().rereading(CONTEXT, varargS)
            editor.putString("data", dValue)
            editor.apply()
            Toast.makeText(this, "Ma'lumotlar yuklandi", Toast.LENGTH_SHORT).show()
        } else {
            openFragmentAsosiy()
            Toast.makeText(this, "Ma'lumotlar tayyor", Toast.LENGTH_SHORT).show()
        }

        Handler().postDelayed(this::offDisplay, 1000L)

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
            startFragment(Fragment_Asosiy.newInstance(), Fragment_Asosiy::class.java.simpleName)
        }
    }

    private fun openFragmentTariflar() {
        if (Fragment_Tariflar::class.java != currentFragment?.javaClass) {
            startFragment(Fragment_Tariflar.newInstance(), Fragment_Tariflar::class.java.simpleName)
        }
    }

    private fun openFragmentXizmatlar() {
        if (Fragment_Xizmatlar::class.java != currentFragment?.javaClass) {
            startFragment(
                Fragment_Xizmatlar.newInstance(),
                Fragment_Xizmatlar::class.java.simpleName
            )
        }
    }

    private fun openFragmentPaketlar() {
        if (Fragment_Paketlar::class.java != currentFragment?.javaClass) {
            startFragment(Fragment_Paketlar.newInstance(), Fragment_Paketlar::class.java.simpleName)
        }
    }

    private fun openFragmentKuproq() {
        if (Fragment_Kuproq::class.java != currentFragment?.javaClass) {
            startFragment(Fragment_Kuproq.newInstance(), Fragment_Kuproq::class.java.simpleName)
        }
    }

    fun startFragment(fragment: Fragment, tag: String?) {
        currentFragment = fragment

        if (supportFragmentManager.findFragmentByTag(tag) != null) {
            supportFragmentManager.popBackStack(tag, FragmentManager.POP_BACK_STACK_INCLUSIVE)
        }

        supportFragmentManager.beginTransaction()
            .addToBackStack(tag)
            .replace(R.id.frame_layout, fragment, tag)
            .setCustomAnimations(
                R.anim.fragment_fade_enter,
                R.anim.fragment_fade_exit
            )
            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
            .commit()
    }

    private fun onDisplay() {
        linear_layout_loading.visibility = View.VISIBLE
    }

    private fun offDisplay() {
        linear_layout_loading.visibility = View.INVISIBLE
    }

    override fun onBackPressed() {
        val fragmentsInStack = supportFragmentManager.backStackEntryCount
        if (fragmentsInStack > 1) {
            // If we have more than one fragment, pop back stack
            supportFragmentManager.popBackStack();

        } else {//if (fragmentsInStack == 1)
            // Finish activity, if only one fragment left, to prevent leaving empty screen
            if (backPressedTime + 2000 > System.currentTimeMillis()) {
                backToast?.cancel()
                super.onBackPressed()
                finish()
                return
            } else {
                backToast = Toast.makeText(
                    baseContext,
                    "Chiqish uchun yana bir marta bosing",
                    Toast.LENGTH_SHORT
                )
                backToast.run { this?.show() }
            }
            backPressedTime = System.currentTimeMillis()
        }
//        else {
//            super.onBackPressed();
////            finish()
//        }
    }

    fun selectBottomNavbarItem(fragment: Fragment?) {
        when (fragment) {
            is Fragment_Asosiy -> btm_nav_view.selectedItemId = R.id.asosiy
            is Fragment_Tariflar -> btm_nav_view.selectedItemId = R.id.tariflar
            is Fragment_Xizmatlar -> btm_nav_view.selectedItemId = R.id.xizmatlar
            is Fragment_Paketlar -> btm_nav_view.selectedItemId = R.id.paketlar
            is Fragment_Kuproq -> btm_nav_view.selectedItemId = R.id.kuproq
        }
    }
}

fun inputStreamToString(inputStream: InputStream): String? {
    return try {
        val bytes = ByteArray(inputStream.available())
        inputStream.read(bytes, 0, bytes.size)
        String(bytes)
    } catch (e: IOException) {
        null
    }
}
