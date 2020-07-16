package com.farhod.ussd_uztelecom_dealer.model


import com.google.gson.annotations.SerializedName

data class Sms(
    @SerializedName("Har kunlik SMS")
    val harKunlikSMS: List<ChildItemDataClass>?,
    @SerializedName("Standart paketlar")
    val standartPaketlar: List<ChildItemDataClass>?,
    @SerializedName("Xalqaro SMS-paketlar")
    val xalqaroSMSPaketlar: List<ChildItemDataClass>?
)