package com.example.spytify.Di

import com.example.spytify.Data.Repository.MainRepositoryImpl
import com.example.spytify.Domain.repository.MainRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun provideMainRepository(
        mainRepositoryImpl: MainRepositoryImpl
    ): MainRepository
}
