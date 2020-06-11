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
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.gameofthronestrivia.databinding.FragmentGameBinding

/**
 * A simple [Fragment] subclass.
 * Fragment for the game screen
 */
class GameFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_game, container, false)
        val viewModel: GameViewModel by viewModels()
        val binding: FragmentGameBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_game, container, false)

        viewModel.question.observe(viewLifecycleOwner, Observer { newQuestion ->
            binding.question.text = newQuestion.question
            val rGroup = binding.radioGroup
            rGroup.removeAllViews()
            for ((index, answer) in newQuestion.answers.withIndex()){
                val newRBtn = createRadioBtn(answer, index)
                rGroup.addView((newRBtn))
            }

            binding.submitButton.setOnClickListener {
                val id = binding.radioGroup.checkedRadioButtonId
                Toast.makeText(context, "This is the current ID: ${id}", Toast.LENGTH_SHORT).show()
                viewModel.updateQuestion(viewModel.currentQuestion.value ?: 0)
            }

        })

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
