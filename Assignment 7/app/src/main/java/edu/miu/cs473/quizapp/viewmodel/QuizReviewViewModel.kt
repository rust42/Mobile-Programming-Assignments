package edu.miu.cs473.quizapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import edu.miu.cs473.quizapp.data.QuestionAnswersPair

class QuizReviewViewModel: ViewModel() {
    private val _questionAnswerReviews = MutableLiveData<List<QuestionAnswersPair>>(arrayListOf())
    val questionAnswerReviews: LiveData<List<QuestionAnswersPair>> = _questionAnswerReviews

    fun setQuestionAnswersList(questionAnswerReviews: List<QuestionAnswersPair>) {
        _questionAnswerReviews.postValue(questionAnswerReviews)
    }
}