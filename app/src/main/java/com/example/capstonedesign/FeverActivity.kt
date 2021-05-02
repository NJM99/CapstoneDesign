package com.example.capstonedesign

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_choice.*
import kotlinx.android.synthetic.main.activity_fever.*
import kotlinx.android.synthetic.main.activity_muscle.*

class FeverActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fever)

        btnBack9.setOnClickListener {
            onBtnBackClicked()
        }
        val choiceProfileList = arrayListOf(
            ChoiceProfiles(R.drawable.square_line, "타이레놀8시간이알서방정(아세트아미노펜)(수출명:Tylenol Arthritis Tablet+Tylenol8Hours+Tylenol8hour+Tylenol ER extended release Caplet+Tylenol8 Hour Extended Release Caplet)"),
            ChoiceProfiles(R.drawable.square_line, "게보린정(수출명:돌로린정)"),
            ChoiceProfiles(R.drawable.square_line, "트라몰8시간서방정650밀리그람(아세트아미노펜)"),
            ChoiceProfiles(R.drawable.square_line, "암타나정(수출용)"),
            ChoiceProfiles(R.drawable.square_line, "유펜정(수출용)"),
            ChoiceProfiles(R.drawable.square_line, "타이레놀8시간이알서방정325밀리그람(아세트아미노펜)"),
            ChoiceProfiles(R.drawable.square_line, "나노펜정"),
            ChoiceProfiles(R.drawable.square_line, "써스펜8시간이알서방정650mg(아세트아미노펜)"),
            ChoiceProfiles(R.drawable.square_line, "타이펜8시간이알서방정"),
            ChoiceProfiles(R.drawable.square_line, "유한폰탈정500밀리그람(메페남산)"),
            ChoiceProfiles(R.drawable.square_line, "사리돈에이정"),
            ChoiceProfiles(R.drawable.square_line, "티메롤8시간이알서방정(아세트아미노펜)"),
            ChoiceProfiles(R.drawable.square_line, "엔시드8시간이알서방정650mg(아세트아미노펜)"),
            ChoiceProfiles(R.drawable.square_line, "이부플러스생정"),
            ChoiceProfiles(R.drawable.square_line, "펜잘레이디정")

        )
        rv_fever.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        rv_fever.setHasFixedSize(true)

        rv_fever.adapter = ChoiceProfileAdapter(choiceProfileList)
    }
    fun onBtnBackClicked(){
        Log.d("", "FeverActivity-onBtnBackClicked() called")

        val intent = Intent(this, ChoiceActivity::class.java)
        startActivity(intent)
    }
}