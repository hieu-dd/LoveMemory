package com.d2b.dev.lovememory.di

import com.d2b.dev.lovememory.data.remote.firebase.FireBaseManager
import com.d2b.dev.lovememory.data.repository.LoginRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object Module {


    @Singleton
    @Provides
    fun provideFireBaseManager() = FireBaseManager()


    @Singleton
    @Provides
    fun provideLoginRepository() = LoginRepository(FireBaseManager())
}