package com.project.aqualife.fragment.temperature

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.project.aqualife.MainActivity
import com.project.aqualife.databinding.TemperatureFragmentBinding
import com.project.aqualife.recycler.TemperatureRecyclerAdapter
import com.project.aqualife.viewModel.DataViewModel
import com.project.aqualife.viewModel.AuthViewModel

class TemperatureFragment : Fragment(){
    private var binding : TemperatureFragmentBinding? = null
    private val authViewModel by activityViewModels<AuthViewModel>()
    private val dataViewModel by activityViewModels<DataViewModel>()
    private val recyclerAdapter : TemperatureRecyclerAdapter by lazy{ TemperatureRecyclerAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = TemperatureFragmentBinding.inflate(inflater, container, false)

        val temperature = binding!!.temperature
        val recycler = binding!!.aquariumRecycler

        recyclerAdapter.setHasStableIds(true)
        recycler.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        recycler.adapter = recyclerAdapter

        dataViewModel.recentIndex.observe(requireActivity()){
            temperature.text = (activity as MainActivity).aquariumList[it].temperatureValue
        }

        authViewModel.aquariumData.observe(requireActivity()){
            recyclerAdapter.setData(it)
        }

        return binding!!.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}