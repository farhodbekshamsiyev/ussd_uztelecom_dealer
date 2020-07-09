package com.farhod.ussd_uztelecom_dealer

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.smarteist.autoimageslider.SliderViewAdapter


class SliderAdapterExample(var context: Context?, var mSliderItems: MutableList<SliderData>) :
    SliderViewAdapter<SliderAdapterExample.SliderAdapterVH>() {

    inner class SliderAdapterVH(itemView: View) : SliderViewAdapter.ViewHolder(itemView) {

        var view = itemView
        var imageViewItem: ImageView = itemView.findViewById(R.id.slider_image_item)

    }

    override fun onCreateViewHolder(parent: ViewGroup): SliderAdapterVH {
        val inflate: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.image_slider_item, null)
        return SliderAdapterVH(inflate)
    }

    override fun onBindViewHolder(
        viewHolder: SliderAdapterVH,
        position: Int
    ) {

        val sliderItem: SliderData = mSliderItems[position]
        viewHolder.imageViewItem.setImageResource(sliderItem.imageName)

        Glide.with(viewHolder.itemView)
            .load(sliderItem.imageName)
            .fitCenter()
            .into(viewHolder.imageViewItem)

        viewHolder.itemView.setOnClickListener {
            Toast.makeText(context, "This is item in position $position", Toast.LENGTH_SHORT)
                .show()
        }
    }

    override fun getCount(): Int {
        //slider view count could be dynamic size
        return mSliderItems.size
    }

}
