package com.example.lessonslist.ui.home

import android.os.CountDownTimer
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.text.SimpleDateFormat
import java.util.*

val EXAMINATION_TIME = SimpleDateFormat("yyyy-MM-dd HH:mm").parse("2021-08-01 09:00")

class HomeViewModel : ViewModel() {
    private val timer = object : CountDownTimer(EXAMINATION_TIME.time - Date().time, 1000) {

        override fun onTick(millisUntilFinished: Long) {
            val daysLeft = millisUntilFinished/1000/60/60/24
            _days_text.value = daysLeft.toString()
            val hoursLeft = (millisUntilFinished - daysLeft*1000*60*60*24)/1000/60/60
            _hours_text.value = hoursLeft.toString()
            val minutesLieft = (millisUntilFinished - daysLeft*1000*60*60*24 - hoursLeft*1000*60*60)/1000/60
            _minutes_text.value = minutesLieft.toString()
        }

        override fun onFinish() {}
    }.start()

    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    val text: LiveData<String> = _text


    private val _days_text = MutableLiveData<String>().apply {
        value = "00"
    }
    val days_text: LiveData<String> = _days_text

    
    private val _hours_text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    val hours_text: LiveData<String> = _hours_text


    private val _minutes_text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    val minutes_text: LiveData<String> = _minutes_text

}