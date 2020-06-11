package com.example.gameofthronestrivia

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gameofthronestrivia.databinding.FragmentHomeBinding

/**
 * A simple [Fragment] subclass.
 * This Fragment is for my home/landing page
 */
class HomeFragment : Fragment(), OnCategoryItemClickListener {

    private val viewModel: GameViewModel by activityViewModels()

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
        val categoryList = generateDummyList(6)
        binding.categoryList.adapter = CategoryAdapter(categoryList, this)
        binding.categoryList.layoutManager = LinearLayoutManager(context)
        binding.categoryList.setHasFixedSize(true)
        return binding.root
    }

    private fun generateDummyList(size: Int): List<CategoryItem> {

        val list = ArrayList<CategoryItem>()
        for (i in 0 until size){
            val item = CategoryItem(i,  "Category $i")
            list += item
        }
        return list
    }

    override fun onCategoryClick(category: CategoryItem, position: Int, view: View) {
        Toast.makeText(context, "The current category text: ${category.text} the category id: ${category.id}", Toast.LENGTH_SHORT).show()
        viewModel.setUpGame(category.id)
        view.findNavController().navigate(R.id.action_homeFragment_to_gameFragment)
    }

}
