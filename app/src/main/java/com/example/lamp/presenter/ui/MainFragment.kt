package com.example.lamp.presenter.ui

import androidx.fragment.app.Fragment
import com.example.lamp.R
import com.example.lamp.databinding.FragmentMainBinding
import dev.androidbroadcast.vbpd.viewBinding

class MainFragment : Fragment(R.layout.fragment_main) {

    val binding: FragmentMainBinding by viewBinding { FragmentMainBinding::bind }
}