package edu.miu.cs473.quizapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import edu.miu.cs473.quizapp.QuestionAnswerReviewListAdapter
import edu.miu.cs473.quizapp.databinding.FragmentReviewListBinding
import edu.miu.cs473.quizapp.viewmodel.QuizReviewViewModel

class ReviewListFragment : Fragment() {
    private var _binding: FragmentReviewListBinding? = null
    private val binding get() = _binding!!
    private val quizReviewViewModel: QuizReviewViewModel by activityViewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentReviewListBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val reviewList = binding.reviewList
        reviewList.addItemDecoration(
            DividerItemDecoration(
                activity,
                DividerItemDecoration.VERTICAL
            )
        )

        reviewList.setHasFixedSize(true)
        reviewList.layoutManager = LinearLayoutManager(activity)
        reviewList.itemAnimator = DefaultItemAnimator()

        quizReviewViewModel.questionAnswerReviews.observe(requireActivity()) {
            binding.reviewList.adapter =
                QuestionAnswerReviewListAdapter(requireActivity(), it)
        }
    }

}