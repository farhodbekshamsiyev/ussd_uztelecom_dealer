package com.farhod.ussd_uztelecom_dealer.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.farhod.ussd_uztelecom_dealer.Details
import com.farhod.ussd_uztelecom_dealer.R
import com.farhod.ussd_uztelecom_dealer.model.ChildItemDataClass
import kotlinx.android.synthetic.main.cardview_1.view.*

class RecycleriViewAdapter(val tariffs: ArrayList<ChildItemDataClass>, var context: Context?) :
    RecyclerView.Adapter<RecycleriViewAdapter.ViewHolder>() {

    class ViewHolder(item: View) : RecyclerView.ViewHolder(item) {

        var TITLE: TextView = item.card_title
        var MGB: TextView = item.card_txt_mgb
        var MIN: TextView = item.card_txt_min
        var SMS: TextView = item.card_txt_sms
        var NARX: TextView = item.card_txt_narxi

        var view: View = item

        fun bind(child: ChildItemDataClass) {

            val str = child.descshort?.split("#")

            TITLE.text = child.title
            MGB.text = str?.get(0)
            MIN.text = str?.get(1)
            SMS.text = str?.get(2)
            NARX.text = child.cost

            view.setOnClickListener { item ->
                val intent = Intent(view.context, Details::class.java)

                intent.putExtra("param1", child.title)
                intent.putExtra("param2", child.titletype)
                intent.putExtra("param3", child.descshort)
                intent.putExtra("param4", child.desclong)
                intent.putExtra("param5", child.cost)
                intent.putExtra("param6", child.type)
                intent.putExtra("param7", child.activate)
                intent.putExtra("param8", child.deactivate)
                intent.putExtra("param9", child.check)

                view.context.startActivity(intent)
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.cardview_1, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount() = tariffs.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val tarifs: ChildItemDataClass = tariffs[position]
        holder.bind(tarifs)
    }

}