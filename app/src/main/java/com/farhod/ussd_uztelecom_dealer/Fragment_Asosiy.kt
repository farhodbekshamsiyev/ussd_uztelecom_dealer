package com.farhod.ussd_uztelecom_dealer

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.fragment.app.Fragment
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType
import com.smarteist.autoimageslider.SliderAnimations
import com.smarteist.autoimageslider.SliderView
import kotlinx.android.synthetic.main.fragment_asosiy.*

class Fragment_Asosiy : Fragment() {

    val TELEPHONE_SCHEME = "tel:"
    val PHONE_NUMBER = "+998905178222"
    val COMPANY_PHONE = "1099"
    val CHECK_BALANCE = "*107#"
    val REQUEST_PHONE_CALL = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val root: View = inflater.inflate(R.layout.fragment_asosiy, container, false)

//        btn_asosiy_fr_1.setOnClickListener(listener)
//        btn_asosiy_fr_2.setOnClickListener(listener)
//        btn_asosiy_fr_3.setOnClickListener(listener)
//        txt_asosiy_4.setOnClickListener(listener)

        val btnBalans: ImageButton = root.findViewById(R.id.btn_asosiy_fr_1)
        btnBalans.setOnClickListener(listener)

        val btnOperator: ImageButton = root.findViewById(R.id.btn_asosiy_fr_2)
        btnOperator.setOnClickListener(listener)

        val btnYordam: ImageButton = root.findViewById(R.id.btn_asosiy_fr_3)
        btnYordam.setOnClickListener(listener)

        val txtView_Shaxsiy_kabinet: TextView = root.findViewById(R.id.txt_asosiy_4)
        txtView_Shaxsiy_kabinet.setOnClickListener(listener)

        val sliderView: SliderView = root.findViewById(R.id.imageSlider)

        val sliderImages = ArrayList<SliderData>()

        sliderImages.add(SliderData(R.drawable.slider_image))
        sliderImages.add(SliderData(R.drawable.slider_image))
        sliderImages.add(SliderData(R.drawable.slider_image))
        sliderImages.add(SliderData(R.drawable.slider_image))
        sliderImages.add(SliderData(R.drawable.slider_image))

        val adapter = SliderAdapterExample(context, sliderImages)
        sliderView.setSliderAdapter(adapter)

//        imageSlider.setSliderAdapter(SliderAdapterExample(context, sliderImages))

        sliderView.setIndicatorAnimation(IndicatorAnimationType.THIN_WORM) //set indicator animation by using SliderLayout.IndicatorAnimations. :WORM or THIN_WORM or COLOR or DROP or FILL or NONE or SCALE or SCALE_DOWN or SLIDE and SWAP!!
        sliderView.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION)
        sliderView.autoCycleDirection = SliderView.AUTO_CYCLE_DIRECTION_RIGHT
        sliderView.scrollTimeInSec = 4
        sliderView.startAutoCycle()

        return root
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
                } else { }
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
        fun newInstance() = Fragment_Asosiy()
    }

}