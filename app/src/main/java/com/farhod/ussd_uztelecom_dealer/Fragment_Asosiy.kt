package com.farhod.ussd_uztelecom_dealer

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.fragment.app.Fragment
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType
import com.smarteist.autoimageslider.SliderAnimations
import com.smarteist.autoimageslider.SliderView
import kotlinx.android.synthetic.main.fragment_asosiy.*

class Fragment_Asosiy : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_asosiy, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btn_asosiy_fr_1.setOnClickListener(listener)
        btn_asosiy_fr_2.setOnClickListener(listener)
        btn_asosiy_fr_3.setOnClickListener(listener)
        txt_asosiy_4.setOnClickListener(listener)

        val sliderImages = ArrayList<SliderData>()

        sliderImages.add(SliderData(R.drawable.slider_image))
        sliderImages.add(SliderData(R.drawable.slider_image))
        sliderImages.add(SliderData(R.drawable.slider_image))
        sliderImages.add(SliderData(R.drawable.slider_image))
        sliderImages.add(SliderData(R.drawable.slider_image))

        val adapter = SliderAdapterExample(context, sliderImages)
        imageSlider.setSliderAdapter(adapter)

//        imageSlider.setSliderAdapter(SliderAdapterExample(context, sliderImages))

        imageSlider.setIndicatorAnimation(IndicatorAnimationType.THIN_WORM) //set indicator animation by using SliderLayout.IndicatorAnimations. :WORM or THIN_WORM or COLOR or DROP or FILL or NONE or SCALE or SCALE_DOWN or SLIDE and SWAP!!
        imageSlider.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION)
        imageSlider.autoCycleDirection = SliderView.AUTO_CYCLE_DIRECTION_RIGHT
        imageSlider.scrollTimeInSec = 4
        imageSlider.startAutoCycle()
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>, grantResults: IntArray
    ) {
        if (requestCode == REQUEST_PHONE_CALL) {
            if ((grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED)) {
                Toast.makeText(activity, "Qo'ng'iroqlarga ruxsat berildi", Toast.LENGTH_SHORT)
                    .show()
            } else {
                Toast.makeText(activity, "Qo'ng'iroqlarga ruxsat berilmadi", Toast.LENGTH_SHORT)
                    .show()
            }
            return
        }
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
                }
                callPhone("$TELEPHONE_SCHEME$COMPANY_PHONE")
            }

            R.id.btn_asosiy_fr_3 -> {
                dialPhone(PHONE_NUMBER)
            }

            R.id.txt_asosiy_4 -> {
                Toast.makeText(activity, "Shaxsiy kabinetga kirish", Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }

    fun callPhone(number: String) {
        val intent = Intent(Intent.ACTION_CALL, Uri.parse(number))
        startActivity(intent)
    }

    fun dialPhone(number: String) {
        val intent = Intent(Intent.ACTION_DIAL, Uri.parse(TELEPHONE_SCHEME + Uri.encode(number)))
        startActivity(intent)
    }

    companion object {
        const val TELEPHONE_SCHEME = "tel:"
        const val PHONE_NUMBER = "+998905178222"
        const val COMPANY_PHONE = "1099"
        const val CHECK_BALANCE = "*107#"
        const val REQUEST_PHONE_CALL = 1

        @JvmStatic
        fun newInstance() = Fragment_Asosiy()
    }

}