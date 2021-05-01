package com.example.capstonedesign

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_choice.*
import kotlinx.android.synthetic.main.activity_stomachache.*
import kotlinx.android.synthetic.main.activity_toothache.*

class ToothacheActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_toothache)

        btnBack7.setOnClickListener {
            onBtnBackClicked()
        }
        val choiceProfileList = arrayListOf(
            ChoiceProfiles(R.drawable.square_line, "게보린소프트연질캡슐"),
            ChoiceProfiles(R.drawable.square_line, "게보린정(수출명:돌로린정)"),
            ChoiceProfiles(R.drawable.square_line, "경동아세트아미노펜정(수출용)"),
            ChoiceProfiles(R.drawable.square_line, "나노펜정"),
            ChoiceProfiles(R.drawable.square_line, "넥스펜정"),
            ChoiceProfiles(R.drawable.square_line, "덴파사캡슐"),
            ChoiceProfiles(R.drawable.square_line, "탁센연질캡슐(나프록센)"),
            ChoiceProfiles(R.drawable.square_line, "탁센이브연질캡슐"),
            ChoiceProfiles(R.drawable.square_line, "진지반캡슐(청위산)"),
            ChoiceProfiles(R.drawable.square_line, "타이레놀8시간이알서방정325밀리그람(아세트아미노펜)"),
            ChoiceProfiles(R.drawable.square_line, "타이레놀8시간이알서방정(아세트아미노펜)(수출명:Tylenol Arthritis Tablet+Tylenol8Hours+Tylenol8hour+Tylenol ER extended release Caplet+Tylenol8 Hour Extended Release Caplet)"),
            ChoiceProfiles(R.drawable.square_line, "타이레놀정500밀리그람(아세트아미노펜)(수출명:TylenolExtraStrengthCaplets)"),
            ChoiceProfiles(R.drawable.square_line, "엔프렌드연질캡슐(나프록센)"),
            ChoiceProfiles(R.drawable.square_line, "이모나캡슐"),
            ChoiceProfiles(R.drawable.square_line, "클리신정(클로닉신리시네이트)(수출명:CLICIN Tab)")

        )
        rv_tooth.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        rv_tooth.setHasFixedSize(true)

        rv_tooth.adapter = ChoiceProfileAdapter(choiceProfileList)
    }
    fun onBtnBackClicked(){
        Log.d("", "ToothacheActivity-onBtnBackClicked() called")

        val intent = Intent(this, ChoiceActivity::class.java)
        startActivity(intent)
    }
}