package com.project.aqualife

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayoutMediator
import com.project.aqualife.adapter.ViewPagerAdapter
import com.project.aqualife.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var binding : ActivityMainBinding? = null
    private var tabName = listOf("PH", "HOME", "FILTRATION", "LIGHT", "REGULATOR", "TEMPERATURE")
    var viewPager : ViewPager2? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding!!.root)

        val tabLayout = binding!!.tabLayout
        viewPager = binding!!.viewPager

        viewPager!!.adapter = ViewPagerAdapter(this)
        viewPager!!.currentItem = 1

        TabLayoutMediator(tabLayout, viewPager!!){ tab, pos ->
            tab.text = tabName[pos]
        }.attach()

        // ViewPager 순환 스크롤
        viewPager?.registerOnPageChangeCallback(object :ViewPager2.OnPageChangeCallback(){
            var currentPos = 0
            var currentState = 0

            override fun onPageScrollStateChanged(state: Int) {
                super.onPageScrollStateChanged(state)
                handleScroll(state)
                currentState = state
            }

            private fun handleScroll(state : Int){
                if(state == ViewPager2.SCROLL_STATE_IDLE && currentState == ViewPager2.SCROLL_STATE_DRAGGING){
                    if(currentState != ViewPager2.SCROLL_STATE_SETTLING){
                        val lastPosition = viewPager!!.adapter?.itemCount!!

                        if(currentPos == 0)
                            viewPager!!.currentItem = lastPosition
                        else
                            viewPager!!.currentItem = 0
                    }
                }
            }

            override fun onPageSelected(position: Int) {
                currentPos = position
                super.onPageSelected(position)
            }
        })
    }

    override fun onDestroy() {
        binding = null
        super.onDestroy()
    }
}