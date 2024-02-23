package com.wfprogramin.mvvmini.data

import com.wfprogramin.mvvmini.data.database.dao.QuoteDao
import com.wfprogramin.mvvmini.data.database.entities.QuoteEntity
import com.wfprogramin.mvvmini.data.model.QuoteModel
import com.wfprogramin.mvvmini.data.network.QuoteService
import com.wfprogramin.mvvmini.domain.model.Quote
import com.wfprogramin.mvvmini.domain.model.toDomain
import javax.inject.Inject

class QuoteRepository @Inject constructor(private val api: QuoteService, private val quoteDao: QuoteDao ){

    suspend fun getAllQuotesFromApi(): List<Quote>{
        val response: List<QuoteModel> = api.getQuotes()
        return response.map {
            it.toDomain()
        }
    }

    suspend fun getAllQuotesFromDatabase(): List<Quote>{
        val response = quoteDao.getAllQuotes()
        return response.map { it.toDomain() }
    }

    suspend fun insertQuotes(quotes:List<QuoteEntity>){
        quoteDao.insertAll(quotes)
    }

    suspend fun clearQuotes(){
        quoteDao.deleteAllQuotes()
    }
}
