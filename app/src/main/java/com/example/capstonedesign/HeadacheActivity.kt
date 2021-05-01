package com.example.capstonedesign

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_cold.*
import kotlinx.android.synthetic.main.activity_headache.*

class HeadacheActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_headache)

        btnBack5.setOnClickListener {
            onBtnBackClicked()
        }
        val choiceProfileList = arrayListOf(
            ChoiceProfiles(R.drawable.square_line, "가이펜캡슐"),
            ChoiceProfiles(R.drawable.square_line, "게보린소프트연질캡슐"),
            ChoiceProfiles(R.drawable.square_line, "게보린정(수출명:돌로린정)"),
            ChoiceProfiles(R.drawable.square_line, "경동아세트아미노펜정(수출용)"),
            ChoiceProfiles(R.drawable.square_line, "그린콜샷리퀴드연질캡슐"),
            ChoiceProfiles(R.drawable.square_line, "그린콜연질캡슐"),
            ChoiceProfiles(R.drawable.square_line, "타이레놀8시간이알서방정325밀리그람(아세트아미노펜)"),
            ChoiceProfiles(R.drawable.square_line, "타이레놀8시간이알서방정(아세트아미노펜)(수출명:Tylenol Arthritis Tablet+Tylenol8Hours+Tylenol8hour+Tylenol ER extended release Caplet+Tylenol8 Hour Extended Release Caplet)"),
            ChoiceProfiles(R.drawable.square_line, "타이레놀정500밀리그람(아세트아미노펜)(수출명:TylenolExtraStrengthCaplets)"),
            ChoiceProfiles(R.drawable.square_line, "이지엔6애니연질캡슐(이부프로펜)"),
            ChoiceProfiles(R.drawable.square_line, "사리돈에이정"),
            ChoiceProfiles(R.drawable.square_line, "탁센이브연질캡슐"),
            ChoiceProfiles(R.drawable.square_line, "스피드펜연질캡슐200밀리그램(이부프로펜)"),
            ChoiceProfiles(R.drawable.square_line, "캐롤에프정(이부프로펜아르기닌)"),
            ChoiceProfiles(R.drawable.square_line, "나노펜정")

        )
        rv_head.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        rv_head.setHasFixedSize(true)

        rv_head.adapter = ChoiceProfileAdapter(choiceProfileList)
    }

    fun onBtnBackClicked() {
        Log.d("", "HeadacheActivity-onBtnBackClicked() called")

        val intent = Intent(this, ChoiceActivity::class.java)
        startActivity(intent)
    }
}