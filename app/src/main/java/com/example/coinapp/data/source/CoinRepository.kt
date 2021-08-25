package com.example.coinapp.data.source

import com.example.coinapp.data.model.CoinIcon
import com.example.coinapp.data.model.ResponseState
import kotlinx.coroutines.flow.Flow

interface CoinRepository {

    suspend fun getCoinIcon(): Flow<ResponseState<List<CoinIcon>>>

}