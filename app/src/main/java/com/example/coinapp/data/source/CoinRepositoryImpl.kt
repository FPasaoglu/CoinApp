package com.example.coinapp.data.source

import com.example.coinapp.data.model.CoinIcon
import com.example.coinapp.data.model.ResponseState
import com.example.coinapp.data.source.remote.CoinRemoteDataSource
import com.example.coinapp.di.AppModule
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    @AppModule.RemoteDatasource private val remoteDataSource: CoinDataSource
) : CoinRepository {


    override suspend fun getCoinIcon(): Flow<ResponseState<List<CoinIcon>>> =
        flow {
            emit(ResponseState.Loading)
            emit(ResponseState.Success(remoteDataSource.getCoinIcons()))
        }.catch { error ->
            emit(ResponseState.Error(error.localizedMessage))
        }

}


