package com.wfprogramin.mvvmini.ui.view

import android.os.Bundle
import androidx.activity.viewModels
import com.wfprogramin.mvvmini.databinding.ActivityMainBinding
import com.wfprogramin.mvvmini.ui.viewmodel.QuoteViewModel
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val quoteViewModel: QuoteViewModel by viewModels()


  override fun onCreate(savedInstanceState: Bundle?) {
      super.onCreate(savedInstanceState)
      binding = ActivityMainBinding.inflate(layoutInflater)
      setContentView(binding.root)

        quoteViewModel.onCreate()

        quoteViewModel.quoteModel.observe(this) {
            binding.tvQuote.text = it.quote
            binding.tvAuthor.text = it.author
        }

      quoteViewModel.isLoading.observe(this) {
          binding.loading.isVisible = it
      }

      binding.viewContainer.setOnClickListener{quoteViewModel.randomQuote()}
    }
}