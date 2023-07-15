package pio.dellon.cabroli.ui.fragments.onboard

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import pio.dellon.cabroli.R
import pio.dellon.cabroli.databinding.FragmentOnBoardBinding
import pio.dellon.cabroli.utils.PreferenceHelper

class OnBoardFragment : Fragment(R.layout.fragment_on_board) {

    private val binding by viewBinding(FragmentOnBoardBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
        setupListeners()
        checkPreference()
    }

    private fun initialize() {

    }

    private fun setupListeners() {
        binding.btnStart.setOnClickListener {
            PreferenceHelper.isStartApp = true
            findNavController().navigate(R.id.action_onBoardFragment_to_homeFragment    )
        }
    }

    private fun checkPreference() {
        if (PreferenceHelper.isStartApp) {
            findNavController().navigate(R.id.homeFragment)
        }
    }
}