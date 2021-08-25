package com.example.coinapp.data.source

import androidx.annotation.RequiresOptIn
import com.example.coinapp.data.model.CoinIcon
import com.example.coinapp.data.model.ResponseState
import kotlinx.coroutines.flow.Flow

interface CoinDataSource {
    fun getCoinIcons() : List<CoinIcon>
}