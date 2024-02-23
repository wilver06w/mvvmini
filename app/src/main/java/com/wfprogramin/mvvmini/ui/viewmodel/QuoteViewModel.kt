package com.wfprogramin.mvvmini.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.wfprogramin.mvvmini.data.model.QuoteModel
import androidx.lifecycle.viewModelScope
import com.wfprogramin.mvvmini.domain.GetQuotesUseCase
import com.wfprogramin.mvvmini.domain.GetRandomQuoteUseCase


import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class QuoteViewModel @Inject constructor(
    private val getQuotesUseCase : GetQuotesUseCase,
    private val getRandomQuoteUseCase : GetRandomQuoteUseCase,
) : ViewModel() {

    val quoteModel = MutableLiveData<QuoteModel>()
    val isLoading = MutableLiveData<Boolean>()

    fun onCreate(){
        viewModelScope.launch{
            isLoading.postValue(true)
            val result = getQuotesUseCase()

            if(result.isNotEmpty()){
                quoteModel.postValue(result[0])
                isLoading.postValue(false)
            }
        }
    }

    fun randomQuote(){
        isLoading.postValue(true)
        val quote = getRandomQuoteUseCase()

        if(quote!=null){
            quoteModel.postValue(quote ?: quote)
        }
        isLoading.postValue(false)
    }
}