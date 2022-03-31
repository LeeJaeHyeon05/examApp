package com.example.examapp

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.media.Rating
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.widget.*

class EvaluationDialog(context: Context) {
    private val dialog = Dialog(context)

    fun myDia() {
        dialog.show() // 보여주기
        dialog.setContentView(R.layout.activity_popup) // 레이아웃 연결
        dialog.window!!.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT)
        // 크기 설정
        dialog.setCanceledOnTouchOutside(false)
        dialog.setCancelable(false)
        // 외부 터치 캔슬 막리

        // 불러오기
        val reviewEditText = dialog.findViewById<EditText>(R.id.reviewEditText)
        val reviewButton = dialog.findViewById<Button>(R.id.reviewButton)
        val ratingBar = dialog.findViewById<RatingBar>(R.id.ratingBar)
        val spaceView2 = dialog.findViewById<View>(R.id.spaceView2)
        val spaceView1 = dialog.findViewById<View>(R.id.spaceView)
        val beforeFinishButton = dialog.findViewById<Button>(R.id.finishButton)
        val finishText = dialog.findViewById<TextView>(R.id.finishDialogText)

        // 기본 들어갔을때 보여주기 막기
        reviewEditText.visibility = View.GONE
        reviewButton.visibility = View.GONE
        spaceView2.visibility = View.GONE

        // 레이팅바 움직임 감지 해서 만약 있으면 에딧텍스트 보여주기
        ratingBar.setOnRatingBarChangeListener { _, _, _ ->
            reviewEditText.visibility = View.VISIBLE
            reviewButton.visibility = View.VISIBLE
            spaceView1.visibility = View.GONE
            spaceView2.visibility = View.VISIBLE
            beforeFinishButton.visibility = View.INVISIBLE
        }

        beforeFinishButton.setOnClickListener {
            finishDia()
        }

        // 리뷰 버튼 버튼리스너
        if (ratingBar != null) {
            reviewButton.setOnClickListener {
                dialog.dismiss()
                finishDia()
                val starNum = ratingBar.rating.toString()
                finishText.text = "$starNum 점 평가했습니다."
            }
        }


    }
    // 결과창 코드
    private fun finishDia() {
        dialog.show()
        dialog.setContentView(R.layout.activity_finish)
        dialog.window!!.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT)
        dialog.setCanceledOnTouchOutside(false)
        dialog.setCancelable(false)

        val finishDiaButton = dialog.findViewById<Button>(R.id.finishDialogButton)

        finishDiaButton.setOnClickListener {
            dialog.dismiss()
        }

//        val starRating = dialog.findViewById<RatingBar>(R.id.ratingBar)
//        val reviewButton = dialog.findViewById<Button>(R.id.reviewButton)
//        val finishText = dialog.findViewById<TextView>(R.id.finishDialogText)


    }


}