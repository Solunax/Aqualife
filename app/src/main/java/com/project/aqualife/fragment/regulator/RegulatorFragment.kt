package com.project.aqualife.fragment.regulator

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.project.aqualife.R
import com.project.aqualife.databinding.RegulatorFragmentBinding

class RegulatorFragment : Fragment() {
    private var binding : RegulatorFragmentBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = RegulatorFragmentBinding.inflate(inflater, container, false)

        val regulatorOn = binding!!.regulatorOn
        val regulatorOff = binding!!.regulatorOff
        val text = binding!!.regulatorText

        regulatorOn.setOnClickListener {
            text.setTextColor(ContextCompat.getColor(requireActivity(), R.color.mYellow))
        }

        regulatorOff.setOnClickListener {
            text.setTextColor(ContextCompat.getColor(requireActivity(), R.color.black))
        }

        return binding!!.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}