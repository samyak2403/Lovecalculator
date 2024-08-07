package com.samyak2403.lovecalculator.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.samyak2403.lovecalculator.R

import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}