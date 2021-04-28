package com.example.capstonedesign

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_choice.*
import kotlinx.android.synthetic.main.activity_login.*

class ChoiceActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choice)

        if (intent.hasExtra("msg")){
            textView3.text = intent.getStringExtra("msg")
        }
        btnBack2.setOnClickListener {
            onBtnBackClicked()
        }
    }
    fun onBtnBackClicked(){
        Log.d("", "LoginActivity-onBtnBackClicked() called")

        val intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
    }
}