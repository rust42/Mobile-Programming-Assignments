package edu.miu.cs473.quizapp.data

import android.os.Parcel
import android.os.Parcelable

data class QuestionAnswersPair(val questionAnswers: QuestionAnswers, val providedAnswer: Answer):
    Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readParcelable(QuestionAnswers::class.java.classLoader)!!,
        parcel.readParcelable(Answer::class.java.classLoader)!!
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
        override fun createFromParcel(parcel: Parcel): QuestionAnswersPair {
            return QuestionAnswersPair(parcel)
        }

        override fun newArray(size: Int): Array<QuestionAnswersPair?> {
            return arrayOfNulls(size)
        }
    }
}
