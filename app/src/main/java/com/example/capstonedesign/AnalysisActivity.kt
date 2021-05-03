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


        if(intent.hasExtra("pill")){//약이름
            name_pill.text=intent.getStringExtra("pill")
        }
        else{
            Toast.makeText(this, "Error1", Toast.LENGTH_SHORT).show()
        }

        if(intent.hasExtra("entpName")){//제조업체
            intent.getStringExtra("entpName")
        }
        else{
            Toast.makeText(this, "Error2", Toast.LENGTH_SHORT).show()
        }

        if(intent.hasExtra("itemImage")){//알약 이미지
            intent.getStringExtra("itemImage")
        }
        else{
            Toast.makeText(this, "Error3", Toast.LENGTH_SHORT).show()
        }

        if(intent.hasExtra("efficiency")){//효능효과
            intent.getStringExtra("efficiency")
        }
        else{
            Toast.makeText(this, "Error4", Toast.LENGTH_SHORT).show()
        }

        if(intent.hasExtra("useMethod")){//용법용량
            intent.getStringExtra("useMethod")
        }
        else{
            Toast.makeText(this, "Error5", Toast.LENGTH_SHORT).show()
        }

        if(intent.hasExtra("warning")){//주의사항
            intent.getStringExtra("warning")
        }
        else{
            Toast.makeText(this, "Error6", Toast.LENGTH_SHORT).show()
        }

        if(intent.hasExtra("intrcnt")){//병용주의사항
            intent.getStringExtra("intrcnt")
        }
        else{
            Toast.makeText(this, "Error7", Toast.LENGTH_SHORT).show()
        }

        if(intent.hasExtra("sideEffect")){//부작용
            intent.getStringExtra("sideEffect")
        }
        else{
            Toast.makeText(this, "Error8", Toast.LENGTH_SHORT).show()
        }

        if(intent.hasExtra("depositMethod")){//저장방법
            intent.getStringExtra("depositMethod")
        }
        else{
            Toast.makeText(this, "Error9", Toast.LENGTH_SHORT).show()
        }




        val AnalysisProfileList = arrayListOf(
            AnalysisProfiles("효능효과", intent.getStringExtra("efficiency").toString()),
            AnalysisProfiles("제조업체명", intent.getStringExtra("entpName").toString()),
            AnalysisProfiles("용법용량", intent.getStringExtra("useMethod").toString()),
            AnalysisProfiles("주의사항", intent.getStringExtra("warning").toString()),
            AnalysisProfiles("병용주의사항", intent.getStringExtra("intrcnt").toString()),
            AnalysisProfiles("부작용", intent.getStringExtra("sideEffect").toString()),
            AnalysisProfiles("저장방법", intent.getStringExtra("depositMethod").toString())
        )
        rv_analysis.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        rv_analysis.setHasFixedSize(true)

        rv_analysis.adapter = AnalysisProfileAdapter(AnalysisProfileList)





    }
}

