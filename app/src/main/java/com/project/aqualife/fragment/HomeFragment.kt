package com.project.aqualife.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.project.aqualife.MainActivity
import com.project.aqualife.databinding.HomeFragmentBinding

class HomeFragment :Fragment(){
    private var binding : HomeFragmentBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = HomeFragmentBinding.inflate(inflater, container, false)

        val temperature = binding!!.temperature
        val filtration = binding!!.filtration
        val light = binding!!.light
        val co2 = binding!!.co2
        val ph = binding!!.ph

        ph.setOnClickListener {
            (activity as MainActivity).viewPager?.currentItem = 0
        }

        filtration.setOnClickListener {
            (activity as MainActivity).viewPager?.currentItem = 2
        }

        light.setOnClickListener {
            (activity as MainActivity).viewPager?.currentItem = 3
        }

        co2.setOnClickListener {
            (activity as MainActivity).viewPager?.currentItem = 4
        }

        temperature.setOnClickListener {
            (activity as MainActivity).viewPager?.currentItem = 5
        }

        return binding!!.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}