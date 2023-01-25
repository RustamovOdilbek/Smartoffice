package com.burgutsoft.smartoffice.ui.fragments.dialog

import com.burgutsoft.smartoffice.model.home.CondInfoResponse
import com.burgutsoft.smartoffice.model.home.UpdateCondResponse

interface CondDialogViewModel {
    fun condInfo(condid: Int, block: (Result<CondInfoResponse>) -> Unit)

    fun updateCond(condid: Int, key: String, block: (Result<UpdateCondResponse>) -> Unit)
}