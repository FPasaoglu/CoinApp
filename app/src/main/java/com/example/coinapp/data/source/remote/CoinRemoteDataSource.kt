package com.example.coinapp.data.source.remote

import com.example.coinapp.data.model.CoinIcon
import com.example.coinapp.data.source.CoinDataSource
import javax.inject.Inject

class CoinRemoteDataSource @Inject constructor(
    private val service: CoinService
) : CoinDataSource {

    override fun getCoinIcons() : List<CoinIcon> = service.getCoinIcon()

}