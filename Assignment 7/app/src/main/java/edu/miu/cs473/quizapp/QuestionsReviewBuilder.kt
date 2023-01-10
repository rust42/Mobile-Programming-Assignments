package edu.miu.cs473.quizapp

import android.content.Context
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import androidx.core.content.ContextCompat

class QuestionReviewBuilder(private val context: Context) {

    fun build(correct: Int, incorrect: Int): SpannableString {
        if (correct == 0 && incorrect == 0) {
            return SpannableString("")
        }
        if (correct == 0 && incorrect > 0) {
            val spannable = SpannableString("$incorrect wrong")
            spannable.setSpan(ForegroundColorSpan(ContextCompat.getColor(context, R.color.text_wrong)), 0, spannable.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
            return spannable
        }

        if (incorrect == 0 && correct > 0) {
            val spannable = SpannableString("$correct right")
            spannable.setSpan(ForegroundColorSpan(ContextCompat.getColor(context,R.color.text_right)), 0, spannable.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
            return spannable
        }

        val correctText =  "$correct right"
        val incorrectText =  "$incorrect wrong"
        val concatOperator = ", "

        val greenColorText =  "$correctText$concatOperator"

        val spannable = SpannableString("$greenColorText$incorrectText")
        spannable.setSpan(ForegroundColorSpan(ContextCompat.getColor(context,R.color.text_right)), 0, greenColorText.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        spannable.setSpan(ForegroundColorSpan(ContextCompat.getColor(context,R.color.text_wrong)), greenColorText.length, spannable.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)

        return spannable
    }
}