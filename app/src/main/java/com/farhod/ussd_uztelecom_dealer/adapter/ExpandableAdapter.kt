package com.farhod.ussd_uztelecom_dealer.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.farhod.ussd_uztelecom_dealer.R
import com.farhod.ussd_uztelecom_dealer.data_classes.Group_Expandable
import com.farhod.ussd_uztelecom_dealer.model.ChildItemDataClass
import com.thoughtbot.expandablerecyclerview.ExpandableRecyclerViewAdapter
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup


class ExpandableAdapter(groups: List<ExpandableGroup<*>?>?, var context: Context?) :
    ExpandableRecyclerViewAdapter<Group_VH, Child_VH>(groups) {

    override fun onCreateGroupViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): Group_VH {
        val v: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.cardview_parent, parent, false)
        return Group_VH(v)
    }

    override fun onCreateChildViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): Child_VH {
        val v: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.cardview_item_child, parent, false)
        return Child_VH(v)
    }

    override fun onBindChildViewHolder(
        holder: Child_VH,
        flatPosition: Int,
        group: ExpandableGroup<*>,
        childIndex: Int
    ) {
        val product: ChildItemDataClass = group.items[childIndex] as ChildItemDataClass
        holder.bind(product)
    }

    override fun onBindGroupViewHolder(
        holder: Group_VH,
        flatPosition: Int,
        group: ExpandableGroup<*>?
    ) {
        val company: Group_Expandable? = group as Group_Expandable?
        holder.bind(company)
    }
}
