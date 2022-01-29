package com.shahinbashar.riseupmaillbox.di

import com.shahinbashar.riseupmaillbox.utils.Const
import com.shahinbashar.test.remote.ApiInterface
import com.shahinbashar.test.remote.RetrofitClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideBaseUrl()=Const.BASE_URL

    @Provides
    @Singleton
    fun provideApiService() : ApiInterface {
        return RetrofitClient.client.create(ApiInterface::class.java)
    }
}