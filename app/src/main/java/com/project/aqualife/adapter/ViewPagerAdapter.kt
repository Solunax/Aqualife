package com.project.aqualife.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.project.aqualife.fragment.*

class ViewPagerAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity){
    override fun getItemCount(): Int = 7

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 -> PHFragment()
            1 -> HomeFragment()
            2 -> FiltrationFragment()
            3 -> FeedFragment()
            4 -> LightFragment()
            5 -> RegulatorFragment()
            6 -> TemperatureFragment()
            else -> HomeFragment()
        }
    }
}