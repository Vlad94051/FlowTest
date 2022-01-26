package com.example.flowtest.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import androidx.core.widget.addTextChangedListener
import com.example.flowtest.R
import com.example.flowtest.domain.getAddNewsUseCase
import com.example.flowtest.domain.getNewsUseCase

class MainActivity : AppCompatActivity() {

    private val viewModel = MainViewModel(
        getNewsUseCase = getNewsUseCase(),
        addNewsUseCase = getAddNewsUseCase()
    )

    private val mainTextView: TextView by lazy { findViewById(R.id.mainTextView) }
    private val editText: EditText by lazy { findViewById(R.id.editText) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()
        viewModel.news.observe(this) { news ->
            mainTextView.text = news.toString()
        }

        editText.addTextChangedListener { text ->
            if (text.toString().length == 6) {
                viewModel.addNews(text.toString())
            }
        }

    }
}