package com.example.gameofthronestrivia

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
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
        return binding.root
    }

}
