package com.wfprogramin.mvvmini.domain

import com.wfprogramin.mvvmini.data.QuoteRepository
import com.wfprogramin.mvvmini.data.model.QuoteModel
import com.wfprogramin.mvvmini.domain.model.Quote
import javax.inject.Inject

class GetRandomQuoteUseCase @Inject constructor(private val repository: QuoteRepository) {
  suspend  operator fun invoke():Quote?{
        val quotes = repository.getAllQuotesFromDatabase()
        if(quotes.isNotEmpty()){
            val randomNumber = (quotes.indices).random()
            return quotes[randomNumber]
        }
        return null
    }
}