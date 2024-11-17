package org.techtown.twosomeheart

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate

class TwosomeHeartApp : Application() {
    override fun onCreate() {
        super.onCreate()
        setLightMode()
    }

    private fun setLightMode() {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
    }
}
