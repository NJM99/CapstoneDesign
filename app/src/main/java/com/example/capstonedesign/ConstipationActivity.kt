package com.example.capstonedesign

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_allergy.*
import kotlinx.android.synthetic.main.activity_constipation.*

class ConstipationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_constipation)

        btnBack13.setOnClickListener {
            onBtnBackClicked()
        }
        val choiceProfileList = arrayListOf(
            ChoiceProfiles(R.drawable.square_line, "엠티정"),
            ChoiceProfiles(R.drawable.square_line, "메이킨큐장용정"),
            ChoiceProfiles(R.drawable.square_line, "듀오그린정"),
            ChoiceProfiles(R.drawable.square_line, "센코딜에스정"),
            ChoiceProfiles(R.drawable.square_line, "비코그린에스정"),
            ChoiceProfiles(R.drawable.square_line, "비카린엠장용정"),
            ChoiceProfiles(R.drawable.square_line, "둘코락스에스장용정"),
            ChoiceProfiles(R.drawable.square_line, "생장환에스정"),
            ChoiceProfiles(R.drawable.square_line, "듀오락스정"),
            ChoiceProfiles(R.drawable.square_line, "디센트에스정"),
            ChoiceProfiles(R.drawable.square_line, "락서스정"),
            ChoiceProfiles(R.drawable.square_line, "리치정"),
            ChoiceProfiles(R.drawable.square_line, "아락실큐정"),
            ChoiceProfiles(R.drawable.square_line, "락토바이장용캡슐(바실루스서브틸리스균·엔테로코쿠스페슘균배양물)"),
            ChoiceProfiles(R.drawable.square_line, "미시론정")

        )
        rv_constipation.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        rv_constipation.setHasFixedSize(true)

        rv_constipation.adapter = ChoiceProfileAdapter(choiceProfileList)
    }

    fun onBtnBackClicked() {
        Log.d("", "IndigestionActivity-onBtnBackClicked() called")

        val intent = Intent(this, ChoiceActivity::class.java)
        startActivity(intent)
    }
}