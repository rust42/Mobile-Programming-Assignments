package edu.miu.cs473.quizapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import edu.miu.cs473.quizapp.data.QuestionAnswersPair

class QuestionAnswerReviewListAdapter(private val context: Context, private val questionAnswerPair: List<QuestionAnswersPair>): RecyclerView.Adapter<QuestionAnswerReviewListAdapter.ViewHolder>() {

    data class ViewHolder(val view: View): RecyclerView.ViewHolder(view) {
        val question: TextView = view.findViewById(R.id.question)
        val answer1: TextView = view.findViewById(R.id.answer_1)
        val answer2: TextView = view.findViewById(R.id.answer_2)
        val answer3: TextView = view.findViewById(R.id.answer_3)
        val answer4: TextView = view.findViewById(R.id.answer_4)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(viewType, parent, false)
        return ViewHolder(view)
    }

    override fun getItemViewType(position: Int): Int {
        return R.layout.review_correct_item
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = questionAnswerPair[position]
        val question = item.questionAnswers.question.text
        val questionText = "${position+1}. $question"
        holder.question.text = questionText

        for ((index, textView) in arrayOf(holder.answer1, holder.answer2, holder.answer3, holder.answer4).withIndex()) {
            val answerAlphabet = when (index) {
                0 -> "A."
                1 -> "B."
                2 -> "C."
                3 -> "D."
                else -> ""
            }
            val answerItem = item.questionAnswers.answers[index]
            val providedAnswer = item.providedAnswer

            val answer = item.questionAnswers.answers[index].text
            val answerText = "$answerAlphabet $answer"
            textView.text = answerText

            if (providedAnswer == answerItem && !providedAnswer.isCorrect) {
                textView.background = ContextCompat.getDrawable(context, R.drawable.incorrect_item_outline)
            } else if (answerItem.isCorrect) {
                textView.background = ContextCompat.getDrawable(context, R.drawable.correct_item_outline)
            } else {
                textView.background = null
            }
        }
    }

    override fun getItemCount(): Int {
        return questionAnswerPair.size
    }
}