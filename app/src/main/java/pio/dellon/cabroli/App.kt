package pio.dellon.cabroli

import android.app.Application
import pio.dellon.cabroli.utils.PreferenceHelper

class App: Application(){

    override fun onCreate() {
        super.onCreate()
        PreferenceHelper.units(this)
    }
}