package com.example.gameofthronestrivia

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.gameofthronestrivia.data.Question

class GameViewModel : ViewModel() {

    private val _question = MutableLiveData<Question>()
    private val _currentQuestion = MutableLiveData<Int>()
    private val _score = MutableLiveData<Int>()
    private val _amountOfQuestions = MutableLiveData<Int>()
    private val _categoryQuestions = MutableLiveData<List<Question>>()

//    init {
//        _score.value = 0
//        _question.value = questions[0]
//        _currentQuestion.value = 0
//        _amountOfQuestions.value = questions.count()
//    }

    fun setUpGame(categoryId: Int){
        val newQuestions = questions.filter { q -> q.categoryId == categoryId }
        _categoryQuestions.postValue(newQuestions)
        _question.value = newQuestions[0]
        _currentQuestion.value = 0
        _score.value = 0
        // Setting amount of questions to the count of how many questions are in the category
        _amountOfQuestions.value = questions.filter { q -> q.categoryId == categoryId }.count()

    }

    val question: LiveData<Question> = _question
    val currentQuestion: LiveData<Int> = _currentQuestion
    val score: LiveData<Int> = _score
    val amountOfQuestions: LiveData<Int> = _amountOfQuestions

    fun updateQuestion(index: Int){
        _question.value = _categoryQuestions.value?.get(index.plus(1))
        _currentQuestion.value = index.plus(1)
    }

    fun checkQuestion(answer: Int){
        val validAnswer:String? = question.value?.correctAnswer
        val submitedAnswer: String? = question.value?.answers?.get(answer)
        if(submitedAnswer == validAnswer){
            _score.value = score.value?.plus(1)
        }
    }

    private val questions = listOf(
        Question("Our First Question",1, listOf("answer 1 ", "answer 2", "answer 3", "answer 4"), "answer 1 "),
        Question("Our Second Question",2, listOf("answer 1 ", "answer 2", "answer 3", "answer 4"), "answer 1 "),
        Question("Our Third Question",3, listOf("answer 1 ", "answer 2", "answer 3", "answer 4"), "answer 1 "),
        Question("Our Fourth Question",4, listOf("answer 1 ", "answer 2", "answer 3", "answer 4"), "answer 1 "),
        Question("Our Fifth Question",5, listOf("answer 1 ", "answer 2", "answer 3", "answer 4"), "answer 1 "),
        Question("Our Sixth Question",6, listOf("answer 1 ", "answer 2", "answer 3", "answer 4"), "answer 1 "),
        Question("Our Seventh Question",1, listOf("answer 1 ", "answer 2", "answer 3", "answer 4"), "answer 1 "),
        Question("Our Eighth Question",2, listOf("answer 1 ", "answer 2", "answer 3", "answer 4"), "answer 1 "),
        Question("Our Ninth Question",3, listOf("answer 1 ", "answer 2", "answer 3", "answer 4"), "answer 1 "),
        Question("Our Tenth Question",4, listOf("answer 1 ", "answer 2", "answer 3", "answer 4"), "answer 1 "),
        Question("Our 11 Question",5, listOf("answer 1 ", "answer 2", "answer 3", "answer 4"), "answer 1 "),
        Question("Our 12 Question",6, listOf("answer 1 ", "answer 2", "answer 3", "answer 4"), "answer 1 "),
        Question("Our 13 Question",1, listOf("answer 1 ", "answer 2", "answer 3", "answer 4"), "answer 1 "),
        Question("Our 14 Question",2, listOf("answer 1 ", "answer 2", "answer 3", "answer 4"), "answer 1 "),
        Question("Our 15 Question",3, listOf("answer 1 ", "answer 2", "answer 3", "answer 4"), "answer 1 "),
        Question("Our 16 Question",4, listOf("answer 1 ", "answer 2", "answer 3", "answer 4"), "answer 1 "),
        Question("Our 17 Question",5, listOf("answer 1 ", "answer 2", "answer 3", "answer 4"), "answer 1 "),
        Question("Our 18 Question",6, listOf("answer 1 ", "answer 2", "answer 3", "answer 4"), "answer 1 ")
    )

}