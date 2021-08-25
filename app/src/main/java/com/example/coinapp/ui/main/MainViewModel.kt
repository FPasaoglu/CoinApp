package com.example.coinapp.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coinapp.data.model.ResponseState
import com.example.coinapp.data.source.CoinRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: CoinRepository
) : ViewModel() {


    fun getCoinIcon() {
        viewModelScope.launch {
            repository.getCoinIcon().collect {
                when(it) {
                    is ResponseState.Success -> {
                        println(it.data)
                    }
                }
            }
        }
    }
}