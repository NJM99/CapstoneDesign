package com.example.capstonedesign

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_headache.*
import kotlinx.android.synthetic.main.activity_stomachache.*

class StomachacheActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_stomachache)

        btnBack6.setOnClickListener {
            onBtnBackClicked()
        }
        val choiceProfileList = arrayListOf(
            ChoiceProfiles(R.drawable.square_line, "무스판정"),
            ChoiceProfiles(R.drawable.square_line, "싸이베린정"),
            ChoiceProfiles(R.drawable.square_line, "아나파베정"),
            ChoiceProfiles(R.drawable.square_line, "아네린정"),
            ChoiceProfiles(R.drawable.square_line, "부스코판당의정(부틸스코폴라민브롬화물)"),
            ChoiceProfiles(R.drawable.square_line, "부스코판플러스정"),
            ChoiceProfiles(R.drawable.square_line, "아파베린정"),
            ChoiceProfiles(R.drawable.square_line, "스카이정"),
            ChoiceProfiles(R.drawable.square_line, "바이스탑캡슐"),
            ChoiceProfiles(R.drawable.square_line, "메부라틴정150밀리그람(트리메부틴말레산염)(수출명:MEBURATIN Tablet 150mg)"),
            ChoiceProfiles(R.drawable.square_line, "로페도에프캡슐"),
            ChoiceProfiles(R.drawable.square_line, "바이메틴정(트리메부틴말레산염)"),
            ChoiceProfiles(R.drawable.square_line, "에스코판정"),
            ChoiceProfiles(R.drawable.square_line, "말릭스정(트리메부틴말레산염)"),
            ChoiceProfiles(R.drawable.square_line, "제이부틴정(트리메부틴말레산염)")

        )
        rv_stomach.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        rv_stomach.setHasFixedSize(true)

        rv_stomach.adapter = ChoiceProfileAdapter(choiceProfileList)
    }
    fun onBtnBackClicked(){
        Log.d("", "StomachacheActivity-onBtnBackClicked() called")

        val intent = Intent(this, ChoiceActivity::class.java)
        startActivity(intent)
    }
}