package edu.miu.cs473.quizapp.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(foreignKeys = [
    ForeignKey(
        entity = Question::class,
        parentColumns = ["question_id"],
        childColumns = ["question_id"],
        onDelete = ForeignKey.CASCADE
    )
])
data class Answer(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "answer_id")
    val answerId: Long,
    val text: String,
    @ColumnInfo(name = "is_correct")
    val isCorrect: Boolean,
    @ColumnInfo(name = "question_id", index = true)
    var questionId: Long? = null
)


