package com.farhod.ussd_uztelecom_dealer.model

import com.google.gson.annotations.SerializedName

data class Internet(
    @SerializedName("Standart paketlar")
    val standartPaketlar: List<ChildItemDataClass>?,
    @SerializedName("Kunlik paketlar")
    val kunlikPaketlar: List<ChildItemDataClass>?,
    @SerializedName("TAS-IX uchun paketlar")
    val tasixPaketlar: List<ChildItemDataClass>?,
    @SerializedName("Tungi Internet")
    val tungiPaketlar: List<ChildItemDataClass>?
)