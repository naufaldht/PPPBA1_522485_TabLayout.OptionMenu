package com.example.tablayout

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.tablayout.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewPagerAdapter: ViewPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Initialize ViewPagerAdapter
        viewPagerAdapter = ViewPagerAdapter(this)
        binding.viewPager.adapter = viewPagerAdapter

        // Setup TabLayout with ViewPager2 using TabLayoutMediator
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            tab.text = when (position) {
                0 -> "Login"
                1 -> "Register"
                else -> null
            }
        }.attach()
    }

    fun updateLoginFragmentData(email: String, password: String) {
        // Update email and password for LoginFragment
        viewPagerAdapter.updateLoginFragmentData(email, password)
    }

    fun switchToLoginTab() {
        binding.viewPager.currentItem = 0 // Switch to Login tab
    }
}
