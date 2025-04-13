package com.example.spytify.Di

import com.example.spytify.Data.Repository.SongRepositoryImpl
import com.example.spytify.Domain.repository.SongRepository
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
        songRepositoryImpl: SongRepositoryImpl
    ): SongRepository
}
