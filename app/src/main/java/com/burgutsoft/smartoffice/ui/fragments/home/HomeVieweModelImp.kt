package com.burgutsoft.smartoffice.ui.fragments.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.burgutsoft.smartoffice.model.home.*
import com.burgutsoft.smartoffice.repository.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeVieweModelImp @Inject constructor(private val mainRepository: MainRepository):
    ViewModel(),
    HomeViewModel {

    override fun getRooms(block: (Result<ArrayList<RoomResponse>>) -> Unit) {
        viewModelScope.launch {
            try {
                block(Result.success(mainRepository.getRooms()))
            }catch (e: Exception){
                block(Result.failure(e))
            }
        }
    }

    override fun getAllCond(block: (Result<ArrayList<CondResponse>>) -> Unit) {
        viewModelScope.launch {
            try {
                block(Result.success(mainRepository.getAllCond()))
            }catch (e: Exception){
                block(Result.failure(e))
            }
        }
    }

    override fun getAllLamps(block: (Result<ArrayList<RoomLampResponse>>) -> Unit) {
        viewModelScope.launch {
            try {
                block(Result.success(mainRepository.getAllLamps()))
            }catch (e: Exception){
                block(Result.failure(e))
            }
        }
    }

    override fun getTemp(block: (Result<TempResponse>) -> Unit) {
        viewModelScope.launch {
            try {
                block(Result.success(mainRepository.getTemp()))
            }catch (e: Exception){
                block(Result.failure(e))
            }
        }
    }

    override fun getDate(block: (Result<DateResponse>) -> Unit) {
        viewModelScope.launch {
            try {
                block(Result.success(mainRepository.getDate()))
            }catch (e: Exception){
                block(Result.failure(e))
            }
        }
    }

    override fun updateLamp(lampid: Int, block: (Result<UpdateLampResponse>) -> Unit) {
        viewModelScope.launch {
            try {
                block(Result.success(mainRepository.updateLamp(lampid)))
            }catch (e: Exception){
                block(Result.failure(e))
            }
        }
    }
}