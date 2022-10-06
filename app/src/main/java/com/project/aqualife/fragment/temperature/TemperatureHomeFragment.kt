package com.project.aqualife.fragment.temperature

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.project.aqualife.adapter.TemperaturePagerAdapter
import com.project.aqualife.databinding.TemperatureHomeFragmentBinding

class TemperatureHomeFragment : Fragment() {
    private var binding : TemperatureHomeFragmentBinding? = null
    private lateinit var viewPager : ViewPager2
    private lateinit var callback : OnBackPressedCallback

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = TemperatureHomeFragmentBinding.inflate(inflater, container, false)

        viewPager = binding!!.temperatureViewPager
        val control = binding!!.temperatureControl

        viewPager.adapter = TemperaturePagerAdapter(requireActivity())

        // 플로팅 버튼 클릭 이벤트
        control.setOnClickListener {
            if (viewPager.currentItem == 0)
                viewPager.currentItem = 1
        }

        // 뒤로가기 버튼 터치시 콜백
        callback = object : OnBackPressedCallback(true){
            override fun handleOnBackPressed() {
                if(viewPager.currentItem != 0)
                    viewPager.currentItem = viewPager.currentItem - 1
            }
        }

        requireActivity().onBackPressedDispatcher.addCallback(callback)

        return binding!!.root
    }

    override fun onPause() {
        super.onPause()
        viewPager.currentItem = 0
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}