package com.burgutsoft.smartoffice.ui.fragments.dialog

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.burgutsoft.smartoffice.model.home.CondInfoResponse
import com.burgutsoft.smartoffice.model.home.UpdateCondResponse
import com.burgutsoft.smartoffice.repository.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CondDialogViewModelImp  @Inject constructor(private val mainRepository: MainRepository):
    ViewModel(),
    CondDialogViewModel {
    override fun condInfo(condid: Int, block: (Result<CondInfoResponse>) -> Unit) {
        viewModelScope.launch {
            try {
                block(Result.success(mainRepository.condInfo(condid)))
            }catch (e: Exception){
                block(Result.failure(e))
            }
        }
    }

    override fun updateCond(condid: Int, key: String, block: (Result<UpdateCondResponse>) -> Unit) {
        viewModelScope.launch {
            try {
                block(Result.success(mainRepository.updateCond(condid, key)))
            }catch (e: Exception){
                Log.d("TAG", "updateCond: ${e}")
                block(Result.failure(e))
            }
        }
    }
}