package com.iie.st10320489.marene.ui.rewards

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class RewardsViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is rewards Fragment"
    }
    val text: LiveData<String> = _text
}