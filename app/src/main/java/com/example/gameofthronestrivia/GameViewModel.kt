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
        Question("How Many Starks who appeared in the season 1 episode 1:",1, listOf("2", "4", "10", "8"), "8", "5edc230d071953053d2d6bd124520e15.jpg"),
        Question("What is Eddard Stark's kinship to Jon Snow?",1, listOf("Uncle", "Father", "Step Father", "Bastard"), "Uncle", "Jon-Snow-with-Eddard-Stark-and-Theon-Greyjoy-house-stark-24505255-1280-720.jpg"),
        Question("What is the name of Arya Stark's sword?",1, listOf("Pointy", "Needle", "Lightsbane", "Widdows Wail"), "Needle", "AryawithNeedle.jpg"),
        Question("What noble house is Catelyn Stark from?",1, listOf("House Tyrell", "House Lannister", "House Tully", "House Stark"), "House Tully", "220px-Michelle_Fairley_Cat_Stark_in_the_Vale.png"),
        Question("Ilyn Payne beheads Ned Stark with which ancient sword?",1, listOf("Ice", "Fire", "Long Claw", "Needle"), "Ice", "5ced63e2594ea515330fe605.jfif"),
        Question("Where did Shae and Tyrion meet for the first time?",2, listOf("The Riverlands", "In a Brothel", "Kings Landing", "Castely Rock"), "The Riverlands", "Bear_maiden_fair_shae_Tyrion.jpg"),
        Question("What is the motto of House Lannister",2, listOf("A Lannister always pays his debts", "Fire and Blood", "Ours is the Fury", "Hear Me Roar"), "Hear Me Roar", "09124a79763453.5ccd3429d26f4.jpg"),
        Question("Who is Joffrey, Myrcella and Tommen's real father?",2, listOf("Lancel Lannister", "Jaime Lannister", "Tywin Lannister", "Robert Baratheon"), "Jaime Lannister", "55d72be51400002e002e391d.jpeg"),
        Question("Who is resposible for the poisoning of King Joffrey",2, listOf("Sansa Stark", "Tyrion Lannister", "Olenna Tyrell", "Margery Tyrell"), "answer 1 ", "joffrey-game-of-thrones-choking.jpg"),
        Question("Our 11 Question",3, listOf("answer 1 ", "answer 2", "answer 3", "answer 4"), "answer 1 ", "as_high_as_honor_by_noble__6_d89uhxq.jpg"),
        Question("Our 12 Question",3, listOf("answer 1 ", "answer 2", "answer 3", "answer 4"), "answer 1 ", "as_high_as_honor_by_noble__6_d89uhxq.jpg"),
        Question("Our 13 Question",3, listOf("answer 1 ", "answer 2", "answer 3", "answer 4"), "answer 1 ", "as_high_as_honor_by_noble__6_d89uhxq.jpg"),
        Question("Our 14 Question",3, listOf("answer 1 ", "answer 2", "answer 3", "answer 4"), "answer 1 ", "as_high_as_honor_by_noble__6_d89uhxq.jpg"),
        Question("Our 15 Question",3, listOf("answer 1 ", "answer 2", "answer 3", "answer 4"), "answer 1 ", "as_high_as_honor_by_noble__6_d89uhxq.jpg"),
        Question("Our 16 Question",4, listOf("answer 1 ", "answer 2", "answer 3", "answer 4"), "answer 1 ", "as_high_as_honor_by_noble__6_d89uhxq.jpg"),
        Question("Our 17 Question",4, listOf("answer 1 ", "answer 2", "answer 3", "answer 4"), "answer 1 ", "as_high_as_honor_by_noble__6_d89uhxq.jpg"),
        Question("Our 18 Question",4, listOf("answer 1 ", "answer 2", "answer 3", "answer 4"), "answer 1 ", "as_high_as_honor_by_noble__6_d89uhxq.jpg"),
        Question("Our First Question",4, listOf("answer 1 ", "answer 2", "answer 3", "answer 4"), "answer 1 ", "as_high_as_honor_by_noble__6_d89uhxq.jpg"),
        Question("Our Second Question",4, listOf("answer 1 ", "answer 2", "answer 3", "answer 4"), "answer 1 ", "as_high_as_honor_by_noble__6_d89uhxq.jpg"),
        Question("Our Third Question",5, listOf("answer 1 ", "answer 2", "answer 3", "answer 4"), "answer 1 ", "as_high_as_honor_by_noble__6_d89uhxq.jpg"),
        Question("Our Fourth Question",5, listOf("answer 1 ", "answer 2", "answer 3", "answer 4"), "answer 1 ", "as_high_as_honor_by_noble__6_d89uhxq.jpg"),
        Question("Our Fifth Question",5, listOf("answer 1 ", "answer 2", "answer 3", "answer 4"), "answer 1 ", "as_high_as_honor_by_noble__6_d89uhxq.jpg"),
        Question("Our Sixth Question",5, listOf("answer 1 ", "answer 2", "answer 3", "answer 4"), "answer 1 ", "as_high_as_honor_by_noble__6_d89uhxq.jpg"),
        Question("Our Seventh Question",5, listOf("answer 1 ", "answer 2", "answer 3", "answer 4"), "answer 1 ", "as_high_as_honor_by_noble__6_d89uhxq.jpg"),
        Question("Our Eighth Question",6, listOf("answer 1 ", "answer 2", "answer 3", "answer 4"), "answer 1 ", "as_high_as_honor_by_noble__6_d89uhxq.jpg"),
        Question("Our Ninth Question",6, listOf("answer 1 ", "answer 2", "answer 3", "answer 4"), "answer 1 ", "as_high_as_honor_by_noble__6_d89uhxq.jpg"),
        Question("Our Tenth Question",6, listOf("answer 1 ", "answer 2", "answer 3", "answer 4"), "answer 1 ", "as_high_as_honor_by_noble__6_d89uhxq.jpg"),
        Question("Our 11 Question",6, listOf("answer 1 ", "answer 2", "answer 3", "answer 4"), "answer 1 ", "as_high_as_honor_by_noble__6_d89uhxq.jpg"),
        Question("Our 12 Question",6, listOf("answer 1 ", "answer 2", "answer 3", "answer 4"), "answer 1 ", "as_high_as_honor_by_noble__6_d89uhxq.jpg"),
        Question("Our 13 Question",7, listOf("answer 1 ", "answer 2", "answer 3", "answer 4"), "answer 1 ", "as_high_as_honor_by_noble__6_d89uhxq.jpg"),
        Question("Our 14 Question",7, listOf("answer 1 ", "answer 2", "answer 3", "answer 4"), "answer 1 ", "as_high_as_honor_by_noble__6_d89uhxq.jpg"),
        Question("Our 15 Question",7, listOf("answer 1 ", "answer 2", "answer 3", "answer 4"), "answer 1 ", "as_high_as_honor_by_noble__6_d89uhxq.jpg"),
        Question("Our 16 Question",7, listOf("answer 1 ", "answer 2", "answer 3", "answer 4"), "answer 1 ", "as_high_as_honor_by_noble__6_d89uhxq.jpg"),
        Question("Our 17 Question",7, listOf("answer 1 ", "answer 2", "answer 3", "answer 4"), "answer 1 ", "as_high_as_honor_by_noble__6_d89uhxq.jpg"),
        Question("Our 18 Question",8, listOf("answer 1 ", "answer 2", "answer 3", "answer 4"), "answer 1 ", "as_high_as_honor_by_noble__6_d89uhxq.jpg"),
        Question("Our 18 Question",8, listOf("answer 1 ", "answer 2", "answer 3", "answer 4"), "answer 1 ", "as_high_as_honor_by_noble__6_d89uhxq.jpg"),
        Question("Our 18 Question",8, listOf("answer 1 ", "answer 2", "answer 3", "answer 4"), "answer 1 ", "as_high_as_honor_by_noble__6_d89uhxq.jpg"),
        Question("Our 18 Question",8, listOf("answer 1 ", "answer 2", "answer 3", "answer 4"), "answer 1 ", "as_high_as_honor_by_noble__6_d89uhxq.jpg"),
        Question("Our 18 Question",8, listOf("answer 1 ", "answer 2", "answer 3", "answer 4"), "answer 1 ", "as_high_as_honor_by_noble__6_d89uhxq.jpg")
    )
//    fun generateDummyList(size: Int): List<CategoryItem> {
//
//        val list = ArrayList<CategoryItem>()
//        for (i in 0 until size){
//            val item = CategoryItem(i,  "Category $i")
//            list += item
//        }
//        return list
//    }

    val categories = listOf(
        CategoryItem(1, "House Stark"),
        CategoryItem(2, "House Lannister"),
        CategoryItem(3, "House Baratheon"),
        CategoryItem(4, "House Greyjoy"),
        CategoryItem(5, "House Martell"),
        CategoryItem(6, "House Arryn"),
        CategoryItem(7, "House Tully"),
        CategoryItem(8, "House Tyrell")
    )

}