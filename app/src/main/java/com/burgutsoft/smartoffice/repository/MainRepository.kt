package com.burgutsoft.smartoffice.repository

import com.burgutsoft.smartoffice.module.service.ApiService
import javax.inject.Inject

class MainRepository @Inject constructor(private val apiService: ApiService){

    suspend fun getRooms() = apiService.getRooms()

    suspend fun getAllCond() = apiService.getAllCond()

    suspend fun getAllLamps() = apiService.getAllLamps()

    suspend fun getTemp() = apiService.getTemp()

    suspend fun getDate() = apiService.getDate()

    suspend fun updateLamp(lampid: Int) = apiService.updateLamp(lampid)

    suspend fun condInfo(condid: Int) = apiService.condInfo(condid)

    suspend fun updateCond(condid: Int, key: String) = apiService.updateCond(condid, key)

}