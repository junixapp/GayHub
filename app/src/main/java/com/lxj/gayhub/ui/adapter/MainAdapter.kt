package com.lxj.gayhub.ui.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.lxj.gayhub.ui.frag.ExploreFragment
import com.lxj.gayhub.ui.frag.MeFragment
import com.lxj.gayhub.ui.frag.SearchFragment

class MainAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        return when(position){
            0 -> ExploreFragment()
            1 -> SearchFragment()
            2 -> MeFragment()
            else -> Fragment()
        }
    }
    override fun getCount() = 3
}