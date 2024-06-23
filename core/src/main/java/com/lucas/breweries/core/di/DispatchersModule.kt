package com.lucas.breweries.core.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Qualifier

@InstallIn(SingletonComponent::class)
@Module
object DispatchersModule {

    @Provides
    @DefaultDispatcher
    fun provideDefaultDispatcher(): CoroutineDispatcher {
        return Dispatchers.Default
    }

    @Provides
    @IoDispatcher
    fun provideIoDispatcher(): CoroutineDispatcher {
        return Dispatchers.IO
    }

    @Provides
    @MainDispatcher
    fun provideMainDispatcher(): CoroutineDispatcher {
        return Dispatchers.Main
    }
}

@Retention(AnnotationRetention.BINARY)
@Qualifier
annotation class DefaultDispatcher

@Retention(AnnotationRetention.BINARY)
@Qualifier
annotation class IoDispatcher

@Retention(AnnotationRetention.BINARY)
@Qualifier
annotation class MainDispatcher