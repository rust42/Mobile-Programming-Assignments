package edu.miu.cs473.quizapp.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Question(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "question_id")
    val questionId: Long,

    @ColumnInfo(name = "text")
    val text: String?)