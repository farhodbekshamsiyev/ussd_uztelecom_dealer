package com.farhod.ussd_uztelecom_dealer.model

import com.google.gson.annotations.SerializedName

data class Barcha(
    @SerializedName("Standart paketlar")
    val standartPaketlar: List<ChildItemDataClass>?
)
