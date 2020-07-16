package com.farhod.ussd_uztelecom_dealer.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.farhod.ussd_uztelecom_dealer.Details
import com.farhod.ussd_uztelecom_dealer.R
import com.farhod.ussd_uztelecom_dealer.data_classes.TarifData
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

        val str = tarifs.descshort?.split("#")

        holder.TITLE.text = tarifs.title
        holder.MGB.text = str?.get(0)
        holder.MIN.text = str?.get(1)
        holder.SMS.text = str?.get(2)
        holder.NARX.text = tarifs.cost

        holder.view.setOnClickListener { item ->
            val intent = Intent(holder.view.context, Details::class.java)

            intent.putExtra("param1", tarifs.title)
            intent.putExtra("param2", tarifs.titletype)
            intent.putExtra("param3", tarifs.descshort)
            intent.putExtra("param4", tarifs.desclong)
            intent.putExtra("param5", tarifs.cost)
            intent.putExtra("param6", tarifs.type)
            intent.putExtra("param7", tarifs.activate)
            intent.putExtra("param8", tarifs.deactivate)
            intent.putExtra("param9", tarifs.check)

            holder.view.context.startActivity(intent)
        }

    }

}