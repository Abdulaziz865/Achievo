package pio.dellon.cabroli.ui.fragments.score

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import pio.dellon.cabroli.R
import pio.dellon.cabroli.databinding.FragmentScoreBinding

class ScoreFragment : Fragment(R.layout.fragment_score) {

    private val binding by viewBinding(FragmentScoreBinding::bind)
    private val navArgs by navArgs<ScoreFragmentArgs>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
        setupListeners()
    }

    private fun initialize() {
        binding.txtCorrectAnswers.text = navArgs.score.toString().trim()
    }

    private fun setupListeners() {
        binding.btnPassAgain.setOnClickListener {
            findNavController().navigate(R.id.action_scoreFragment_to_homeFragment)
        }
    }
}