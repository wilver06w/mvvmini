package com.wfprogramin.mvvmini.domain

import com.wfprogramin.mvvmini.data.QuoteRepository
import com.wfprogramin.mvvmini.domain.model.Quote
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.MockK
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test


class GetQuotesUseCaseTest{

    @RelaxedMockK
    private lateinit var qouteRepository: QuoteRepository

    lateinit var getQuotesUseCase: GetQuotesUseCase

    @Before
    fun onBefore(){
        MockKAnnotations.init(this)
        getQuotesUseCase = GetQuotesUseCase(qouteRepository)
    }

    @Test
    fun whenTheApiDoesntReturnAnythingThenGetValuesFromDatabase() = runBlocking {
        //Given
        coEvery { qouteRepository.getAllQuotesFromApi()} returns emptyList()
        //When
        getQuotesUseCase()
        //Then
        coVerify(exactly = 1) {  qouteRepository.getAllQuotesFromDatabase()}
        }



    @Test
    fun whenTheApiReturnSomethingThenGetValuesFromApi() = runBlocking {
        //Given

        val myList = listOf(Quote(quote = "Prueba", author = "wilver rojas"))
        coEvery { qouteRepository.getAllQuotesFromApi()} returns myList
        //When
        val response = getQuotesUseCase()

        //Then
        coVerify {  qouteRepository.clearQuotes()}
        coVerify {  qouteRepository.insertQuotes(any())}

        assert(myList == response)
    }
}