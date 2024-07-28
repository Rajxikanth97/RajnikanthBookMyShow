package com.app.rajnikanthbookmyshow.ui.applicationData

import android.app.Application
import com.app.rajnikanthbookmyshow.ui.contents.dataModel.BookingModel

class ApplicatonData : Application() {
    companion object {
        var bookingList = ArrayList<BookingModel>()
    }
    override fun onCreate() {
        super.onCreate()

    }


}