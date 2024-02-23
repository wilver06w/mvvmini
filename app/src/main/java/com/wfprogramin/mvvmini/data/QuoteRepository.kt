package com.wfprogramin.mvvmini.data

import com.wfprogramin.mvvmini.data.model.QuoteModel
import com.wfprogramin.mvvmini.data.model.QuoteProvider
import com.wfprogramin.mvvmini.data.network.QuoteService

class QuoteRepository {

    private val api = QuoteService()

    suspend fun getAllQuotes(): List<QuoteModel>{
        val response = api.getQuotes()
        QuoteProvider.quotes = response
        return response
    }
}