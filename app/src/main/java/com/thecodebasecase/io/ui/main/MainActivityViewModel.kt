package com.thecodebasecase.io.ui.main

import androidx.lifecycle.liveData
import com.thecodebasecase.io.common.Resource
import com.thecodebasecase.io.repository.HouseRepository
import com.thecodebasecase.io.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(private val repository: HouseRepository) : BaseViewModel() {

    val houses = liveData(Dispatchers.IO) {
        setLoading(true)

        val response = repository.getHouseList()

        if (response is Resource.Error) {
            response.message?.let { setErrorMessages(it) }
        }

        emit(response)

        setLoading(false)
    }
}

