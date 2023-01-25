package com.burgutsoft.smartoffice.model.home

import com.google.gson.annotations.SerializedName


data class CondResponse (

    @SerializedName("condid"  ) var condid  : Int?    = null,
    @SerializedName("roomdid" ) var roomdid : Int?    = null,
    @SerializedName("temp"    ) var temp    : String? = null,
    @SerializedName("mode"    ) var mode    : String? = null,
    @SerializedName("status"  ) var status  : String? = null

)