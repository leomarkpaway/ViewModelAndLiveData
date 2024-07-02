package com.leomarkpaway.viewmodelandlivedata

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStore

class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val counterText = findViewById<TextView>(R.id.tv_counter)
        val incrementButton = findViewById<Button>(R.id.btn_increment)
        val resetButton = findViewById<Button>(R.id.btn_reset)
        val decrementButton = findViewById<Button>(R.id.btn_decrement)

        incrementButton.setOnClickListener { viewModel.increment() }
        resetButton.setOnClickListener { viewModel.reset() }
        decrementButton.setOnClickListener { viewModel.decrement() }

        viewModel.counter.observe(this) { value ->
            counterText.text = value.toString()
            Log.d("qwe", "$value")
        }

    }
}