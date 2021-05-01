package com.example.capstonedesign

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_choice.*
import kotlinx.android.synthetic.main.activity_cold.*
import kotlinx.android.synthetic.main.activity_my.*
import kotlinx.android.synthetic.main.activity_start.*
import kotlinx.android.synthetic.main.list_choice.*

class ColdActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cold)

        btnBack4.setOnClickListener {
            onBtnBackClicked()
        }

        val choiceProfileList = arrayListOf(
            ChoiceProfiles(R.drawable.square_line, "씨콜드코프정"),
            ChoiceProfiles(R.drawable.square_line, "타이레놀8시간이알서방정(아세트아미노펜)(수출명:Tylenol Arthritis Tablet+Tylenol8Hours+Tylenol8hour+Tylenol ER extended release Caplet+Tylenol8 Hour Extended Release Caplet)"),
            ChoiceProfiles(R.drawable.square_line, "속코정"),
            ChoiceProfiles(R.drawable.square_line, "휴텍스에이에이피정325밀리그람(아세트아미노펜제피세립)"),
            ChoiceProfiles(R.drawable.square_line, "부루펜정200밀리그램(이부프로펜)"),
            ChoiceProfiles(R.drawable.square_line, "부루펜정400밀리그램(이부프로펜)"),
            ChoiceProfiles(R.drawable.square_line, "토우펜정(수출용)"),
            ChoiceProfiles(R.drawable.square_line, "에카씬정"),
            ChoiceProfiles(R.drawable.square_line, "루트펜325밀리그램정(아세트아미노펜)"),
            ChoiceProfiles(R.drawable.square_line, "트라몰정325밀리그람(아세트아미노펜"),
            ChoiceProfiles(R.drawable.square_line, "슈카민정"),
            ChoiceProfiles(R.drawable.square_line, "스코펜정400밀리그램(이부프로펜)"),
            ChoiceProfiles(R.drawable.square_line, "타스펜8시간이알서방정650밀리그람(아세트아미노펜)(수출명:도로돈이알정)"),
            ChoiceProfiles(R.drawable.square_line, "라페론정160밀리그람(아세트아미노펜)"),
            ChoiceProfiles(R.drawable.square_line, "타스멘정(아세트아미노펜)")


        )
        rv_cold.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        rv_cold.setHasFixedSize(true)

        rv_cold.adapter = ChoiceProfileAdapter(choiceProfileList)
    }
    fun onBtnBackClicked(){
        Log.d("", "ColdActivity-onBtnBackClicked() called")

        val intent = Intent(this, ChoiceActivity::class.java)
        startActivity(intent)
    }
}