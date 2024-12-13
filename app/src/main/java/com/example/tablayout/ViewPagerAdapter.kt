package com.example.tablayout

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {

    private var registeredEmail: String? = null
    private var registeredPassword: String? = null

    override fun getItemCount(): Int {
        return 2 // Number of tabs
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> LoginFragment.newInstance(registeredEmail ?: "", registeredPassword ?: "") // Pass the registered data
            1 -> RegisterFragment()
            else -> LoginFragment.newInstance(registeredEmail ?: "", registeredPassword ?: "")
        }
    }

    fun updateLoginFragmentData(email: String, password: String) {
        registeredEmail = email
        registeredPassword = password
        notifyItemChanged(0) // Notify that the first fragment needs to be updated
    }
}
