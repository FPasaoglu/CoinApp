package com.example.coinapp.di

import com.example.coinapp.data.source.CoinDataSource
import com.example.coinapp.data.source.CoinRepository
import com.example.coinapp.data.source.CoinRepositoryImpl
import com.example.coinapp.data.source.remote.CoinRemoteDataSource
import com.example.coinapp.data.source.remote.CoinService
import com.example.coinapp.util.Constants.BASE_URL
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Qualifier
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Qualifier
    @Retention(AnnotationRetention.BINARY)
    annotation class RemoteDatasource

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun provideRetrofitService(retrofit: Retrofit): CoinService {
        return retrofit.create(CoinService::class.java)
    }

    @Singleton
    @Provides
    @RemoteDatasource
    fun provideRemoteDataSource(service: CoinService) : CoinDataSource = CoinRemoteDataSource(service)


}

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun provideRepository(repositoryImpl: CoinRepositoryImpl) : CoinRepository

}