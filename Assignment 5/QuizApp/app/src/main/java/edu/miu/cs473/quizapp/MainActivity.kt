package edu.miu.cs473.quizapp

import android.app.AlertDialog
import android.content.DialogInterface
import android.graphics.Typeface
import android.os.Bundle
import android.text.format.DateFormat
import android.view.Gravity
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import edu.miu.cs473.quizapp.databinding.ActivityMainBinding
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private lateinit var question1RadioGroup: RadioGroup
    private lateinit var submitButton: Button
    private lateinit var resetButton: Button

    private lateinit var answerCheckbox1: CheckBox
    private lateinit var answerCheckbox2: CheckBox
    private lateinit var answerCheckbox3: CheckBox


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        question1RadioGroup = findViewById(R.id.question_1_radio_group)

        submitButton = findViewById(R.id.submit_button)
        resetButton = findViewById(R.id.reset_button)

        submitButton.setOnClickListener(this::submitAnswers)
        resetButton.setOnClickListener { _ -> resetAllQuestions() }

        answerCheckbox1 = findViewById(R.id.question_2_answer_1_checkbox)
        answerCheckbox2 = findViewById(R.id.question_2_answer_2_checkbox)
        answerCheckbox3 = findViewById(R.id.question_2_answer_3_checkbox)

        answerCheckbox1.setOnCheckedChangeListener(this::checkboxChecked)
        answerCheckbox2.setOnCheckedChangeListener(this::checkboxChecked)
        answerCheckbox3.setOnCheckedChangeListener(this::checkboxChecked)
    }

    private fun submitAnswers(v: View) {
        val (isAnswer1Correct, isAnswer2Correct) = checkAnswers()
        var points: Int = if (isAnswer1Correct) 50 else 0
        points += if (isAnswer2Correct) 50 else 0

        val format = SimpleDateFormat.getDateTimeInstance()
        val formattedDate = format.format(Date())

        val textView = TextView(this)
        with(textView) {
            textView.text = if (points == 0)
                "Sorry! You failed answering the questions, good luck next time"
            else
             "Congratulations! You submitted on $formattedDate, You achieved $points%"
           textView.textSize = 20.0F
            textView.setTypeface(null, Typeface.BOLD)
            textView.gravity = Gravity.CENTER
        }
        AlertDialog.Builder(this)
            .setCustomTitle(textView)
            .setPositiveButton(R.string.ok,DialogInterface.OnClickListener { _, _ ->
                resetAllQuestions()
            })
            .create()
            .show()
    }

    private fun checkAnswers(): Pair<Boolean, Boolean>  {
        val isAnswer1Correct = when(question1RadioGroup.checkedRadioButtonId) {
            R.id.question_1_answer_1_radio_button -> false
            R.id.question_1_answer_2_radio_button -> true
            R.id.question_1_answer_3_radio_button -> false
            else -> false
        }

        val isAnswer2Correct = answerCheckbox1.isChecked

        return isAnswer1Correct to  isAnswer2Correct
    }

    private fun checkboxChecked(button: CompoundButton, isChecked: Boolean) {
        if (!isChecked) {
            return
        }
        when(button.id)  {
            R.id.question_2_answer_1_checkbox ->
                resetCheckboxes(
                    arrayOf(R.id.question_2_answer_2_checkbox,
                        R.id.question_2_answer_3_checkbox
                    ))
            R.id.question_2_answer_2_checkbox ->
                resetCheckboxes(
                    arrayOf(R.id.question_2_answer_1_checkbox,
                        R.id.question_2_answer_3_checkbox
                    ))

            R.id.question_2_answer_3_checkbox ->
                resetCheckboxes(
                    arrayOf(R.id.question_2_answer_1_checkbox,
                        R.id.question_2_answer_2_checkbox
                    ))
        }
    }

    private fun resetCheckboxes(ids: Array<Int>) {
        for (id in ids) {
            val checkbox = findViewById<CheckBox>(id)
            checkbox?.isChecked = false
        }
    }

    private fun resetAllQuestions() {
        question1RadioGroup.clearCheck()
        resetCheckboxes(arrayOf(
            R.id.question_2_answer_1_checkbox,
            R.id.question_2_answer_2_checkbox,
            R.id.question_2_answer_3_checkbox
        ))
    }

}