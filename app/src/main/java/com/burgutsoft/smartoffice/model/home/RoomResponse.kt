package com.burgutsoft.smartoffice.model.home

import com.google.gson.annotations.SerializedName

data class RoomResponse (

    @SerializedName("roomid" ) var roomid : Int?    = null,
    @SerializedName("name"   ) var name   : String? = null,
    @SerializedName("ptop"   ) var ptop   : String? = null,
    @SerializedName("pleft"  ) var pleft  : String? = null

)