package com.example.lamp.presenter

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lamp.domain.ChangeBaseUrlUseCase
import com.example.lamp.domain.SetStateUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val setStateUseCase: SetStateUseCase,
    private val changeBaseUrlUseCase: ChangeBaseUrlUseCase,
) : ViewModel() {

    fun setState(isOn: Boolean){
        viewModelScope.launch {
            setStateUseCase(isOn)
        }
    }

    fun changeBaseUrl(baseUrl: String){
        viewModelScope.launch {
            changeBaseUrlUseCase(baseUrl)
        }
    }

}