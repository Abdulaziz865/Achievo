package pio.dellon.cabroli.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import by.kirich1409.viewbindingdelegate.viewBinding
import pio.dellon.cabroli.R
import pio.dellon.cabroli.databinding.ActivityMainBinding
import pio.dellon.cabroli.utils.PreferenceHelper

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private lateinit var controllerNav: NavController
    private val binding by viewBinding(ActivityMainBinding::bind)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_Achievo)
        Thread.sleep(2000)
        setupNavigation()
    }

    private fun setupNavigation() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        controllerNav = navHostFragment.navController

        when (PreferenceHelper.isStartApp) {
            true -> {
                controllerNav.navigate(R.id.homeFragment)
                controllerNav.popBackStack()
            }
            else -> {
                controllerNav.navigate(R.id.onBoardFragment)
            }
        }
    }
}