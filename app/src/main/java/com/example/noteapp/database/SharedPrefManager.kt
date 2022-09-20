package com.example.noteapp.database

import android.content.Context
import android.content.SharedPreferences

class SharedPrefManager(context: Context) {
    private val mySharedPref: SharedPreferences = context.getSharedPreferences("MyPref", Context.MODE_PRIVATE)

    fun saveManager(save: Boolean) {
        val editor = mySharedPref.edit()
        editor.putBoolean("save", save)
        editor.apply()
    }
    fun getManager(): Boolean {
        return mySharedPref.getBoolean("save", false)
    }
}