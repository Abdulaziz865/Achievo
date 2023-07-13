package pio.dellon.cabroli.ui.fragments.home

import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.google.android.material.snackbar.Snackbar
import pio.dellon.cabroli.R
import pio.dellon.cabroli.databinding.FragmentHomeBinding
import pio.dellon.cabroli.utils.Question
import pio.dellon.cabroli.utils.QuestionsAndAnswers

class HomeFragment : Fragment(R.layout.fragment_home), View.OnClickListener {

    private val binding by viewBinding(FragmentHomeBinding::bind)
    private lateinit var mQuestionsList: ArrayList<Question>

    private var mSelectedPosition: Int = 0
    private var mCorrectAnswer: Int = 0
    private var mCurrentPosition: Int = 1
    private var selectedAnswer = false

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
    }

    private fun initialize() {
        mQuestionsList = QuestionsAndAnswers.getQuestion()

        binding.btnAnswerA.setOnClickListener(this)
        binding.btnAnswerB.setOnClickListener(this)
        binding.btnAnswerC.setOnClickListener(this)
        binding.btnSubmit.setOnClickListener(this)

        setQuestion()
    }

    private fun setQuestion() {
        val question: Question = mQuestionsList[mCurrentPosition - 1]

        binding.txtQuestion.text = question.question
        binding.btnAnswerA.text = question.optionA
        binding.btnAnswerB.text = question.optionB
        binding.btnAnswerC.text = question.optionC

        binding.progressBar.progress = mCurrentPosition
        binding.txtProgress.text =
            "$mCurrentPosition" + "/" + binding.progressBar.max // displays question number
        selectedAnswer = false
        defaultAppearance()

        if (mCurrentPosition == mQuestionsList.size) {
            binding.btnSubmit.text = "Quiz Finished"
        } else {
            binding.btnSubmit.text = "Submit"
        }
    }

    private fun defaultAppearance() {

        val options = ArrayList<TextView>()
        options.add(0, binding.btnAnswerA)
        options.add(1, binding.btnAnswerB)
        options.add(2, binding.btnAnswerC)

        for (option in options) {
            option.setTextColor(Color.parseColor("#7A8089"))

            option.typeface = Typeface.DEFAULT
            option.background =
                context?.let { ContextCompat.getDrawable(it, R.drawable.default_option_border_bg) }
        }
    }

    override fun onClick(v: View?) {

        val animation: Animation = AnimationUtils.loadAnimation(context, R.anim.item_animation)

        when (v?.id) {
            R.id.btn_answer_a -> {
                selectedOptionView(binding.btnAnswerA, 1)
                binding.btnAnswerA.startAnimation(animation)
                selectedAnswer = true
            }

            R.id.btn_answer_b -> {
                selectedOptionView(binding.btnAnswerB, 2)
                binding.btnAnswerB.startAnimation(animation)
                selectedAnswer = true
            }

            R.id.btn_answer_c -> {
                selectedOptionView(binding.btnAnswerC, 3)
                binding.btnAnswerC.startAnimation(animation)
                selectedAnswer = true
            }

            R.id.btn_submit -> {
                if (selectedAnswer) {
                    if (mSelectedPosition == 0) {
                        mCurrentPosition++
                        binding.btnAnswerA.isClickable = true
                        binding.btnAnswerB.isClickable = true
                        binding.btnAnswerC.isClickable = true

                        when {
                            mCurrentPosition <= mQuestionsList.size -> {
                                setQuestion()
                            }
                            else -> {
                                findNavController().navigate(
                                    HomeFragmentDirections.actionHomeFragmentToScoreFragment(
                                        mCorrectAnswer
                                    )
                                )
                            }
                        }
                    } else {
                        binding.btnAnswerA.isClickable = false
                        binding.btnAnswerB.isClickable = false
                        binding.btnAnswerC.isClickable = false

                        val question = mQuestionsList[mCurrentPosition - 1]

                        if (question.correctAnswer != mSelectedPosition) {
                            answerView(mSelectedPosition, R.drawable.wrong_option_border_bg)
                        } else {
                            mCorrectAnswer++
                        }
                        answerView(question.correctAnswer, R.drawable.correct_option_border_bg)

                        if (mCurrentPosition == mQuestionsList.size) {

                            binding.btnSubmit.text = "Finished"
                        } else {
                            binding.btnSubmit.text = " Go to Next Question"
                        }
                        mSelectedPosition = 0
                    }
                    binding.btnSubmit.startAnimation(animation)
                } else {
                    Snackbar.make(binding.root, "Выберите вариант", Snackbar.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun selectedOptionView(tv: TextView, selectedPosition: Int) {
        defaultAppearance()
        mSelectedPosition = selectedPosition

        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background =
            context?.let { ContextCompat.getDrawable(it, R.drawable.selected_option_border_bg) }
    }

    private fun answerView(mSelectedPosition: Int, drawableView: Int) {

        when (mSelectedPosition) {

            1 -> {
                binding.btnAnswerA.background =
                    context?.let { ContextCompat.getDrawable(it, drawableView) }
            }

            2 -> {
                binding.btnAnswerB.background =
                    context?.let { ContextCompat.getDrawable(it, drawableView) }
            }

            3 -> {
                binding.btnAnswerC.background =
                    context?.let { ContextCompat.getDrawable(it, drawableView) }
            }
        }
    }
}