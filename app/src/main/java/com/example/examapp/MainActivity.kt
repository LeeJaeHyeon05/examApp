package com.example.examapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.examapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var mBinding : ActivityMainBinding? = null
    private val binding get() = mBinding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        popUpButton()

    }
    private fun popUpButton() {
        binding.mainPopButton.setOnClickListener {
            Log.d("msg", "버튼 눌림")
            // 객체 생서
            val dialog = EvaluationDialog(this)
            dialog.myDia()

        }
    }



    override fun onDestroy() {
        super.onDestroy()
        mBinding = null
    }
}