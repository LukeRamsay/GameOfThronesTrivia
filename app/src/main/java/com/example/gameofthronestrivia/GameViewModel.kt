package com.example.gameofthronestrivia

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.gameofthronestrivia.data.Question

class GameViewModel : ViewModel() {

    private val questions = listOf<Question>(
        Question("Our First Question", listOf("answer 1 ", "answer 2", "answer 3", "answer 4"), "answer 1 "),
        Question("Our Second Question", listOf("answer 1 ", "answer 2", "answer 3", "answer 4"), "answer 1 "),
        Question("Our Third Question", listOf("answer 1 ", "answer 2", "answer 3", "answer 4"), "answer 1 "),
        Question("Our Fourth Question", listOf("answer 1 ", "answer 2", "answer 3", "answer 4"), "answer 1 "),
        Question("Our Fifth Question", listOf("answer 1 ", "answer 2", "answer 3", "answer 4"), "answer 1 "),
        Question("Our Sixth Question", listOf("answer 1 ", "answer 2", "answer 3", "answer 4"), "answer 1 ")
    )
    private val _question = MutableLiveData<Question>()
    private val _currentQuestion = MutableLiveData<Int>()
    private val _score = MutableLiveData<Int>()
    private val _amountOfQuestions = MutableLiveData<Int>()

    init {
        _score.value = 0
        _question.value = questions[0]
        _currentQuestion.value = 0
        _amountOfQuestions.value = questions.count()
    }

    val question: LiveData<Question> = _question
    val currentQuestion: LiveData<Int> = _currentQuestion
    val score: LiveData<Int> = _score
    val amountOfQuestions: LiveData<Int> = _amountOfQuestions

    fun updateQuestion(index: Int){
        _question.value = questions[index.plus(1)]
        _currentQuestion.value = index.plus(1)
    }

    fun checkQuestion(answer: Int){
        val validAnswer:String? = question.value?.correctAnswer
        val submitedAnswer: String? = question.value?.answers?.get(answer)
        if(submitedAnswer == validAnswer){
            _score.value = score.value?.plus(1)
        }
    }

}