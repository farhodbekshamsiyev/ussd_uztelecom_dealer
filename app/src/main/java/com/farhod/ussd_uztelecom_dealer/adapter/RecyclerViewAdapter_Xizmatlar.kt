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
import com.farhod.ussd_uztelecom_dealer.data_classes.XizmatData
import com.farhod.ussd_uztelecom_dealer.model.ChildItemDataClass
import kotlinx.android.synthetic.main.cardview_item_child.view.*

class RecyclerViewAdapter_Xizmatlar(val xizmatlar: ArrayList<ChildItemDataClass>, var context: Context?) :
    RecyclerView.Adapter<RecyclerViewAdapter_Xizmatlar.ViewHolderXizmatlar>() {
    class ViewHolderXizmatlar(item: View) : RecyclerView.ViewHolder(item) {

        val title: TextView = item.card_xizmatlar_title
        val desc: TextView = item.card_xizmatlar_description
        val cost: TextView = item.card_xizmatlar_costs

        var view = item

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderXizmatlar {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.cardview_item_child, parent, false)
        return ViewHolderXizmatlar(
            view
        )
    }

    override fun getItemCount() = xizmatlar.size

    override fun onBindViewHolder(holder: ViewHolderXizmatlar, position: Int) {

        val xizmatcha: ChildItemDataClass = xizmatlar[position]

        holder.title.text = xizmatcha.title
        holder.desc.text = xizmatcha.descshort
        holder.cost.text = xizmatcha.cost

        holder.view.setOnClickListener {
            val intent = Intent(holder.view.context, Details::class.java)

            intent.putExtra("param1", xizmatcha.title)
            intent.putExtra("param2", xizmatcha.titletype)
            intent.putExtra("param3", xizmatcha.descshort)
            intent.putExtra("param4", xizmatcha.desclong)
            intent.putExtra("param5", xizmatcha.cost)
            intent.putExtra("param6", xizmatcha.type)
            intent.putExtra("param7", xizmatcha.activate)
            intent.putExtra("param8", xizmatcha.deactivate)
            intent.putExtra("param9", xizmatcha.check)

            holder.view.context.startActivity(intent)
        }

    }
}