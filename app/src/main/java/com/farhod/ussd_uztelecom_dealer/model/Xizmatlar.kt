package com.farhod.ussd_uztelecom_dealer.model

import com.google.gson.annotations.SerializedName

data class Xizmatlar(
    @SerializedName("Standart paketlar")
    val standartXizmatlar: List<ChildItemDataClass>?
)