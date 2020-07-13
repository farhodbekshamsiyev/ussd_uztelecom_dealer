package com.farhod.ussd_uztelecom_dealer.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.farhod.ussd_uztelecom_dealer.R
import com.farhod.ussd_uztelecom_dealer.adapter.ExpandableCardviewAdapter
import com.farhod.ussd_uztelecom_dealer.data_classes.ExpandableData

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class Fragment_Internet : Fragment() {
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_internet, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val itemList = mutableListOf<ExpandableData>()
        itemList.add(ExpandableData(ExpandableCardviewAdapter.PARENT, "Standart paketlar"))
        itemList.add(
            ExpandableData(
                ExpandableCardviewAdapter.CHILD,
                title = "500 Megabayt",
                description = "To'plamning amal qilish muddati ulanish kunidan boshlab 30 kun. Qolgan trafik keyingi oyga o'tmaydi",
                costs = "10 000 so'm"
            )
        )
        itemList.add(
            ExpandableData(
                ExpandableCardviewAdapter.CHILD,
                title = "1500 Megabayt",
                description = "To'plamning amal qilish muddati ulanish kunidan boshlab 30 kun. Qolgan trafik keyingi oyga o'tmaydi",
                costs = "15 000 so'm"
            )
        )
        itemList.add(
            ExpandableData(
                ExpandableCardviewAdapter.CHILD,
                title = "3000 Megabayt",
                description = "To'plamning amal qilish muddati ulanish kunidan boshlab 30 kun. Qolgan trafik keyingi oyga o'tmaydi",
                costs = "24 000 so'm"
            )
        )
        itemList.add(
            ExpandableData(
                ExpandableCardviewAdapter.CHILD,
                title = "5000 Megabayt",
                description = "To'plamning amal qilish muddati ulanish kunidan boshlab 30 kun. Qolgan trafik keyingi oyga o'tmaydi",
                costs = "32 000 so'm"
            )
        )
        itemList.add(
            ExpandableData(
                ExpandableCardviewAdapter.CHILD,
                title = "8000 Megabayt",
                description = "To'plamning amal qilish muddati ulanish kunidan boshlab 30 kun. Qolgan trafik keyingi oyga o'tmaydi",
                costs = "41 000 so'm"
            )
        )
        itemList.add(
            ExpandableData(
                ExpandableCardviewAdapter.CHILD,
                title = "12 000 Megabayt",
                description = "To'plamning amal qilish muddati ulanish kunidan boshlab 30 kun. Qolgan trafik keyingi oyga o'tmaydi",
                costs = "50 000 so'm"
            )
        )
        itemList.add(
            ExpandableData(
                ExpandableCardviewAdapter.CHILD,
                title = "20 000 Megabayt",
                description = "To'plamning amal qilish muddati ulanish kunidan boshlab 30 kun. Qolgan trafik keyingi oyga o'tmaydi",
                costs = "65 000 so'm"
            )
        )
        itemList.add(
            ExpandableData(
                ExpandableCardviewAdapter.CHILD,
                title = "30 000 Megabayt",
                description = "To'plamning amal qilish muddati ulanish kunidan boshlab 30 kun. Qolgan trafik keyingi oyga o'tmaydi",
                costs = "75 000 so'm"
            )
        )
        itemList.add(
            ExpandableData(
                ExpandableCardviewAdapter.CHILD,
                title = "50 000 Megabayt",
                description = "To'plamning amal qilish muddati ulanish kunidan boshlab 30 kun. Qolgan trafik keyingi oyga o'tmaydi",
                costs = "85 000 so'm"
            )
        )
        itemList.add(
            ExpandableData(
                ExpandableCardviewAdapter.CHILD,
                title = "75 000 Megabayt",
                description = "To'plamning amal qilish muddati ulanish kunidan boshlab 30 kun. Qolgan trafik keyingi oyga o'tmaydi",
                costs = "110 000 so'm"
            )
        )

//        val item = ExpandableData(ExpandableCardviewAdapter.PARENT, "Kunlik paketlar")
//        item.children = listOf(
        itemList.add(ExpandableData(ExpandableCardviewAdapter.PARENT, "Kunlik paketlar"))
        itemList.add(
            ExpandableData(
                ExpandableCardviewAdapter.CHILD, title = "100 Megabayt",
                description = "Internet to'plam faollashtirilgan vaqtdan boshlab 24 soat davomida amal qiladi. Qolgan trafik keyingi kunga o'tmaydi",
                costs = "3000 so'm"
            )
        )
        itemList.add(
            ExpandableData(
                ExpandableCardviewAdapter.CHILD, title = "300 Megabayt",
                description = "Internet to'plam faollashtirilgan vaqtdan boshlab 24 soat davomida amal qiladi. Qolgan trafik keyingi kunga o'tmaydi",
                costs = "6000 so'm"
            )
        )
        itemList.add(
            ExpandableData(
                ExpandableCardviewAdapter.CHILD, title = "600 Megabayt",
                description = "Internet to'plam faollashtirilgan vaqtdan boshlab 24 soat davomida amal qiladi. Qolgan trafik keyingi kunga o'tmaydi",
                costs = "9000 so'm"
            )
        )
//        )
//        itemList.add(item)


        itemList.add(
            ExpandableData(
                ExpandableCardviewAdapter.PARENT,
                "TAS-IX uchun paketlar"
            )
        )
        itemList.add(ExpandableData(ExpandableCardviewAdapter.PARENT, "Non-Stop paketlar"))
        itemList.add(ExpandableData(ExpandableCardviewAdapter.PARENT, "Tungi Internet"))
        itemList.add(ExpandableData(ExpandableCardviewAdapter.PARENT, "Kunlik Non-Stop"))

        val recyclerView: RecyclerView = view.findViewById(R.id.recycler_internet)
        recyclerView.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

        recyclerView.adapter = ExpandableCardviewAdapter(itemList, context)

    }

    public companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Fragment_Internet().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}