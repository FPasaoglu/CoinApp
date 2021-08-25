package com.example.coinapp.data.source.remote

import com.example.coinapp.data.model.CoinIcon
import com.example.coinapp.data.model.ResponseState
import com.example.coinapp.util.Constants.API_KEY
import com.example.coinapp.util.Constants.COIN_ICON_SIZE
import kotlinx.coroutines.flow.Flow
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path

interface CoinService {

    @GET("/v1/assets/icons/{iconSize}")
    fun getCoinIcon(
        @Path("iconSize") iconSize: String = COIN_ICON_SIZE,
        @Header("X-CoinAPI-Key") apiKey: String = API_KEY
    ): List<CoinIcon>
}