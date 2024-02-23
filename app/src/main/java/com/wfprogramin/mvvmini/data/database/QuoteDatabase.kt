package com.wfprogramin.mvvmini.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.wfprogramin.mvvmini.data.database.dao.QuoteDao
import com.wfprogramin.mvvmini.data.database.entities.QuoteEntity

@Database(entities = [QuoteEntity::class], version = 1)
abstract class QuoteDatabase : RoomDatabase(){

    abstract fun getQuoteDao():QuoteDao
}