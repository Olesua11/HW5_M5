package com.example.hw5_m5

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class LoveViewModel @Inject constructor(private val repository: Repository) : ViewModel() {
    fun getLiveLoveData(firstName: String, secondName: String): LiveData<LoveModel> {
        return repository.getData(firstName, secondName)
    }
}