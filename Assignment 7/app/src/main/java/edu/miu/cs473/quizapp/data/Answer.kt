package edu.miu.cs473.quizapp.data

import android.os.Parcel
import android.os.Parcelable
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
): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readLong(),
        parcel.readString() ?: "",
        parcel.readByte() != 0.toByte(),
        parcel.readValue(Long::class.java.classLoader) as? Long
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeLong(answerId)
        parcel.writeString(text)
        parcel.writeByte(if (isCorrect) 1 else 0)
        parcel.writeValue(questionId)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Answer> {
        override fun createFromParcel(parcel: Parcel): Answer {
            return Answer(parcel)
        }

        override fun newArray(size: Int): Array<Answer?> {
            return arrayOfNulls(size)
        }
    }
}


