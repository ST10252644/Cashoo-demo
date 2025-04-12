package com.iie.st10320489.marene.ui.analysis

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AnalysisViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is Analysis Fragment"
    }
    val text: LiveData<String> = _text
}