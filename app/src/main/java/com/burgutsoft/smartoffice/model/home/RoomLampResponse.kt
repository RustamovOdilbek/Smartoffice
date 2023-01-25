package com.burgutsoft.smartoffice.model.home

import com.google.gson.annotations.SerializedName

data class RoomLampResponse (

    @SerializedName("lampid" ) var lampid : Int? = null,
    @SerializedName("status" ) var status : Int? = null,
    @SerializedName("roomid" ) var roomid : Int? = null

)
