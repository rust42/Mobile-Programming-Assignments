package edu.miu.cs473.quizapp.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.activity.viewModels
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import edu.miu.cs473.quizapp.QuestionReviewBuilder
import edu.miu.cs473.quizapp.R
import edu.miu.cs473.quizapp.data.AppDatabase
import edu.miu.cs473.quizapp.data.QuestionsRepository
import edu.miu.cs473.quizapp.databinding.ActivityQuizContainerBinding
import edu.miu.cs473.quizapp.viewmodel.QuestionViewModel

class QuestionContainerActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityQuizContainerBinding

    private val viewModel: QuestionViewModel by viewModels {
        QuestionViewModel.Factory(
            QuestionReviewBuilder(this),
             QuestionsRepository(
                AppDatabase.getInstance(this)
                )
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityQuizContainerBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        viewModel.currentQuestionOffsetText.observe(this) {
            binding.questionNumber.text = it
        }

        viewModel.statusText.observe(this) {
            binding.statusTextView.text = it
        }

        viewModel.quizFinished.observe(this) {
            if (it) {
                val allAnswers = viewModel.getAllAnswers()
                val intent = Intent(this, QuizReviewActivity::class.java)
                intent.putParcelableArrayListExtra(QuizReviewActivity.QuestionAnswersPairKey, allAnswers)
                startActivity(intent)
                finish()
            }
        }

        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment_content_main) as NavHostFragment



        val navController = navHostFragment.navController
        NavigationUI.setupActionBarWithNavController(this, navController)
    }


    override fun onSupportNavigateUp(): Boolean {
        return NavigationUI.navigateUp(Navigation.findNavController(this,
            R.id.nav_host_fragment_content_main
        ), null)
    }
}