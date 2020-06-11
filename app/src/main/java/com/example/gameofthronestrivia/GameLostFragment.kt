package com.example.gameofthronestrivia

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.example.gameofthronestrivia.databinding.ActivityMainBinding
import com.example.gameofthronestrivia.databinding.FragmentGameBinding
import com.example.gameofthronestrivia.databinding.FragmentGameLostBinding
import com.example.gameofthronestrivia.databinding.FragmentTitleBinding

/**
 * A simple [Fragment] subclass.
 */
class GameLostFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_game_lost, container, false)
        //Navigation from loss to home
        val binding: FragmentGameLostBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_game_lost, container, false)
        binding.homeButtonLoss.setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.action_gameLostFragment_to_homeFragment)
        )
        return binding.root

    }
}
