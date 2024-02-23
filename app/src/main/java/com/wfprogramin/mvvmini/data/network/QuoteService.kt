package com.wfprogramin.mvvmini.data.network

import com.wfprogramin.mvvmini.core.RetrofitHelper
import com.wfprogramin.mvvmini.data.model.QuoteModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class QuoteService {

    private val retrofit = RetrofitHelper.getRetrofit()

    suspend fun getQuotes(): List<QuoteModel>{
        return withContext(Dispatchers.IO){
            val response = retrofit.create(QuoteApiClient::class.java).getAllQuotes()
            response.body()?: emptyList()
        }
    }
}