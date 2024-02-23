package com.wfprogramin.mvvmini.domain.model

import com.wfprogramin.mvvmini.data.database.entities.QuoteEntity
import com.wfprogramin.mvvmini.data.model.QuoteModel

data class Quote(val quote:String, val author:String)

fun QuoteModel.toDomain() = Quote(quote, author)

fun QuoteEntity.toDomain() = Quote(quote, author)