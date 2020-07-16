package com.farhod.ussd_uztelecom_dealer.adapter

import android.content.Intent
import android.view.View

import android.widget.TextView
import com.farhod.ussd_uztelecom_dealer.Details
import com.farhod.ussd_uztelecom_dealer.R
import com.farhod.ussd_uztelecom_dealer.model.ChildItemDataClass

import com.thoughtbot.expandablerecyclerview.viewholders.ChildViewHolder


class Child_VH(itemView: View) : ChildViewHolder(itemView) {
    private val mTextView: TextView
    private val mDescription: TextView
    private val mCosts: TextView

    private val view: View

    fun bind(child: ChildItemDataClass) {
        mTextView.text = child.title
        mDescription.text = child.descshort
        mCosts.text = child.cost

        itemView.setOnClickListener {
            val intent = Intent(itemView.context, Details::class.java)

            intent.putExtra("param1", child.title)
            intent.putExtra("param2", child.titletype)
            intent.putExtra("param3", child.descshort)
            intent.putExtra("param4", child.desclong)
            intent.putExtra("param5", child.cost)
            intent.putExtra("param6", child.type)
            intent.putExtra("param7", child.activate)
            intent.putExtra("param8", child.deactivate)
            intent.putExtra("param9", child.check)

            itemView.context.startActivity(intent)
//            Toast.makeText(context, "${childIndex} Bosildi ", Toast.LENGTH_SHORT).show()
        }
    }

    init {
        mTextView = itemView.findViewById(R.id.card_xizmatlar_title)
        mDescription = itemView.findViewById(R.id.card_xizmatlar_description)
        mCosts = itemView.findViewById(R.id.card_xizmatlar_costs)

        view = itemView
    }
}