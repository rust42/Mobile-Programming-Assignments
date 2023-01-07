package edu.miu.cs473.quizapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import edu.miu.cs473.quizapp.entity.QuestionAnswers

class QuestionViewModel(private val questionsRepository: QuestionsRepository): ViewModel() {

    enum class Answer {
        A, B, C, D;

        val index: Int get() = when (this) {
            A -> 0;
            B -> 1;
            C -> 2;
            D -> 3;
        }
    }

    private var _currentQuestionOffset: MutableLiveData<Long> = MutableLiveData(0)
    var currentQuestionOffset: LiveData<Long> = _currentQuestionOffset

    private var _correctAnswers: MutableLiveData<List<QuestionAnswers>> = MutableLiveData(ArrayList())
    private var _incorrectAnswers: MutableLiveData<List<QuestionAnswers>> = MutableLiveData(ArrayList())


    class Factory(private var repository: QuestionsRepository):
        ViewModelProvider.Factory {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return QuestionViewModel(repository) as T
        }
    }

    val questionsCount: Long =  questionsRepository.getQuestionCount()

    val currentQuestion: LiveData<QuestionAnswers?> = Transformations.map(currentQuestionOffset) { offset ->
        questionsRepository.questionAnswers(offset)
    }

    val currentQuestionOffsetText: LiveData<String> = Transformations.map(currentQuestionOffset) {
        return@map "Question ${it + 1} of $questionsCount"
    }

    val statusText: LiveData<String> = _correctAnswers.combineWith(_incorrectAnswers) { correct, incorrect -> String
        if (correct == null && incorrect == null) {
            return@combineWith ""
        }
        if (correct == null && incorrect != null) {
            return@combineWith "${incorrect.size} wrong"
        }

        if (incorrect == null && correct != null) {
            return@combineWith "${correct.size} right"
        }

        val correctText = if (correct?.isEmpty() == true) "" else "${correct?.size} right"
        val incorrectText = if (incorrect?.isEmpty() == true) "" else "${incorrect?.size} wrong"

        val concatOperator = if (correctText.isNotEmpty() && incorrectText.isNotEmpty()) ", " else ""

        return@combineWith "$correctText$concatOperator$incorrectText"
    }



    fun switchToNext() {
        _currentQuestionOffset.postValue(currentQuestionOffset.value?.plus(1) ?: 0)
    }

    fun submitAnswer(answer: Answer) {
        currentQuestion.value?.let {
            if (it.answers[answer.index].isCorrect) {
                _correctAnswers.postValue(_correctAnswers.value?.plus(it))
            } else {
                _incorrectAnswers.postValue(_incorrectAnswers.value?.plus(it))
            }
        }
    }
}