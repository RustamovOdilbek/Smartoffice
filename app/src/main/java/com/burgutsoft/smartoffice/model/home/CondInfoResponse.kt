package com.burgutsoft.smartoffice.model.home

import com.google.gson.annotations.SerializedName


data class CondInfoResponse (

    @SerializedName("condid"    ) var condid    : String? = null,
    @SerializedName("roomid"    ) var roomid    : Int?    = null,
    @SerializedName("sonoff"    ) var sonoff    : String? = null,
    @SerializedName("sswingud"  ) var sswingud  : String? = null,
    @SerializedName("scoolheat" ) var scoolheat : String? = null,
    @SerializedName("sspeedfan" ) var sspeedfan : String? = null,
    @SerializedName("temp"      ) var temp      : String? = null

)