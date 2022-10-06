package com.project.aqualife.fragment.light

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.project.aqualife.MainActivity
import com.project.aqualife.databinding.LightScheduleAddFragmentBinding

class LightScheduleAddFragment : Fragment() {
    private var binding : LightScheduleAddFragmentBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = LightScheduleAddFragmentBinding.inflate(inflater, container, false)

        val add = binding!!.addSchedule

        add.setOnClickListener {
            (activity as MainActivity).onBackPressed()
            Toast.makeText(context, "조명 일정이 추가되었습니다.", Toast.LENGTH_SHORT).show()
        }

        return binding!!.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}