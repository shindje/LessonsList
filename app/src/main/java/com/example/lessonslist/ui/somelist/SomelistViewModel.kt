package com.example.lessonslist.ui.somelist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SomelistViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is some list Fragment"
    }
    val text: LiveData<String> = _text
}