package com.project.aqualife.fragment.light

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.project.aqualife.R
import com.project.aqualife.databinding.LightFragmentBinding

class LightFragment : Fragment() {
    private var binding : LightFragmentBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = LightFragmentBinding.inflate(inflater, container, false)

        val lightOn = binding!!.lightOn
        val lightOff = binding!!.lightOff
        val light = binding!!.lightBulb

        lightOn.setOnClickListener {
                light.setColorFilter(ContextCompat.getColor(requireActivity(), R.color.mYellow))
        }

        lightOff.setOnClickListener {
            light.setColorFilter(ContextCompat.getColor(requireActivity(), R.color.gray))
        }

        return binding!!.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}