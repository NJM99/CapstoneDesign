package com.example.capstonedesign

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_cramps.*
import kotlinx.android.synthetic.main.activity_fever.*

class CrampsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cramps)

        btnBack10.setOnClickListener {
            onBtnBackClicked()
        }
        val choiceProfileList = arrayListOf(
            ChoiceProfiles(R.drawable.square_line, "게보린정(수출명:돌로린정)"),
            ChoiceProfiles(R.drawable.square_line, "나노펜정"),
            ChoiceProfiles(R.drawable.square_line, "게보린소프트연질캡슐"),
            ChoiceProfiles(R.drawable.square_line, "이지엔6애니연질캡슐(이부프로펜)"),
            ChoiceProfiles(R.drawable.square_line, "타이레놀8시간이알서방정(아세트아미노펜)(수출명:Tylenol Arthritis Tablet+Tylenol8Hours+Tylenol8hour+Tylenol ER extended release Caplet+Tylenol8 Hour Extended Release Caplet)"),
            ChoiceProfiles(R.drawable.square_line, "타이레놀8시간이알서방정325밀리그람(아세트아미노펜)"),
            ChoiceProfiles(R.drawable.square_line, "탁센이브연질캡슐"),
            ChoiceProfiles(R.drawable.square_line, "우먼스타이레놀정"),
            ChoiceProfiles(R.drawable.square_line, "그날엔정"),
            ChoiceProfiles(R.drawable.square_line, "스카이정"),
            ChoiceProfiles(R.drawable.square_line, "캐롤엔연질캡슐(나프록센)"),
            ChoiceProfiles(R.drawable.square_line, "워너비올리브연질캡슐(이부프로펜)"),
            ChoiceProfiles(R.drawable.square_line, "탁센연질캡슐(나프록센)"),
            ChoiceProfiles(R.drawable.square_line, "이브터치연질캡슐"),
            ChoiceProfiles(R.drawable.square_line, "레이디원연질캡슐")

        )
        rv_cramps.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        rv_cramps.setHasFixedSize(true)

        rv_cramps.adapter = ChoiceProfileAdapter(choiceProfileList)
    }

    fun onBtnBackClicked() {
        Log.d("", "CrampsActivity-onBtnBackClicked() called")

        val intent = Intent(this, ChoiceActivity::class.java)
        startActivity(intent)
    }
}