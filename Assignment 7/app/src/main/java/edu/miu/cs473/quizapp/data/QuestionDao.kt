package edu.miu.cs473.quizapp.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import edu.miu.cs473.quizapp.data.Answer
import edu.miu.cs473.quizapp.data.Question
import edu.miu.cs473.quizapp.data.QuestionAnswers

@Dao
interface QuestionDao {

    @Query("SELECT * FROM question")
    fun getAll(): List<Question>

    @Query("SELECT * FROM question where question.question_id = :questionId")
    fun findByQuestionId(questionId: Long): Question?

    @Insert
    fun insert(question: Question)

    @Insert
    fun insert(answer: Answer)

    fun insertAnswers(question: Question, vararg answers: Answer) {
        for (answer in answers) {
            answer.questionId = question.questionId
            insert(answer)
        }
    }

    @Query("SELECT COUNT(question_id) FROM question")
    fun questionsCount(): Long

    @Query("SELECT * from question LIMIT 1 OFFSET :offset")
    fun question(offset: Long): Question?

    @Query("SELECT * from question LIMIT 1 OFFSET :offset")
    @Transaction
    fun questionAndAnswers(offset: Long): QuestionAnswers?
}