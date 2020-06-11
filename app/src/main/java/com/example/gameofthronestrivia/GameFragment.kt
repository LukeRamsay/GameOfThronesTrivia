package com.example.gameofthronestrivia

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.RadioButton
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.navigation.findNavController
import com.example.gameofthronestrivia.databinding.FragmentGameBinding

/**
 * A simple [Fragment] subclass.
 * Fragment for the game screen
 */
class GameFragment : Fragment() {

    private val viewModel: GameViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_game, container, false)
//        val viewModel: GameViewModel by viewModels()
        val binding: FragmentGameBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_game, container, false)

        viewModel.score.observe(viewLifecycleOwner, Observer { newScore ->
            //Displaying score over how many questions there are
            binding.score.text = "Score $newScore / ${viewModel.amountOfQuestions.value} "
            //Displaying how many questions they are and what question they are on currently

        })

        viewModel.question.observe(viewLifecycleOwner, Observer { newQuestion ->
            binding.question.text = newQuestion.question

            val rGroup = binding.radioGroup
            rGroup.removeAllViews()
            for ((index, answer) in newQuestion.answers.withIndex()){
                val newRBtn = createRadioBtn(answer, index)
                rGroup.addView((newRBtn))
            }
        })

        binding.submitButton.setOnClickListener {view : View ->
            //Displaying how many questions they are and what question they are on currently
            binding.progress.text = "${viewModel.currentQuestion.value!!.plus(1)} / ${viewModel.amountOfQuestions.value} "
            val id = binding.radioGroup.checkedRadioButtonId
            viewModel.checkQuestion(id)
            Toast.makeText(context, "This is the current ID: ${viewModel.currentQuestion.value}", Toast.LENGTH_SHORT).show()
            if(viewModel.currentQuestion.value!! < viewModel.amountOfQuestions.value!!.minus(1)) {
                viewModel.updateQuestion(viewModel.currentQuestion.value ?: 0)
            } else  {
                if(viewModel.score.value!! == viewModel.amountOfQuestions.value!!){
                    view.findNavController().navigate(R.id.action_gameFragment_to_gameWonFragment)
                } else{
                    view.findNavController().navigate(R.id.action_gameFragment_to_gameLostFragment)
                }
            }
        }

        return binding.root
    }

    private fun createRadioBtn(answer: String, id: Int): RadioButton{
        val rdb = RadioButton(context)
        rdb.layoutParams = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        rdb.text = answer
        rdb.id = id
        return rdb
    }
}
