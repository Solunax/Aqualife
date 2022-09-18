package com.project.aqualife.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.project.aqualife.databinding.RegulatorFragmentBinding

class RegulatorFragment : Fragment() {
    private var binding : RegulatorFragmentBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = RegulatorFragmentBinding.inflate(inflater, container, false)


        return binding!!.root
    }

    override fun onDestroy() {
        binding = null
        super.onDestroy()
    }
}