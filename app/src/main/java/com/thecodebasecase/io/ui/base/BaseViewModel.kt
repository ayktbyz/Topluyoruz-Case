package com.thecodebasecase.io.ui.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

open class BaseViewModel : ViewModel() {
    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    private val _errorMessages = MutableLiveData<String>()
    val errorMessages: LiveData<String> = _errorMessages

    fun setLoading(isLoading: Boolean) {
        _isLoading.postValue(isLoading)
    }
    fun setErrorMessages(errorMessages: String) {
        _errorMessages.postValue(errorMessages)
    }
}
