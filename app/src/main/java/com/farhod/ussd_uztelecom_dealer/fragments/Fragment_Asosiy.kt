package com.farhod.ussd_uztelecom_dealer.fragments

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.fragment.app.Fragment
import com.farhod.ussd_uztelecom_dealer.R
import com.farhod.ussd_uztelecom_dealer.WebView
import com.farhod.ussd_uztelecom_dealer.adapter.SliderAdapterExample
import com.farhod.ussd_uztelecom_dealer.data_classes.SliderData
import com.farhod.ussd_uztelecom_dealer.inputStreamToString
import com.lessons.udemy.kotlincode.ReadData
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType
import com.smarteist.autoimageslider.SliderAnimations
import com.smarteist.autoimageslider.SliderView
import kotlinx.android.synthetic.main.fragment_asosiy.*

class Fragment_Asosiy : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_asosiy, container, false)
    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btn_asosiy_fr_1.setOnClickListener(listener)
        btn_asosiy_fr_2.setOnClickListener(listener)
        btn_asosiy_fr_3.setOnClickListener(listener)
        txt_asosiy_4.setOnClickListener(listener)

        val sliderImages = ArrayList<SliderData>()

        sliderImages.add(
            SliderData(
                R.drawable.slider_image
            )
        )
        sliderImages.add(
            SliderData(
                R.drawable.slider_image
            )
        )
        sliderImages.add(
            SliderData(
                R.drawable.slider_image
            )
        )
        sliderImages.add(
            SliderData(
                R.drawable.slider_image
            )
        )
        sliderImages.add(
            SliderData(
                R.drawable.slider_image
            )
        )

        imageSlider.setSliderAdapter(
            SliderAdapterExample(
                context,
                sliderImages
            )
        )

        imageSlider.setIndicatorAnimation(IndicatorAnimationType.THIN_WORM) //set indicator animation by using SliderLayout.IndicatorAnimations. :WORM or THIN_WORM or COLOR or DROP or FILL or NONE or SCALE or SCALE_DOWN or SLIDE and SWAP!!
        imageSlider.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION)
        imageSlider.autoCycleDirection = SliderView.AUTO_CYCLE_DIRECTION_RIGHT
        imageSlider.scrollTimeInSec = 4
        imageSlider.startAutoCycle()
    }

    private val listener = View.OnClickListener { view ->
        when (view.id) {

            R.id.btn_asosiy_fr_1 -> {
                dialPhone(CHECK_BALANCE)
            }

            R.id.btn_asosiy_fr_2 -> {
                if (ActivityCompat.checkSelfPermission(
                        (activity as AppCompatActivity),
                        Manifest.permission.CALL_PHONE
                    ) != PackageManager.PERMISSION_GRANTED
                ) {
                    ActivityCompat.requestPermissions(
                        (activity as AppCompatActivity),
                        arrayOf(Manifest.permission.CALL_PHONE),
                        REQUEST_PHONE_CALL
                    )

                } else {
                    callPhone("$TELEPHONE_SCHEME$COMPANY_PHONE")
                }
            }

            R.id.btn_asosiy_fr_3 -> {
                dialPhone(PHONE_NUMBER)
            }

            R.id.txt_asosiy_4 -> {
                val intent = Intent(context, WebView::class.java)
                intent.putExtra("param1", "Shaxsiy kabinetga kirish")
                intent.putExtra("param2", getString(R.string.url_shaxsiy_kabinet))
                startActivity(intent)
            }
        }
    }

    fun callPhone(number: String?) {
        val intent = Intent(Intent.ACTION_CALL, Uri.parse(number))
        startActivity(intent)
    }

    fun dialPhone(number: String?) {
        val intent = Intent(Intent.ACTION_DIAL, Uri.parse(TELEPHONE_SCHEME + Uri.encode(number)))
        startActivity(intent)
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>, grantResults: IntArray
    ) {
       if (requestCode == REQUEST_PHONE_CALL) callPhone("$TELEPHONE_SCHEME$COMPANY_PHONE")
    }

    companion object {
        const val TELEPHONE_SCHEME = "tel:"
        const val PHONE_NUMBER = "+998905178222"
        const val COMPANY_PHONE = "1099"
        const val CHECK_BALANCE = "*107#"
        const val REQUEST_PHONE_CALL = 1

        @JvmStatic
        fun newInstance() =
            Fragment_Asosiy()
    }

}