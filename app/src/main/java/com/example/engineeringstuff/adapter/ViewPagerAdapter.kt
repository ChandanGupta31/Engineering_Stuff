package com.example.engineeringstuff.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.engineeringstuff.fragment.*

class ViewPagerAdapter(val fm : FragmentManager, private val lifecycle : Lifecycle, private val year : String?) : FragmentStateAdapter(fm,lifecycle) {


    override fun getItemCount(): Int {
        return  6
    }

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 -> cse(year)
            1 -> it(year)
            2 -> ai(year)
            3 -> ece(year)
            4 -> mee(year)
            else -> che(year)
        }
    }


}