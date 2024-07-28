package com.app.rajnikanthbookmyshow.ui.appUtils

import android.content.Context
import android.widget.Toast
import java.util.regex.Pattern

object AppUtils {

    fun nullDataCheck(text: String): Boolean {
        return (text.trim() == "" || text.trim() == null || text.trim() == "null" || text.trim()
            .isEmpty())
    }
    fun showMessageClick(message:String,context: Context) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }
    fun emilValidationCheck(email: String): Boolean {
        val emailPattern = ("^(([\\w-]+\\.)+[\\w-]+|([a-zA-Z]{1}|[\\w-]{2,}))@"
                + "((([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                + "[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\."
                + "([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                + "[0-9]{1,2}|25[0-5]|2[0-4][0-9])){1}|"
                + "([a-zA-Z]+[\\w-]+\\.)+[a-zA-Z]{2,4})$")
        val pattern = Pattern.compile(emailPattern)
        val matcher = pattern.matcher(email)

        return matcher.matches()
    }

}