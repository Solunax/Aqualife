package com.project.aqualife.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.project.aqualife.databinding.HomeFragmentBinding
import com.project.aqualife.databinding.PhFragmentBinding

class PHFragment : Fragment() {
    private var binding : PhFragmentBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = PhFragmentBinding.inflate(inflater, container, false)


        return binding!!.root
    }

    override fun onDestroy() {
        binding = null
        super.onDestroy()
    }
}