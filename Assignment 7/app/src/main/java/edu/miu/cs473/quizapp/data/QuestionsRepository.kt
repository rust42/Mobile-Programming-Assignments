package edu.miu.cs473.quizapp.data

import edu.miu.cs473.quizapp.data.AppDatabase
import edu.miu.cs473.quizapp.data.Question
import edu.miu.cs473.quizapp.data.QuestionAnswers

class QuestionsRepository(private val database: AppDatabase) {

    fun getAllQuestions(): List<Question> {
        return database.questionDao().getAll()
    }

    fun getQuestionCount(): Long {
        return database.questionDao().questionsCount()
    }

    fun questionAnswers(offset: Long): QuestionAnswers? {
        return database.questionDao().questionAndAnswers(offset)
    }
}