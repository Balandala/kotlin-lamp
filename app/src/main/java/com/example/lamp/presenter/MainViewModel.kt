package com.example.lamp.presenter

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lamp.UiState
import com.example.lamp.data.remote.dto.BrightnessLevelsDTO
import com.example.lamp.domain.ChangeBaseUrlUseCase
import com.example.lamp.domain.GetBrightnessLevelsUseCase
import com.example.lamp.domain.GetColorsUseCase
import com.example.lamp.domain.GetCurrentBrightnessUseCase
import com.example.lamp.domain.SetBrightnessUseCase
import com.example.lamp.domain.SetColorUseCase
import com.example.lamp.domain.SetStateUseCase
import com.example.lamp.toUiState
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val setStateUseCase: SetStateUseCase,
    private val changeBaseUrlUseCase: ChangeBaseUrlUseCase,
    private val getBrightnessLevelsUseCase: GetBrightnessLevelsUseCase,
    private val getCurrentBrightnessUseCase: GetCurrentBrightnessUseCase,
    private val setBrightnessUseCase: SetBrightnessUseCase,
    private val getColorsUseCase: GetColorsUseCase,
    private val setColorUseCase: SetColorUseCase,

) : ViewModel() {

    private val _brightnessLevelsLiveData = MutableLiveData<UiState<BrightnessLevelsDTO?>>(UiState.Loading)
    val brightnessLevelsLiveData: LiveData<UiState<BrightnessLevelsDTO?>>
        get() = _brightnessLevelsLiveData

    fun loadBrightnessLevels() {
        viewModelScope.launch {
            val result = getBrightnessLevelsUseCase()
            _brightnessLevelsLiveData.postValue(result.toUiState())
        }
    }

    private val _currentBrightnessLiveData = MutableLiveData<UiState<Int?>>(UiState.Loading)
    val currentBrightnessLiveData: LiveData<UiState<Int?>>
        get() = _currentBrightnessLiveData

    fun loadCurrentBrightness() {
        viewModelScope.launch {
            val result = getCurrentBrightnessUseCase()
            _currentBrightnessLiveData.postValue(result.toUiState())
        }
    }

    private val _colorsLiveData = MutableLiveData<UiState<List<String>?>>(UiState.Loading)
    val colorsLiveData: LiveData<UiState<List<String>?>>
        get() = _colorsLiveData

    fun loadAllColors(){
        viewModelScope.launch {
            val result = getColorsUseCase()
            _colorsLiveData.postValue(result.toUiState())
        }
    }

    fun setColor(color: String){
        viewModelScope.launch {
            setColorUseCase(color)
        }
    }
    fun setBrightness(level: Int){
        viewModelScope.launch {
            setBrightnessUseCase(level)
        }
    }
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