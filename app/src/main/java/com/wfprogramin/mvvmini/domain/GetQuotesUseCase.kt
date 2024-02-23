package com.wfprogramin.mvvmini.domain

import com.wfprogramin.mvvmini.data.QuoteRepository
import javax.inject.Inject

class GetQuotesUseCase @Inject constructor(private val repository: QuoteRepository) {

    suspend operator fun invoke() = repository.getAllQuotes()
}