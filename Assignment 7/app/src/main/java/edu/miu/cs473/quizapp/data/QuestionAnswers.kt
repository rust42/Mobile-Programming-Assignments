package edu.miu.cs473.quizapp.data

import android.os.Build
import android.os.Parcel
import android.os.Parcelable
import androidx.annotation.RequiresApi
import androidx.room.Embedded
import androidx.room.Relation

data class QuestionAnswers(
    @Embedded val question: Question,
    @Relation(parentColumn = "question_id",
        entityColumn = "question_id")
    val answers: List<Answer>
): Parcelable {
    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    constructor(parcel: Parcel) : this(
        parcel.readParcelable(Question::class.java.classLoader, Question::class.java)!!,
        parcel.readArrayList(Answer::class.java.classLoader, Answer::class.java)!!
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeParcelable(question, Parcelable.PARCELABLE_WRITE_RETURN_VALUE)
        parcel.writeList(answers)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<QuestionAnswers> {
        @RequiresApi(Build.VERSION_CODES.TIRAMISU)
        override fun createFromParcel(parcel: Parcel): QuestionAnswers {
            return QuestionAnswers(parcel)
        }

        override fun newArray(size: Int): Array<QuestionAnswers?> {
            return arrayOfNulls(size)
        }
    }
}