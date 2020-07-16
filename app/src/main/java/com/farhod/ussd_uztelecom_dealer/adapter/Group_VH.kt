package com.farhod.ussd_uztelecom_dealer.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.farhod.ussd_uztelecom_dealer.R
import com.farhod.ussd_uztelecom_dealer.data_classes.Group_Expandable
import com.thoughtbot.expandablerecyclerview.viewholders.GroupViewHolder


class Group_VH(itemView: View) : GroupViewHolder(itemView) {
    private val mTextView: TextView
    private val arrow: ImageView
    fun bind(group: Group_Expandable?) {
        mTextView.text = group?.title
    }

    override fun expand() {
        animateExpand()
    }

    override fun collapse() {
        animateCollapse()
    }

    private fun animateExpand() {
//        val rotate = RotateAnimation(
//            360F,
//            180F,
//            RELATIVE_TO_SELF,
//            0.5f,
//            RELATIVE_TO_SELF,
//            0.5f
//        )
//        rotate.duration = 300
//        rotate.fillAfter = true
//        arrow.animation = rotate
        arrow.setImageResource(R.drawable.ic_round_arrow_up)
    }

    private fun animateCollapse() {
//        val rotate = RotateAnimation(
//            180F,
//            360F,
//            RELATIVE_TO_SELF,
//            0.5f,
//            RELATIVE_TO_SELF,
//            0.5f
//        )
//        rotate.duration = 300
//        rotate.fillAfter = true
//        arrow.animation = rotate
        arrow.setImageResource(R.drawable.ic_round_arrow_down)
    }

    init {
        mTextView = itemView.findViewById(R.id.cardview_parent_tv_title)
        arrow = itemView.findViewById(R.id.cardview_parent_img)
    }
}