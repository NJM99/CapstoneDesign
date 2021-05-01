package com.example.capstonedesign

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_allergy.*
import kotlinx.android.synthetic.main.activity_indigestion.*

class AllergyActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_allergy)

        btnBack12.setOnClickListener {
            onBtnBackClicked()
        }
        val choiceProfileList = arrayListOf(
            ChoiceProfiles(R.drawable.square_line, "씨즈날정(세티리진염산염)"),
            ChoiceProfiles(R.drawable.square_line, "레티잘정(레보세티리진염산염)"),
            ChoiceProfiles(R.drawable.square_line, "그린노즈캡슐"),
            ChoiceProfiles(R.drawable.square_line, "세트린정(세티리진염산염)(수출명:ANTIRIZINtab)"),
            ChoiceProfiles(R.drawable.square_line, "노스민정(세티리진염산염)"),
            ChoiceProfiles(R.drawable.square_line, "센티콜캡슐"),
            ChoiceProfiles(R.drawable.square_line, "지르텍정(세티리진염산염)"),
            ChoiceProfiles(R.drawable.square_line, "센티펙정(세티리진염산염)"),
            ChoiceProfiles(R.drawable.square_line, "코메키나캡슐"),
            ChoiceProfiles(R.drawable.square_line, "알러샷연질캡슐(세티리진염산염)"),
            ChoiceProfiles(R.drawable.square_line, "클라리틴정(로라타딘)"),
            ChoiceProfiles(R.drawable.square_line, "알러엔연질캡슐(세티리진염산염)"),
            ChoiceProfiles(R.drawable.square_line, "알레르텍연질캡슐(세티리진염산염)"),
            ChoiceProfiles(R.drawable.square_line, "아르텍연질캡슐10mg(세티리진염산염)"),
            ChoiceProfiles(R.drawable.square_line, "로라딘연질캡슐(로라타딘)")

        )
        rv_allergy.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        rv_allergy.setHasFixedSize(true)

        rv_allergy.adapter = ChoiceProfileAdapter(choiceProfileList)
    }

    fun onBtnBackClicked() {
        Log.d("", "IndigestionActivity-onBtnBackClicked() called")

        val intent = Intent(this, ChoiceActivity::class.java)
        startActivity(intent)
    }
}