package edu.miu.cs473.quizapp.ui

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.ui.AppBarConfiguration
import edu.miu.cs473.quizapp.R
import edu.miu.cs473.quizapp.databinding.ActivityQuizReviewBinding
import edu.miu.cs473.quizapp.data.QuestionAnswersPair
import edu.miu.cs473.quizapp.viewmodel.QuizReviewViewModel


class QuizReviewActivity : AppCompatActivity() {

    companion object {
        const val QuestionAnswersPairKey = "QuestionAnswersPair"
    }
    private val quizReviewViewModel: QuizReviewViewModel by viewModels()

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityQuizReviewBinding

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityQuizReviewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        val questionAnswersPair: java.util.ArrayList<QuestionAnswersPair>? = intent.getParcelableArrayListExtra(
            QuestionAnswersPairKey, QuestionAnswersPair::class.java)
        quizReviewViewModel.setQuestionAnswersList(questionAnswersPair!!)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.review_try_again, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.start_again_button) {
            val intent = Intent(this, OnboardingActivity::class.java)
            startActivity(intent)
            finish()
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onSupportNavigateUp(): Boolean {
        return super.onSupportNavigateUp()
    }
}