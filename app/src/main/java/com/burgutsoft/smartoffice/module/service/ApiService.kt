package com.burgutsoft.smartoffice.module.service

import com.burgutsoft.smartoffice.model.home.*
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("api.php?mod=getrooms")
    suspend fun getRooms(): ArrayList<RoomResponse>

    @GET("api.php?mod=getallcond")
    suspend fun getAllCond(): ArrayList<CondResponse>

    @GET("api.php?mod=getalllamp")
    suspend fun getAllLamps(): ArrayList<RoomLampResponse>

    @GET("api.php?mod=gettemp")
    suspend fun getTemp(): TempResponse

    @GET("api.php?mod=getdate")
    suspend fun getDate(): DateResponse

    @GET("api.php?mod=updatelamp")
    suspend fun updateLamp(@Query("lampid") lampid: Int): UpdateLampResponse

    @GET("api.php?mod=getcond")
    suspend fun condInfo(@Query("condid") idcondid: Int): CondInfoResponse

    @GET("api.php?mod=updatecond")
    suspend fun updateCond(@Query("condid") idcondid: Int, @Query("key") key: String): UpdateCondResponse

}