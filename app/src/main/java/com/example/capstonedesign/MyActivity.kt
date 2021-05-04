package com.example.capstonedesign

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_choice.*
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_my.*

class MyActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my)

        if (intent.hasExtra("msg")){//?
            textView5.text = intent.getStringExtra("msg")
        }

        if (intent.hasExtra("mypill")){
            intent.getStringExtra("mypill")
        }

        btnBack3.setOnClickListener {
            onBtnBackClicked()
        }
        val profileList = arrayListOf(
            Profiles(R.drawable.line, intent.getStringExtra("mypill").toString())
//            Profiles(R.drawable.line, "타세놀8시간이알서방정"),
//            Profiles(R.drawable.line, "타세놀8시간이알서방정"),
//            Profiles(R.drawable.line, "타세놀8시간이알서방정"),
//            Profiles(R.drawable.line, "타세놀8시간이알서방정"),
//            Profiles(R.drawable.line, "타세놀8시간이알서방정"),
//            Profiles(R.drawable.line, "타세놀8시간이알서방정"),
//            Profiles(R.drawable.line, "타세놀8시간이알서방정"),
//            Profiles(R.drawable.line, "타세놀8시간이알서방정")

        )
        rv_profile.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        rv_profile.setHasFixedSize(true)

        rv_profile.adapter = ProfileAdapter(profileList)
    }
    fun onBtnBackClicked(){
        Log.d("", "LoginActivity-onBtnBackClicked() called")

        val intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
    }
}