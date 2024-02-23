package com.wfprogramin.mvvmini.data.network

import com.wfprogramin.mvvmini.core.di.NetworkModule
import com.wfprogramin.mvvmini.data.model.QuoteModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import javax.inject.Inject

class QuoteService @Inject constructor(private val api:QuoteApiClient){

    suspend fun getQuotes(): List<QuoteModel>{
        return withContext(Dispatchers.IO){
            val response = api.getAllQuotes()
            response.body()?: emptyList()
        }
    }
}