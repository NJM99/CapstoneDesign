package com.example.capstonedesign

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_muscle.*
import kotlinx.android.synthetic.main.activity_toothache.*

class MuscleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_muscle)

        btnBack8.setOnClickListener {
            onBtnBackClicked()
        }
        val choiceProfileList = arrayListOf(
            ChoiceProfiles(R.drawable.square_line, "엠피스정"),
            ChoiceProfiles(R.drawable.square_line, "탁센연질캡슐(나프록센)"),
            ChoiceProfiles(R.drawable.square_line, "신신아렉스정"),
            ChoiceProfiles(R.drawable.square_line, "담엔싹정"),
            ChoiceProfiles(R.drawable.square_line, "클로엠정"),
            ChoiceProfiles(R.drawable.square_line, "릴랙슬정(클로르족사존)"),
            ChoiceProfiles(R.drawable.square_line, "아클린정"),
            ChoiceProfiles(R.drawable.square_line, "클록펜정"),
            ChoiceProfiles(R.drawable.square_line, "머슬펜정"),
            ChoiceProfiles(R.drawable.square_line, "크로아존정"),
            ChoiceProfiles(R.drawable.square_line, "작감정(작약감초탕)"),
            ChoiceProfiles(R.drawable.square_line, "미다펜정"),
            ChoiceProfiles(R.drawable.square_line, "머피스펜정"),
            ChoiceProfiles(R.drawable.square_line, "타이레놀8시간이알서방정325밀리그람(아세트아미노펜)"),
            ChoiceProfiles(R.drawable.square_line, "타이레놀정500밀리그람(아세트아미노펜)(수출명:TylenolExtraStrengthCaplets)")
        )
        rv_muscle.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        rv_muscle.setHasFixedSize(true)

        rv_muscle.adapter = ChoiceProfileAdapter(choiceProfileList)
    }
    fun onBtnBackClicked(){
        Log.d("", "MuscleActivity-onBtnBackClicked() called")

        val intent = Intent(this, ChoiceActivity::class.java)
        startActivity(intent)
    }
}