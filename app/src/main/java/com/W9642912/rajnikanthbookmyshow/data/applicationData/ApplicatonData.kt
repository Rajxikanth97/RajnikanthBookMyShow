package com.W9642912.rajnikanthbookmyshow.data.applicationData

import android.app.Application
import com.W9642912.rajnikanthbookmyshow.data.contents.dataModel.BookingModel
import com.google.firebase.FirebaseApp

class ApplicatonData : Application() {
    companion object {
        var bookingList = ArrayList<BookingModel>()
    }
    override fun onCreate() {
        super.onCreate()
        FirebaseApp.initializeApp(this)
    }
}