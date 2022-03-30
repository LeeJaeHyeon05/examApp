package com.example.examapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.examapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var mBinding : ActivityMainBinding? = null
    private val binding get() = mBinding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



    }
    private fun popUpButton() {
        binding.mainPopButton.setOnClickListener {

        }
    }

    override fun onDestroy() {
        super.onDestroy()
        mBinding = null
    }
}