package com.wfprogramin.mvvmini.data

import com.wfprogramin.mvvmini.data.model.QuoteModel
import com.wfprogramin.mvvmini.data.model.QuoteProvider
import com.wfprogramin.mvvmini.data.network.QuoteService
import javax.inject.Inject

class QuoteRepository @Inject constructor(private val api: QuoteService, private val quoteProvider: QuoteProvider){

    suspend fun getAllQuotes(): List<QuoteModel>{
        val response = api.getQuotes()
        quoteProvider.quotes = response
        return response
    }
}