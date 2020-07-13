package com.farhod.ussd_uztelecom_dealer.fragments

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.farhod.ussd_uztelecom_dealer.MainActivity
import com.farhod.ussd_uztelecom_dealer.R
import com.farhod.ussd_uztelecom_dealer.adapter.RecyclerViewAdapter_Xizmatlar
import com.farhod.ussd_uztelecom_dealer.data_classes.XizmatData
import kotlinx.android.synthetic.main.fragment_xizmatlar.*


class Fragment_Xizmatlar : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        (activity as MainActivity).changeStatusBarColor(false)

        setHasOptionsMenu(true)
        val root: View = inflater.inflate(R.layout.fragment_xizmatlar, container, false)

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (activity as AppCompatActivity).setSupportActionBar(toolbar_xizmatlar as Toolbar?)
        (activity as AppCompatActivity).supportActionBar?.title = "Barcha xizmatlar"
        (activity as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val recyclerView: RecyclerView = view.findViewById(R.id.recycler_xizmatlar)
        recyclerView.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

        val xizmatlar_array = ArrayList<XizmatData>()

        xizmatlar_array.add(
            XizmatData(
                "Anti-AON 1",
                "Ushbu xizmat qo'ng'iroqni amalga oshirishda har doim raqamingizni yashi" +
                        "rishga imkon beradi. Raqamingizni qo'ng'iroq paytida ochish imkoniyati mavjud",
                "8400 so'm oyiga"
            )
        )
        xizmatlar_array.add(
            XizmatData(
                "Shaxsiy raqam uzatilishi",
                "Mazkur xizmat yashirin raqamdan qo'ng'iroqlar amalga oshirishga ruxsat " +
                        "beradi ya'ni, qo'ng'iroq qabul qilayotgan abonent, qo'n'giroqni amalga osh" +
                        "irayotgan abonentning telefon raqamini ko'ra olmaydi",
                "8400 so'm oyiga"
            )
        )
        xizmatlar_array.add(
            XizmatData(
                "Pereadresatsiya",
                "Ushbu xizmat sizning raqamingizga keluvchi barcha qo'ng'iroqlarni boshqa" +
                        " raqamga yo'naltiradi.",
                "0 so'm kuniga"
            )
        )
        xizmatlar_array.add(
            XizmatData(
                "Anti-AON 2",
                "Ushbu xizmat sizga kerak bo'lganda paytda raqamingizni yashirishga imkon " +
                        "beradi. Xizamtni yoqtirganingizda raqamingiz doimo ochiq bo'ladi",
                "8400 so'm oyiga"
            )
        )
        xizmatlar_array.add(
            XizmatData(
                "Tarmoqda",
                "Qo'ng'iroq qilingan abonent tarmoqqa qaytganligi haqida xabardor bo'ling",
                "40 so'm kuniga"
            )
        )
//        xizmatlar_array.add(
//            XizmatData(
//                "Qabul qilinmagan qo'ng'iroq",
//                "Tarmoqda bo'lmagan paytda o'tkazib yuborilgan kiruvchi qo'ng'iroqlar SMS" +
//                        " orqali yuboriladi",
//                "40 so'm kuniga"
//            )
//        )
//        xizmatlar_array.add(
//            XizmatData(
//                "Limitsiz ovoz",
//                "GSM va CDMA tarmoqlari ichida bepul qo'ng'iroqlarni amalga oshirish imko" +
//                        "bibi beradi.",
//                "210 so'm kuniga"
//            )
//        )
//        xizmatlar_array.add(
//            XizmatData(
//                "Tungi qo'ng'iroqlar",
//                "Xizmatni faollashtirishdan keyin, tarmoq (GSM/CDMA) ichida qo'ng'iroqlarni" +
//                        " narxlamaydi",
//                "42 so'm kuniga"
//            )
//        )
//        xizmatlar_array.add(
//            XizmatData(
//                "Chaqiruvni kutish",
//                "Aktiv qo'ng'iroqni saqlagan holda boshqa qo'ng'iroqqa o'tish imkoniyati",
//                "0 so'm oyiga"
//            )
//        )
//        xizmatlar_array.add(
//            XizmatData(
//                "4G tarmog'i",
//                "Internetdan yuqori tezlikda foydalaning",
//                "0 so'm oyiga"
//            )
//        )
//        xizmatlar_array.add(
//            XizmatData(
//                "Oila uchun",
//                "Oila uchun guruhidagi raqamlar uchun cheklanmagan ovozli qo'ng'iroqlar",
//                "2105,18 so'm oyiga"
//            )
//        )
//        xizmatlar_array.add(
//            XizmatData(
//                "Konferens aloqa",
//                "Ushbu xizmat bir vaqtning o'zida bir necha abonent bilan muloqot qilishga" +
//                        " ruxsat beradi. Xizmatni o'rnatilgan bo'lsa, 5 tagacha abonent o'zaro muloqot" +
//                        "qilishi mumkin",
//                "0 so'm oyiga"
//            )
//        )
//        xizmatlar_array.add(
//            XizmatData(
//                "EXTRA balans",
//                "Agar sizning balansingiz nolga yaqinlashib qolgan bo'lsa, u holda \"EXTRA" +
//                        " balans\" xizmati bir zumda hisobingizni 1000 so'm yoki undan ortiq miqdor" +
//                        "ida to'ldirishingizga yordam beradi.",
//                "0 so'm oyiga"
//            )
//        )

        recyclerView.adapter =
            RecyclerViewAdapter_Xizmatlar(
                xizmatlar_array,
                context
            )
    }

    companion object {
        fun newInstance() =
            Fragment_Xizmatlar()
    }
}