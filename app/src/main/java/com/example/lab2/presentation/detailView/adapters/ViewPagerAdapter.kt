package com.example.lab2.presentation.detailView.tabs.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.example.lab2.presentation.detailView.fragments.GeneralFragment
import com.example.lab2.presentation.detailView.fragments.HistoryFragment
import com.example.lab2.presentation.detailView.fragments.GraphFragment


class ViewPagerAdapter(fragmentManager: FragmentManager):
    FragmentStatePagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    private val tabTitles: Array<String> = arrayOf(
        "Friends",
        "Groups",
        "Calls"
    )

    private val pagerFragments: Array<Fragment> = arrayOf(
        HistoryFragment(),
        GraphFragment(),
        GeneralFragment()
    )

    override fun getItem(position: Int): Fragment {
        return pagerFragments[position]
    }

    override fun getCount(): Int {
        return pagerFragments.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return tabTitles[position]
    }
}