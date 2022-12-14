package com.project.aqualife.fragment.light

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.project.aqualife.MainActivity
import com.project.aqualife.databinding.LightListFragmentBinding
import com.project.aqualife.recycler.TemperatureRegulatorScheduleRecyclerAdapter
import com.project.aqualife.viewModel.AuthViewModel
import com.project.aqualife.viewModel.DataViewModel

class LightListFragment : Fragment() {
    private var binding : LightListFragmentBinding? = null
    private val recyclerAdapter : TemperatureRegulatorScheduleRecyclerAdapter by lazy{ TemperatureRegulatorScheduleRecyclerAdapter(authViewModel) }
    private val authViewModel by activityViewModels<AuthViewModel>()
    private val dataViewModel by activityViewModels<DataViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = LightListFragmentBinding.inflate(inflater, container, false)

        val recycler = binding!!.aquariumRecycler

        recyclerAdapter.setHasStableIds(true)
        recycler.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        recycler.adapter = recyclerAdapter

        // Aquarium 스피너 선택시 선택한 어항의 예약 목록으로 최신화
        dataViewModel.recentIndex.observe(requireActivity()){
            recyclerAdapter.setData((activity as MainActivity).aquariumList[it].lightReservation)
        }

        // 데이터 변경시 recycler view 갱신
        authViewModel.aquariumData.observe(requireActivity()){
            recyclerAdapter.setData(it[dataViewModel.recentIndex.value!!.toInt()].lightReservation)
        }

        return binding!!.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}