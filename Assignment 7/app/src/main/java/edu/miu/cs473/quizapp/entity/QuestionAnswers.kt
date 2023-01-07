package edu.miu.cs473.quizapp.entity

import androidx.room.Embedded
import androidx.room.Relation

data class QuestionAnswers(
    @Embedded val question: Question,
    @Relation(parentColumn = "question_id",
        entityColumn = "question_id")
    val answers: List<Answer>
)