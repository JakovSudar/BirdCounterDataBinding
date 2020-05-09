package com.example.birdcounterdatabinding

import android.content.Context

class PreferenceManager {
    companion object {
        const val PREFS_FILE = "BirdCounterPref"
        const val PREFS_KEY_COUNTER = "Counter"
        const val PREFS_KEY_COLOR = "Color"
    }

    fun saveCounter(counter: Int) {
        val sharedPreferences = BirdCounterApp.ApplicationContext.getSharedPreferences(
            PREFS_FILE, Context.MODE_PRIVATE
        )
        val editor = sharedPreferences.edit()
        editor.putInt(PREFS_KEY_COUNTER, counter)
        editor.apply()
    }

    fun retriveCounter(): Int {
        val sharedPreferences = BirdCounterApp.ApplicationContext.getSharedPreferences(
            PREFS_FILE, Context.MODE_PRIVATE
        )
        return sharedPreferences.getInt(PREFS_KEY_COUNTER, 0)
    }

    fun incrementBirdCounter() {
        val current = retriveCounter()
        saveCounter(current + 1)
    }

    fun saveColor(color: String) {
        val sharedPreferences = BirdCounterApp.ApplicationContext.getSharedPreferences(
            PREFS_FILE, Context.MODE_PRIVATE
        )
        val editor = sharedPreferences.edit()
        editor.putString(PREFS_KEY_COLOR, color)
        editor.apply()
    }

    fun retriveColor(): String? {
        val sharedPreferences = BirdCounterApp.ApplicationContext.getSharedPreferences(
            PREFS_FILE, Context.MODE_PRIVATE
        )
        return sharedPreferences.getString(PREFS_KEY_COLOR, "#FFFFFF")
    }
}