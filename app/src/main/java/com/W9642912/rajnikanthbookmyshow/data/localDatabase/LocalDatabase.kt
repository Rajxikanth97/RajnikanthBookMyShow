package com.W9642912.rajnikanthbookmyshow.data.localDatabase

import android.content.Context
import android.content.SharedPreferences
import kotlinx.coroutines.runBlocking

class LocalDatabase(context:Context) {
    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences("database", Context.MODE_PRIVATE)

    var handle: Boolean
        get() = sharedPreferences.getBoolean("handle", false)
        set(handle) = runBlocking {
            val editor = sharedPreferences.edit()
            editor.putBoolean("handle", handle)
            editor.apply()
        }
}