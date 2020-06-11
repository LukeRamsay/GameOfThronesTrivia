package com.example.gameofthronestrivia

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gameofthronestrivia.databinding.FragmentHomeBinding

/**
 * A simple [Fragment] subclass.
 * This Fragment is for my home/landing page
 */
class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        // return inflater.inflate(R.layout.fragment_home, container, false)
        val binding: FragmentHomeBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        binding.catButton.setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.action_homeFragment_to_gameFragment)
        )
        val categoryList = generateDummyList(10)
        binding.categoryList.adapter = CategoryAdapter(categoryList)
        binding.categoryList.layoutManager = LinearLayoutManager(context)
        binding.categoryList.setHasFixedSize(true)
        return binding.root
    }

    private fun generateDummyList(size: Int): List<CategoryItem> {

        val list = ArrayList<CategoryItem>()
        for (i in 0 until size){
            val item = CategoryItem("Category $i")
            list += itemf
        }
        return list
    }

}
