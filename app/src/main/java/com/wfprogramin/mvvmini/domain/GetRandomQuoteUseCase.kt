package com.wfprogramin.mvvmini.domain

import com.wfprogramin.mvvmini.data.model.QuoteModel
import com.wfprogramin.mvvmini.data.model.QuoteProvider

class GetRandomQuoteUseCase {
    operator fun invoke():QuoteModel?{
        val quotes = QuoteProvider.quotes
        if(quotes.isNotEmpty()){
            val randomNumber = (quotes.indices).random()
            return quotes[randomNumber]
        }
        return null
    }
}