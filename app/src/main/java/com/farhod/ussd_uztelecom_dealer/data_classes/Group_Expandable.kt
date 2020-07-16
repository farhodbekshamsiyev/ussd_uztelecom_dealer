package com.farhod.ussd_uztelecom_dealer.data_classes

import com.farhod.ussd_uztelecom_dealer.model.ChildItemDataClass
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup

class Group_Expandable(title: String?, items: List<ChildItemDataClass?>?) :
    ExpandableGroup<ChildItemDataClass?>(title, items)