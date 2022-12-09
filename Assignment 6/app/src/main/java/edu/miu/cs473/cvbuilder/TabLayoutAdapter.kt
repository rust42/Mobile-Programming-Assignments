package edu.miu.cs473.cvbuilder

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import edu.miu.cs473.cvbuilder.AboutmeFragment
import edu.miu.cs473.cvbuilder.ContactFragment
import edu.miu.cs473.cvbuilder.HomeFragment
import edu.miu.cs473.cvbuilder.WorkFragment

class TabLayoutAdapter(fragmentActivity: FragmentActivity): FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int {
        return 4
    }

    override fun createFragment(position: Int): Fragment {
        return when(position) {
            0 -> HomeFragment()
            1 -> AboutmeFragment()
            2 -> WorkFragment()
            else -> ContactFragment()
        }
    }
}