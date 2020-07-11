package com.farhod.ussd_uztelecom_dealer

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.cardview_xizmat.view.*

class RecyclerViewAdapter_Xizmatlar(val xizmatlar: ArrayList<XizmatData>, var context: Context?) :
    RecyclerView.Adapter<RecyclerViewAdapter_Xizmatlar.ViewHolderXizmatlar>() {
    class ViewHolderXizmatlar(item: View) : RecyclerView.ViewHolder(item) {

        val title: TextView = item.card_xizmatlar_title
        val desc: TextView = item.card_xizmatlar_description
        val cost: TextView = item.card_xizmatlar_costs

        var view = item

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderXizmatlar {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.cardview_xizmat, parent, false)
        return ViewHolderXizmatlar(view)
    }

    override fun getItemCount(): Int {
        return xizmatlar.size
    }

    override fun onBindViewHolder(holder: ViewHolderXizmatlar, position: Int) {

        val xizmatcha: XizmatData = xizmatlar[position]

        holder.title.text = xizmatcha.title
        holder.desc.text = xizmatcha.description
        holder.cost.text = xizmatcha.costs

        holder.view.setOnClickListener { item ->
            Toast.makeText(context, "Cardview selected at position $position", Toast.LENGTH_SHORT)
                .show()
        }

    }
}