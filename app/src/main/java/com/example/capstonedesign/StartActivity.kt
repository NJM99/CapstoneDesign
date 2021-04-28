package com.example.capstonedesign

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_start.*

class StartActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)

        btn_Login.setOnClickListener {
            onLoginButtonClicked()

        }

        btn_Create.setOnClickListener {
            onCreateButtonClicked()

        }

    }

    fun onLoginButtonClicked() {
        Log.d("", "StartActivity-onLoginButtonClicked() called")

        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
    }

    fun onCreateButtonClicked(){
        Log.d("","StartActivity-onCreateButtonClicked() called")

        val intent = Intent(this, CreateActivity::class.java)
        startActivity(intent)
    }
}