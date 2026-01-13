package com.example.lamp.presenter.ui

import android.content.Context
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.SeekBar
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.lamp.R
import com.example.lamp.UiState
import com.example.lamp.data.remote.dto.BrightnessLevelsDTO
import com.example.lamp.databinding.FragmentMainBinding
import com.example.lamp.di.ViewModelFactory
import com.example.lamp.di.appComponent
import com.example.lamp.presenter.MainViewModel
import com.google.android.material.navigation.NavigationBarView
import dev.androidbroadcast.vbpd.viewBinding
import javax.inject.Inject

class MainFragment : Fragment(R.layout.fragment_main) {

    private val binding: FragmentMainBinding by viewBinding(FragmentMainBinding::bind)

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val viewModel: MainViewModel by viewModels() { viewModelFactory }

    override fun onAttach(context: Context) {
        context.appComponent.inject(this)
        super.onAttach(context)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.buttonOn.setOnClickListener { viewModel.setState(true) }
        binding.buttonOff.setOnClickListener { viewModel.setState(false) }
        binding.buttonChangeUrl.setOnClickListener {
            val baseUrl = binding.inputUrl.text.toString()

            if (baseUrl.contains(Regex("^https?://"))) {
                viewModel.changeBaseUrl(baseUrl)
                viewModel.loadBrightnessLevels()
                viewModel.loadCurrentBrightness()
                viewModel.loadAllColors()
            }
        }

        viewModel.brightnessLevelsLiveData.observe(viewLifecycleOwner){
            onBrightnessLevelsReceived(it)
        }
        viewModel.loadBrightnessLevels()

        viewModel.currentBrightnessLiveData.observe(viewLifecycleOwner){
            onCurrentBrightnessReceived(it)
        }
        viewModel.loadCurrentBrightness()

        binding.brightnessSeekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {}

            override fun onStartTrackingTouch(seekBar: SeekBar?) {}

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                viewModel.setBrightness(binding.brightnessSeekBar.progress)
            }
        })

        viewModel.colorsLiveData.observe(viewLifecycleOwner){
            onColorsReceived(it)
        }
        viewModel.loadAllColors()

    }

    private fun onBrightnessLevelsReceived(brightnessLevels: UiState<BrightnessLevelsDTO?>){
        when (brightnessLevels) {
            is UiState.Success -> {
                val min = brightnessLevels.value?.min
                val max = brightnessLevels.value?.max
                binding.brightnessLayout.visibility = View.VISIBLE
                binding.brightnessSeekBar.min = min!!
                binding.brightnessSeekBar.max = max!!
            }
            is UiState.Loading -> {
                binding.brightnessLayout.visibility = View.GONE
            }
            is UiState.Failure -> {
                binding.brightnessLayout.visibility = View.GONE
            }
            else -> {}
        }
    }

    private fun onCurrentBrightnessReceived(currentBrightness: UiState<Int?>?){
        when (currentBrightness){
            is UiState.Success -> {
                binding.brightnessSeekBar.setProgress(currentBrightness.value!!)
            }
            else -> {}
        }
    }

    private fun onColorsReceived(colors: UiState<List<String>?>?){
        when (colors) {
            is UiState.Success -> {
                val adapter = ArrayAdapter<String>(
                    this.context!!,
                    androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,
                    colors.value!!)
                binding.colorLayout.visibility = View.VISIBLE
                binding.colorSpinner.adapter = adapter
                binding.colorSpinner.post {
                    binding.colorSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
                        override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                            val item = parent?.getItemAtPosition(position).toString()
                            viewModel.setColor(item)
                        }
                        override fun onNothingSelected(parent: AdapterView<*>?) {}
                    }
                }
            }
            is UiState.Loading -> {
                binding.colorLayout.visibility = View.GONE
            }
            is UiState.Failure -> {
                binding.colorLayout.visibility = View.GONE
            }
            else -> {}
        }
    }


}