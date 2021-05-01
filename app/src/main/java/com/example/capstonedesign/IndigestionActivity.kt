package com.example.capstonedesign

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_cramps.*
import kotlinx.android.synthetic.main.activity_indigestion.*

class IndigestionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_indigestion)

        btnBack11.setOnClickListener {
            onBtnBackClicked()
        }
        val choiceProfileList = arrayListOf(
            ChoiceProfiles(R.drawable.square_line, "씨엠지모사프리드정(모사프리드시트르산염수화물)"),
            ChoiceProfiles(R.drawable.square_line, "아진팜정"),
            ChoiceProfiles(R.drawable.square_line, "베아제정"),
            ChoiceProfiles(R.drawable.square_line, "반사신정(반하사심탕연조엑스)"),
            ChoiceProfiles(R.drawable.square_line, "삼메틴정(트리메부틴말레산염)"),
            ChoiceProfiles(R.drawable.square_line, "복합파자임이중정"),
            ChoiceProfiles(R.drawable.square_line, "메부라틴정150밀리그람(트리메부틴말레산염)(수출명:MEBURATIN Tablet 150mg)"),
            ChoiceProfiles(R.drawable.square_line, "라니타드정"),
            ChoiceProfiles(R.drawable.square_line, "다우제큐정"),
            ChoiceProfiles(R.drawable.square_line, "개비스콘츄어블정"),
            ChoiceProfiles(R.drawable.square_line, "알게이트정(알마게이트)"),
            ChoiceProfiles(R.drawable.square_line, "라니티스정"),
            ChoiceProfiles(R.drawable.square_line, "트리겔정"),
            ChoiceProfiles(R.drawable.square_line, "제스판골드정"),
            ChoiceProfiles(R.drawable.square_line, "소하자임플러스정")

        )
        rv_indigestion.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        rv_indigestion.setHasFixedSize(true)

        rv_indigestion.adapter = ChoiceProfileAdapter(choiceProfileList)
    }

    fun onBtnBackClicked() {
        Log.d("", "IndigestionActivity-onBtnBackClicked() called")

        val intent = Intent(this, ChoiceActivity::class.java)
        startActivity(intent)
    }
}