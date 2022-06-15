package com.example.chapter5_viewpager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.chapter5_viewpager.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

//        val fragmentList = listOf(FragmentA(), FragmentB(), FragmentC(), FragmentD())
//        val adapter = FragmentAdapter(this)
//        adapter.fragmentList = fragmentList
//
//        binding.viewPager.adapter = adapter

//        val tabTitles = listOf<String>("A", "B", "C", "D")

//        TabLayoutMediator(binding.tabLayout, binding.viewPager) {tab, position->
//            tab.text = tabTitles[position]
//        }.attach()

        val textList = listOf<String>("뷰A", "뷰B", "뷰C", "뷰D")

        val customAdapter = CustomPagerAdapter()
        customAdapter.textList = textList
        binding.viewPager.adapter = customAdapter

        val tabTitles = listOf("view A", "view B", "view C", "view D")

        TabLayoutMediator(binding.tabLayout, binding.viewPager){tab, position ->
            tab.text = tabTitles[position]
        }.attach()

    }
}