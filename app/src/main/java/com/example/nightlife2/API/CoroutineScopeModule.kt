package com.example.nightlife2.API

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import javax.inject.Qualifier
import javax.inject.Singleton

@Retention(AnnotationRetention.RUNTIME)
@Qualifier
annotation class ApplicationCoroutineScope

@Retention(AnnotationRetention.RUNTIME)
@Qualifier
annotation class ApplicationIoScope


@InstallIn(SingletonComponent::class)
@Module
object CoroutinesScopesModule {

    @Singleton
    @ApplicationCoroutineScope
    @Provides
    fun provideApplicationCoroutineScope(
        @MainDispatcher dispatcher: CoroutineDispatcher
    ): CoroutineScope = CoroutineScope(SupervisorJob() + dispatcher)

    @Singleton
    @ApplicationIoScope
    @Provides
    fun provideApplicationIoScope(
        @IoDispatcher dispatcher: CoroutineDispatcher
    ): CoroutineScope = CoroutineScope(SupervisorJob() + dispatcher)

}