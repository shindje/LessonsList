package com.example.lessonslist.ui.fav

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class FavViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is Favourites Fragment"
    }
    val text: LiveData<String> = _text
}