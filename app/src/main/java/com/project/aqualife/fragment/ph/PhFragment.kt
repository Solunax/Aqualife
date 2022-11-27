package com.project.aqualife.fragment.ph

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.project.aqualife.MainActivity
import com.project.aqualife.databinding.PhFragmentBinding
import com.project.aqualife.recycler.PhRecyclerAdapter
import com.project.aqualife.viewModel.AuthViewModel
import com.project.aqualife.viewModel.DataViewModel

class PhFragment : Fragment() {
    private var binding : PhFragmentBinding? = null
    private val authViewModel by activityViewModels<AuthViewModel>()
    private val dataViewModel by activityViewModels<DataViewModel>()

    private val recyclerAdapter : PhRecyclerAdapter by lazy { PhRecyclerAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = PhFragmentBinding.inflate(inflater, container, false)

        val ph = binding!!.phDataTextView
        val phMax = binding!!.phCautionData2
        val phMin = binding!!.phCautionData
        var count = 0
        val recycler = binding!!.aquariumRecycler

        recyclerAdapter.setHasStableIds(true)
        recycler.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        recycler.adapter = recyclerAdapter

        dataViewModel.recentIndex.observe(requireActivity()){
            ph.text = (activity as MainActivity).aquariumList[it].phValue
        }

        dataViewModel.recentIndex.observe(requireActivity()){
            count = it
            phMax.text = (activity as MainActivity).aquariumList[it].phWarningMax
            phMin.text = (activity as MainActivity).aquariumList[it].phWarningMin
        }

        // 데이터 변경시 recycler view 갱신
        authViewModel.aquariumData.observe(requireActivity()) {
            recyclerAdapter.setData(it)
            phMax.text = (activity as MainActivity).aquariumList[count].phWarningMax
            phMin.text = (activity as MainActivity).aquariumList[count].phWarningMin
        }
        return binding!!.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}