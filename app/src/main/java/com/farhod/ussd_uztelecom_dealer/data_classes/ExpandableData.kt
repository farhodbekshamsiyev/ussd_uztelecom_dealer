package com.farhod.ussd_uztelecom_dealer.data_classes

data class ExpandableData(
    val type: Int = 0,
    val titlepr: String = "",
    val title: String = "",
    val description: String = "",
    val costs: String = "",
    var children: List<ExpandableData>? = null
)