package com.burgutsoft.smartoffice.ui.fragments.home

import com.burgutsoft.smartoffice.model.home.*

interface HomeViewModel {
    fun getRooms(block: (Result<ArrayList<RoomResponse>>) -> Unit)

    fun getAllCond(block: (Result<ArrayList<CondResponse>>) -> Unit)

    fun getAllLamps(block: (Result<ArrayList<RoomLampResponse>>) -> Unit)

    fun getTemp(block: (Result<TempResponse>) -> Unit)

    fun getDate(block: (Result<DateResponse>) -> Unit)

    fun updateLamp(lampid: Int, block: (Result<UpdateLampResponse>) -> Unit)
}