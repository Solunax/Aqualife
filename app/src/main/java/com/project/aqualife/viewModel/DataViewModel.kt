package com.project.aqualife.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DataViewModel @Inject constructor(): ViewModel() {
    private val _recentIndex = MutableLiveData<Int>()
    val recentIndex get() = _recentIndex

    fun updateIndexValue(value : Int){
        recentIndex.postValue(value)
    }
}