package com.wfprogramin.mvvmini.core.di

import androidx.room.Room
import com.wfprogramin.mvvmini.data.database.QuoteDatabase

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    const val QUOTE_DATABASE_NAME = "quote_database"

    @Singleton
    @Provides
    fun provideRoom(@ApplicationContext context: Context) = Room.databaseBuilder(context, QuoteDatabase::class.java, QUOTE_DATABASE_NAME).build()


    @Singleton
    @Provides
    fun provideQuoteDao(db:QuoteDatabase) = db.getQuoteDao()
}