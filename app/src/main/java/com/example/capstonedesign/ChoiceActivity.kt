package com.example.capstonedesign

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_choice.*

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
        btn_cold.setOnClickListener {
            onColdButtonClicked()

        }
        btn_head.setOnClickListener {
            onHeadButtonClicked()

        }
        btn_stomach.setOnClickListener {
            onStomachButtonClicked()

        }
        btn_tooth.setOnClickListener {
            onToothButtonClicked()

        }
        btn_muscle.setOnClickListener {
            onMuscleButtonClicked()

        }
        btn_fever.setOnClickListener {
            onFeverButtonClicked()

        }
        btn_cramps.setOnClickListener {
            onCrampsButtonClicked()

        }
        btn_indigestion.setOnClickListener {
            onIndigestionButtonClicked()

        }
        btn_allergy.setOnClickListener {
            onAllergyButtonClicked()

        }
        btn_constipation.setOnClickListener {
            onConstipationButtonClicked()

        }

    }
    fun onBtnBackClicked(){
        Log.d("", "ChoiceActivity-onBtnBackClicked() called")

        val intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
    }
    fun onColdButtonClicked() {
        Log.d("", "ChoiceActivity-onButtonClicked() called")

        val intent = Intent(this, ColdActivity::class.java)
        startActivity(intent)
    }
    fun onHeadButtonClicked() {
        Log.d("", "ChoiceActivity-onButtonClicked() called")

        val intent = Intent(this, HeadacheActivity::class.java)
        startActivity(intent)
    }
    fun onStomachButtonClicked() {
        Log.d("", "ChoiceActivity-onButtonClicked() called")

        val intent = Intent(this, StomachacheActivity::class.java)
        startActivity(intent)
    }
    fun onToothButtonClicked() {
        Log.d("", "ChoiceActivity-onButtonClicked() called")

        val intent = Intent(this, ToothacheActivity::class.java)
        startActivity(intent)
    }
    fun onMuscleButtonClicked() {
        Log.d("", "ChoiceActivity-onButtonClicked() called")

        val intent = Intent(this, MuscleActivity::class.java)
        startActivity(intent)
    }
    fun onFeverButtonClicked() {
        Log.d("", "ChoiceActivity-onButtonClicked() called")

        val intent = Intent(this, FeverActivity::class.java)
        startActivity(intent)
    }
    fun onCrampsButtonClicked() {
        Log.d("", "ChoiceActivity-onButtonClicked() called")

        val intent = Intent(this, CrampsActivity::class.java)
        startActivity(intent)
    }
    fun onIndigestionButtonClicked() {
        Log.d("", "ChoiceActivity-onButtonClicked() called")

        val intent = Intent(this, IndigestionActivity::class.java)
        startActivity(intent)
    }
    fun onAllergyButtonClicked() {
        Log.d("", "ChoiceActivity-onButtonClicked() called")

        val intent = Intent(this, AllergyActivity::class.java)
        startActivity(intent)
    }
    fun onConstipationButtonClicked() {
        Log.d("", "ChoiceActivity-onButtonClicked() called")

        val intent = Intent(this, ConstipationActivity::class.java)
        startActivity(intent)
    }
}