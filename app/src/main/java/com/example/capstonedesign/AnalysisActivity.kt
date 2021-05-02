package com.example.capstonedesign

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_analysis.*
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class AnalysisActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_analysis)

        val AnalysisProfileList = arrayListOf(
            AnalysisProfiles("제조업체명", "제조업체명입니다"),
            AnalysisProfiles("효능효과", "효능효과입니다"),
            AnalysisProfiles("용법용량", "용법용량입니다"),
            AnalysisProfiles("주의사항", "주의사항입니다"),
            AnalysisProfiles("병용주의사항", "병용주의사항입니다"),
            AnalysisProfiles("부작용", "부작용입니다"),
            AnalysisProfiles("저장방법", "저장방법입니다")
        )
        rv_analysis.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        rv_analysis.setHasFixedSize(true)

        rv_analysis.adapter = AnalysisProfileAdapter(AnalysisProfileList)


        if(intent.hasExtra("pill")){//약이름
            name_pill.text=intent.getStringExtra("pill")
        }
        else{
            Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
        }

        if(intent.hasExtra("pill")){//제조업체
            name_pill.text=intent.getStringExtra("pill")
        }
        else{
            Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
        }

        if(intent.hasExtra("pill")){//알약 이미지
            name_pill.text=intent.getStringExtra("pill")
        }
        else{
            Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
        }

        if(intent.hasExtra("pill")){//효능효과
            name_pill.text=intent.getStringExtra("pill")
        }
        else{
            Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
        }

        if(intent.hasExtra("pill")){//용법용량
            name_pill.text=intent.getStringExtra("pill")
        }
        else{
            Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
        }

        if(intent.hasExtra("pill")){//주의사항
            name_pill.text=intent.getStringExtra("pill")
        }
        else{
            Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
        }

        if(intent.hasExtra("pill")){//병용주의사항
            name_pill.text=intent.getStringExtra("pill")
        }
        else{
            Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
        }

        if(intent.hasExtra("pill")){//부작용
            name_pill.text=intent.getStringExtra("pill")
        }
        else{
            Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
        }

        if(intent.hasExtra("pill")){//저장방법
            name_pill.text=intent.getStringExtra("pill")
        }
        else{
            Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
        }


    }
}
