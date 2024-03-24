package com.thecodebasecase.io.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.thecodebasecase.io.model.House
import com.thecodebasecase.io.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
@HiltViewModel
class HouseDetailActivityViewModel @Inject constructor() : BaseViewModel() {

    private val _houseDetail = MutableLiveData<House>()
    val houseDetail: LiveData<House> = _houseDetail

    fun setHouseDetail(house: House) {
        _houseDetail.value = house
    }
}