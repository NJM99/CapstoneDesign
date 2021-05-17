package com.example.capstonedesign

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_create.*

class CreateActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create)

        button_back.setOnClickListener {
            onBackButtonClicked()
        }
        btnCreate.setOnClickListener {
            onBtnCreateClicked()
        }

        all_check.setOnClickListener {
            if (all_check.isChecked == true) {
                second.setChecked(true)
                third.setChecked(true)
                forth.setChecked(true)
            } else {
                all_check.setChecked(false)
                second.setChecked(false)
                third.setChecked(false)
                forth.setChecked(false)
            }
        }
    }
    fun onBackButtonClicked(){
        Log.d("", "CreateActivity-onBackButtonClicked() called")

        val intent = Intent(this, StartActivity::class.java)
        startActivity(intent)
    }
    fun onBtnCreateClicked(){
        Log.d("","CreateActivity-onCreateButtonClicked() called")

        val intent = Intent(this, StartActivity::class.java)
        startActivity(intent)
    }
}