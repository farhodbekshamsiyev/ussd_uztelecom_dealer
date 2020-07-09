package com.farhod.ussd_uztelecom_dealer

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class RecycleriViewAdapter(val tariffs: ArrayList<TarifData>, var context: Context?) :
    RecyclerView.Adapter<RecycleriViewAdapter.ViewHolder>() {

    class ViewHolder(item: View) : RecyclerView.ViewHolder(item) {
        var TITLE: TextView = item.findViewById(R.id.card_title)
        var MGB: TextView = item.findViewById(R.id.card_txt_mgb)
        var MIN: TextView = item.findViewById(R.id.card_txt_min)
        var SMS: TextView = item.findViewById(R.id.card_txt_sms)
        var NARX: TextView = item.findViewById(R.id.card_txt_narxi)

        var view: View = item
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.cardview_1, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return tariffs.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var tarifs: TarifData = tariffs[position]
        holder.TITLE.text = tarifs.title
        holder.MGB.text = tarifs.mgb
        holder.MIN.text = tarifs.min
        holder.SMS.text = tarifs.sms
        holder.NARX.text = tarifs.narx

        holder.view.setOnClickListener { item ->
            Toast.makeText(context, "Cardview selected at position $position", Toast.LENGTH_SHORT)
                .show()
//            var intent = Intent(context, DetailActivity::class.java)
//            intent.putExtra("title", tariffs[position].title)
//            intent.putExtra("desc", tariffs[position].desc)
//            context?.startActivity(intent)
        }

    }

}