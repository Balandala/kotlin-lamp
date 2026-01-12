package com.example.lamp.presenter.ui

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.lamp.R
import com.example.lamp.databinding.FragmentMainBinding
import com.example.lamp.di.ViewModelFactory
import com.example.lamp.di.appComponent
import com.example.lamp.domain.SetStateUseCase
import com.example.lamp.presenter.MainViewModel
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

    override fun onStart() {
        binding.buttonOn.setOnClickListener { viewModel.setState(true) }
        binding.buttonOff.setOnClickListener { viewModel.setState(false) }
        super.onStart()
    }


}