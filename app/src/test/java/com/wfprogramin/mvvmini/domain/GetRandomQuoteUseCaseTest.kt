package com.wfprogramin.mvvmini.domain

import com.wfprogramin.mvvmini.data.QuoteRepository
import com.wfprogramin.mvvmini.domain.model.Quote
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test


class GetRandomQuoteUseCaseTest{

    @RelaxedMockK
    private lateinit var quoteRepository: QuoteRepository

    lateinit var getRandomQuoteUseCase: GetRandomQuoteUseCase

    @Before
    fun onBefore(){
        MockKAnnotations.init(this)
        getRandomQuoteUseCase = GetRandomQuoteUseCase(quoteRepository)
    }


    @Test
    fun whenDatabaseIsEmptyThenReturnNull() = runBlocking{
        coEvery { quoteRepository.getAllQuotesFromDatabase() } returns emptyList()

        val response = getRandomQuoteUseCase()

        assert(response==null)

    }

    @Test
    fun whenDatabaseIsNoEmptyThenReturnQuote() = runBlocking{

        val quoteList = listOf(Quote(quote = "Holi", author = "WRojas"))
        coEvery { quoteRepository.getAllQuotesFromDatabase() } returns quoteList

        val response = getRandomQuoteUseCase()

        assert(response == quoteList.first())

    }
}