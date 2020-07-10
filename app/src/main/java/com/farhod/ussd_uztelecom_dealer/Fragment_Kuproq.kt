package com.farhod.ussd_uztelecom_dealer

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment


class Fragment_Kuproq : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val root: View = inflater.inflate(R.layout.fragment_kuproq, container, false)
        val toolbar: Toolbar = root.findViewById(R.id.toolbar_kuproq)
        (activity as AppCompatActivity).setSupportActionBar(toolbar)
        (activity as AppCompatActivity).supportActionBar?.title = "Ko'proq"
        (activity as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // Inflate the layout for this fragment
//        kuproq_card_txt_yangiliklar.setOnClickListener(listener)
//        kuproq_card_txt_aksiya.setOnClickListener(listener)
//        kuproq_card_txt_xabar.setOnClickListener(listener)
//        kuproq_card_txt_yordam.setOnClickListener(listener)
//        kuproq_card_txt_ilova_haqida.setOnClickListener(listener)
//        kuproq_card_txt_uzimei.setOnClickListener(listener)

        val yangiliklar: TextView = root.findViewById(R.id.kuproq_card_txt_yangiliklar)
        yangiliklar.setOnClickListener(listener)

        val aksiya: TextView = root.findViewById(R.id.kuproq_card_txt_aksiya)
        aksiya.setOnClickListener(listener)

        val xabar: TextView = root.findViewById(R.id.kuproq_card_txt_xabar)
        xabar.setOnClickListener(listener)

        val yordam: TextView = root.findViewById(R.id.kuproq_card_txt_yordam)
        yordam.setOnClickListener(listener)

        val ilova_haqida: TextView = root.findViewById(R.id.kuproq_card_txt_ilova_haqida)
        ilova_haqida.setOnClickListener(listener)

        val uzimei: TextView = root.findViewById(R.id.kuproq_card_txt_uzimei)
        uzimei.setOnClickListener(listener)

        return root
    }

    private val listener = View.OnClickListener { view ->
        when (view.id) {
            R.id.kuproq_card_txt_yangiliklar -> {
                Toast.makeText(activity, "Bosildi ${view.id}", Toast.LENGTH_SHORT).show()
            }

            R.id.kuproq_card_txt_aksiya -> {
                Toast.makeText(activity, "Bosildi ${view.id}", Toast.LENGTH_SHORT).show()
            }

            R.id.kuproq_card_txt_xabar -> {
                Toast.makeText(activity, "Bosildi ${view.id}", Toast.LENGTH_SHORT).show()
            }

            R.id.kuproq_card_txt_yordam -> {
                Toast.makeText(activity, "Bosildi ${view.id}", Toast.LENGTH_SHORT).show()
            }

            R.id.kuproq_card_txt_ilova_haqida -> {
                Toast.makeText(activity, "Bosildi ${view.id}", Toast.LENGTH_SHORT).show()
            }

            R.id.kuproq_card_txt_uzimei -> {
                Toast.makeText(activity, "Bosildi ${view.id}", Toast.LENGTH_SHORT).show()
            }
        }
    }

    companion object {
        fun newInstance() = Fragment_Kuproq()
    }

}