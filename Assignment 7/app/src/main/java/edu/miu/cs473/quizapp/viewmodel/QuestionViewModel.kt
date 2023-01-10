package edu.miu.cs473.quizapp.viewmodel

import android.text.SpannableString
import androidx.lifecycle.*
import androidx.lifecycle.viewmodel.CreationExtras
import edu.miu.cs473.quizapp.QuestionReviewBuilder
import edu.miu.cs473.quizapp.combineWith
import edu.miu.cs473.quizapp.data.QuestionAnswers
import edu.miu.cs473.quizapp.data.QuestionAnswersPair
import edu.miu.cs473.quizapp.data.QuestionsRepository


class QuestionViewModel(private val reviewBuilder: QuestionReviewBuilder, private val questionsRepository: QuestionsRepository): ViewModel() {

    enum class AnswerAlphabet {
        A, B, C, D;

        val index: Int get() = when (this) {
            A -> 0;
            B -> 1;
            C -> 2;
            D -> 3;
        }
    }

    private var _quizFinished: MutableLiveData<Boolean> = MutableLiveData(false)
    var quizFinished: LiveData<Boolean> = _quizFinished

    private var _currentQuestionOffset: MutableLiveData<Long> = MutableLiveData(0)

    private var _correctAnswers: MutableLiveData<List<QuestionAnswers>> = MutableLiveData(ArrayList())
    private var _incorrectAnswers: MutableLiveData<List<Pair<QuestionAnswers, AnswerAlphabet>>> = MutableLiveData(ArrayList())


    class Factory(private val reviewBuilder: QuestionReviewBuilder, private val repository: QuestionsRepository):
        ViewModelProvider.Factory {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>, extras: CreationExtras): T {
            return super.create(modelClass, extras)
        }

        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return QuestionViewModel(reviewBuilder, repository) as T
        }
    }

    private val questionsCount: Long =  questionsRepository.getQuestionCount()

    val currentQuestion: LiveData<QuestionAnswers?> = Transformations.map(_currentQuestionOffset) { offset ->
        questionsRepository.questionAnswers(offset)
    }

    val currentQuestionOffsetText: LiveData<String> = Transformations.map(_currentQuestionOffset) {
        return@map "Question ${it + 1} of $questionsCount"
    }

    val statusText: LiveData<SpannableString> = _correctAnswers.combineWith(_incorrectAnswers) { correct, incorrect ->
        return@combineWith reviewBuilder.build(correct?.size ?: 0, incorrect?.size ?: 0)
    }

    fun getAllAnswers(): ArrayList<QuestionAnswersPair> {
        val allQuestionAnswers: ArrayList<QuestionAnswersPair> = ArrayList()
        var correct = _correctAnswers.value
        var incorrect = _incorrectAnswers.value

        while (correct?.isNotEmpty() == true || incorrect?.isNotEmpty() == true) {
            if (incorrect?.isEmpty() == true) {
                val item = correct!!.first()
                correct = correct.drop(1)
                allQuestionAnswers.add(QuestionAnswersPair(item, item.answers.first { it.isCorrect }))
            } else if (correct?.isEmpty() == true) {
                val item = incorrect!!.first()
                incorrect = incorrect.drop(1)
                allQuestionAnswers.add(QuestionAnswersPair(item.first, item.first.answers[item.second.index]))

            } else {
                val item1 = correct!!.first()
                val item2 = incorrect!!.first()

                if (item1.question.questionId < item2.first.question.questionId) {
                    correct = correct.drop(1)
                    allQuestionAnswers.add(QuestionAnswersPair(item1, item1.answers.first { it.isCorrect }))
                } else {
                    incorrect = incorrect.drop(1)
                    allQuestionAnswers.add(QuestionAnswersPair(item2.first, item2.first.answers[item2.second.index]))
                }
            }
        }
        return allQuestionAnswers
    }

    fun switchToNext() {
        if ((_currentQuestionOffset.value ?: 0) >= questionsCount - 1) {
            _quizFinished.postValue(true)
        } else {
            _currentQuestionOffset.postValue(_currentQuestionOffset.value?.plus(1) ?: 0)
        }
    }

    fun submitAnswer(answer: AnswerAlphabet) {
        currentQuestion.value?.let {
            if (it.answers[answer.index].isCorrect) {
                _correctAnswers.postValue(_correctAnswers.value?.plus(it))
            } else {
                _incorrectAnswers.postValue(_incorrectAnswers.value?.plus(Pair(it, answer)))
            }
        }
    }
}