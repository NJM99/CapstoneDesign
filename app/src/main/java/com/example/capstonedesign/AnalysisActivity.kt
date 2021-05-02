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


        if(intent.hasExtra("pill")){
            name_pill.text=intent.getStringExtra("pill")
        }
        else{
            Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
        }

        setFrag(0)

        btn_summary.setOnClickListener {
            setFrag(0)
        }

        btn_detail.setOnClickListener {
            setFrag(1)
        }

    }
    private fun setFrag(fragNum : Int) {
        val ft = supportFragmentManager.beginTransaction()
        when(fragNum)
        {
            0 ->{
                ft.replace(R.id.main_frame, SummaryActivity()).commit()
            }
            1 ->{
                ft.replace(R.id.main_frame, DetailActivity()).commit()
            }
        }
    }
}
