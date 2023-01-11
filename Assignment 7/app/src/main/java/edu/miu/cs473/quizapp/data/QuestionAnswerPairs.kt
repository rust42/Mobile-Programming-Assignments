package edu.miu.cs473.quizapp.data

import android.os.Build
import android.os.Parcel
import android.os.Parcelable
import androidx.annotation.RequiresApi

data class QuestionAnswersPair(val questionAnswers: QuestionAnswers, val providedAnswer: Answer):
    Parcelable {
    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    constructor(parcel: Parcel) : this(
        parcel.readParcelable(QuestionAnswers::class.java.classLoader, QuestionAnswers::class.java)!!,
        parcel.readParcelable(Answer::class.java.classLoader, Answer::class.java)!!
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeParcelable(questionAnswers, flags)
        parcel.writeParcelable(providedAnswer, flags)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<QuestionAnswersPair> {
        @RequiresApi(Build.VERSION_CODES.TIRAMISU)
        override fun createFromParcel(parcel: Parcel): QuestionAnswersPair {
            return QuestionAnswersPair(parcel)
        }

        override fun newArray(size: Int): Array<QuestionAnswersPair?> {
            return arrayOfNulls(size)
        }
    }
}
