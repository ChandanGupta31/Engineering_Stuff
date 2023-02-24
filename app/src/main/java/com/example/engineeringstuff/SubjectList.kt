package com.example.engineeringstuff

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.example.engineeringstuff.adapter.ViewPagerAdapter
import com.example.engineeringstuff.databinding.ActivitySubjectListBinding
import com.google.android.material.tabs.TabLayout

private lateinit var binding: ActivitySubjectListBinding

class SubjectList : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySubjectListBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        supportActionBar?.title = intent.getStringExtra("title")

        val adapter = ViewPagerAdapter(supportFragmentManager, lifecycle,intent.getStringExtra("year"))
        binding.pageViewer.adapter = adapter

        binding.tabView.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                // Do something when a tab is selected
                binding.pageViewer.setCurrentItem(tab.position)
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {
                // Do something when a tab is unselected
                //Don't Know why this function function is here but if i remove it will give error
            }

            override fun onTabReselected(tab: TabLayout.Tab) {
                // Do something when a tab is reselected
                //Don't Know why this function function is here but if i remove it will give error
            }
        })

        binding.pageViewer.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
                // Do something when the page is scrolled
            }

            override fun onPageSelected(position: Int) {
                // Do something when a new page is selected
                super.onPageSelected(position)
                binding.tabView.getTabAt(position)?.select()
            }

            override fun onPageScrollStateChanged(state: Int) {
                // Do something when the scroll state changes
                //Don't Know why this function function is here but if i remove it will give error
            }
        })

    }
}