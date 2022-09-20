package com.example.noteapp.util

import android.app.Activity
import com.google.android.material.snackbar.Snackbar
import java.sql.Timestamp
import java.text.SimpleDateFormat
import java.util.*

object Constants {
    const val DB_NAME = "Note.Db"
    const val DB_VERSION = 1

    const val TABLE_NAME = "Note_Table"
    const val ID = "id"
    const val TITLE = "title"
    const val DESCR = "description"
    const val TIME = "time"
}
object Time {
    fun timeStamp():String{
        val timeStamp = Timestamp(System.currentTimeMillis())
        val msh = SimpleDateFormat("EEE,d MMM yyyy HH:mm a", Locale.getDefault())
        val time = msh.format(Date(timeStamp.time))
        return time.toString()
    }
}

