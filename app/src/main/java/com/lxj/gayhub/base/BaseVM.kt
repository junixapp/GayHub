package com.lxj.gayhub.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.lxj.gayhub.vm.enum.UIState

/**
 * hold UI state and data,  process data&state then LiveData will notify UI update.
 * ViewModel should never touch UI, such as Activity, Fragment.
 * If you need Application/Context, maybe you need a AndroidViewModel,
 * or a global Application instance.
 */
open class BaseVM: ViewModel(){
    val uiState = MutableLiveData<UIState>()
}