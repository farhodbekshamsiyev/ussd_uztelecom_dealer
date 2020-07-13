package com.farhod.ussd_uztelecom_dealer.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.farhod.ussd_uztelecom_dealer.R
import com.farhod.ussd_uztelecom_dealer.data_classes.ExpandableData
import com.farhod.ussd_uztelecom_dealer.data_classes.XizmatData
import kotlinx.android.synthetic.main.cardview_item_child.view.*
import kotlinx.android.synthetic.main.cardview_parent.view.*

class ExpandableCardviewAdapter(var items: MutableList<ExpandableData>, var context: Context?) :
    RecyclerView.Adapter<ExpandableCardviewAdapter.ViewHolder>() {

    companion object {
        val PARENT = 0
        val CHILD = 1
        val OPEN = 0.0F
        val CLOSE = 180.0F
    }

    class ViewHolder(item: View) : RecyclerView.ViewHolder(item) {

        var parent_title = item.cardview_parent_tv_title
        var parent_img = item.cardview_parent_img

        val title: TextView = item.card_xizmatlar_title
        val desc: TextView = item.card_xizmatlar_description
        val cost: TextView = item.card_xizmatlar_costs

        var view = item
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {

        val inflater = LayoutInflater.from(parent.context)
        var view: View? = null

        when (viewType) {
            PARENT -> view = inflater.inflate(R.layout.cardview_parent, parent, false)
            CHILD -> view = inflater.inflate(R.layout.cardview_item_child, parent, false)
        }

        return ViewHolder(view!!)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val itemHolder = holder as? ViewHolder
        val item: ExpandableData = items[position]

        itemHolder?.let {
            it.parent_img?.let {
                it.setImageResource(R.drawable.ic_round_arrow_up)
                it.rotation = if (item.children == null) OPEN else CLOSE

                it.setOnClickListener { view ->
                    val start = items.indexOf(item) + 1
                    if (item.children == null) {
                        var count = 0
                        var nextHeader = items.indexOf(items.find {
                            (count++ >= start) && (it.type == item.type)
                        })

                        if (nextHeader == -1) nextHeader = items.size
                        item.children = items.slice(start..nextHeader - 1)

                        val end = item.children!!.size
                        if (end > 0) items.removeAll(item.children!!)

                        view.animate().rotation(CLOSE).start()
                        notifyItemRangeRemoved(start, end)
                    } else {
                        item.children?.let {
                            items.addAll(start, it)
                            view.cardview_parent_img.setImageResource(R.drawable.ic_round_arrow_down)
                            view.animate().rotation(OPEN).start()
                            notifyItemRangeInserted(start, it.size)
                            item.children = null
                        }
                    }
                }
            }

            it.parent_title.text = item.titlepr
            it.parent_img.setImageResource(R.drawable.ic_round_arrow_down)

            it.title.text = item.title
            it.desc.text = item.description
            it.cost.text = item.costs

            it.view.setOnClickListener {
                Toast.makeText(
                    context,
                    "${item.title}: Cardview selected at position $position",
                    Toast.LENGTH_SHORT
                )
                    .show()
            }
        }

//        itemHolder!!.parent_title.text = item.titlepr
//        itemHolder.parent_img.setImageResource(R.drawable.ic_round_arrow_down)
//
//        itemHolder.title.text = item.title
//        itemHolder.desc.text = item.description
//        itemHolder.cost.text = item.costs
//
//        itemHolder?.view?.setOnClickListener {
//            Toast.makeText(
//                context,
//                "${item.title}: Cardview selected at position $position",
//                Toast.LENGTH_SHORT
//            )
//                .show()
//        }
    }

    override fun getItemCount() = items.size

    override fun getItemViewType(position: Int): Int = items[position].type

}