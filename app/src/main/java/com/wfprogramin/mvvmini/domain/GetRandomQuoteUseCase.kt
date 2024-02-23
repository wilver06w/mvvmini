package com.wfprogramin.mvvmini.domain

import com.wfprogramin.mvvmini.data.model.QuoteModel
import com.wfprogramin.mvvmini.data.model.QuoteProvider
import javax.inject.Inject

class GetRandomQuoteUseCase @Inject constructor(private val quoteProvider: QuoteProvider) {
    operator fun invoke():QuoteModel?{
        val quotes = quoteProvider.quotes
        if(quotes.isNotEmpty()){
            val randomNumber = (quotes.indices).random()
            return quotes[randomNumber]
        }
        return null
    }
}