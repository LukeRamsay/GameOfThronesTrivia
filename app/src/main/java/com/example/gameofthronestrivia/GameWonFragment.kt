package com.example.gameofthronestrivia

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.example.gameofthronestrivia.databinding.FragmentGameWonBinding

/**
 * A simple [Fragment] subclass.
 */
class GameWonFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_game_won, container, false)
        //Navigation from win screen to home screen
        val binding: FragmentGameWonBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_game_won, container, false)
        binding.homeButton.setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.action_gameWonFragment_to_homeFragment)
        )
        return binding.root
    }

}
