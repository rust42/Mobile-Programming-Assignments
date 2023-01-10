package edu.miu.cs473.quizapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import edu.miu.cs473.quizapp.QuestionReviewBuilder
import edu.miu.cs473.quizapp.R
import edu.miu.cs473.quizapp.databinding.FragmentQuestionBinding
import edu.miu.cs473.quizapp.viewmodel.QuestionViewModel.AnswerAlphabet
import edu.miu.cs473.quizapp.data.AppDatabase
import edu.miu.cs473.quizapp.data.QuestionsRepository
import edu.miu.cs473.quizapp.viewmodel.QuestionViewModel
import java.lang.IllegalStateException

class QuestionFragment : Fragment() {
    private var _binding: FragmentQuestionBinding? = null
    private val binding get() = _binding!!

    private val viewModel: QuestionViewModel by activityViewModels() {
        QuestionViewModel.Factory(
            QuestionReviewBuilder(requireActivity().applicationContext),
            QuestionsRepository(
                AppDatabase.getInstance(requireActivity().applicationContext)
            )
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentQuestionBinding.inflate(inflater, container, false)
        viewModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.submitButton.isEnabled = false

        binding.questionsRadioGroup.setOnCheckedChangeListener { _, checkedId ->
            binding.submitButton.isEnabled = checkedId != -1
        }

        viewModel.currentQuestion.observe(this.viewLifecycleOwner) { question ->
            question?.let {
                binding.questionText.text = it.question.text
                binding.answer1.text = it.answers[0].text
                binding.answer2.text = it.answers[1].text
                binding.answer3.text = it.answers[2].text
                binding.answer4.text = it.answers[3].text
            }
        }
        binding.submitButton.setOnClickListener {
            val answer = when (binding.questionsRadioGroup.checkedRadioButtonId) {
                binding.answer1.id -> AnswerAlphabet.A
                binding.answer2.id -> AnswerAlphabet.B
                binding.answer3.id -> AnswerAlphabet.C
                binding.answer4.id -> AnswerAlphabet.D
                else -> throw IllegalStateException("Invalid radio button selected")
            }
            viewModel.submitAnswer(answer)
            viewModel.switchToNext()
            val navController = Navigation.findNavController(view)
            navController.navigate(R.id.action_QuestionFragment_to_QuestionFragment)
        }
    }
}