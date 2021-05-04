package com.example.capstonedesign

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.capstonedesign.Model.Companion.multi_type1
import com.example.capstonedesign.Model.Companion.multi_type2
import kotlinx.android.synthetic.main.activity_analysis.*
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.Date.from

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

        Glide.with(this).load(intent.getStringExtra("itemImage"))
            .error(R.drawable.error)//사진을 불러오지 못했을 때 오류 이미지
            .into(image_pill)

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
                Model(multi_type1,"효능효과", intent.getStringExtra("efficiency").toString()),
                Model(multi_type1,"제조업체명", intent.getStringExtra("entpName").toString()),
                Model(multi_type1,"용법용량", intent.getStringExtra("useMethod").toString()),
                Model(multi_type2,"주의사항", intent.getStringExtra("warning").toString()),
                Model(multi_type2,"병용주의사항", intent.getStringExtra("intrcnt").toString()),
                Model(multi_type2,"부작용", intent.getStringExtra("sideEffect").toString()),
                Model(multi_type1,"저장방법", intent.getStringExtra("depositMethod").toString())
        )
        rv_analysis.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        rv_analysis.setHasFixedSize(true)

        rv_analysis.adapter = AnalysisProfileAdapter(AnalysisProfileList)

        btn_yes.setOnClickListener {
            onBtnYesClicked()
        }

        btn_no.setOnClickListener {
            onBtnNoClicked()
        }
    }

    fun onBtnYesClicked(){
        Log.d("", "AnalysisActivity-onBtnYesClicked() called")
        val intent = Intent(this, MyActivity::class.java)
        intent.putExtra("mypill", intent.getStringExtra("pill"))//알약 보내기
        startActivity(intent)
    }

    fun onBtnNoClicked(){
        Log.d("", "AnalysisActivity-onBtnNoClicked() called")

        val intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
    }
}

