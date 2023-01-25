package com.burgutsoft.smartoffice.model.home

import com.google.gson.annotations.SerializedName

data class TempResponse (

    @SerializedName("intemp"  ) var intemp  : String? = null,
    @SerializedName("outtemp" ) var outtemp : String? = null

)