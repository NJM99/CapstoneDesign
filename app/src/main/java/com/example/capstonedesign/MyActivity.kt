package com.example.capstonedesign

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.util.Log
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_analysis.*
import kotlinx.android.synthetic.main.activity_choice.*
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_my.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MyActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my)

       var retrofit = Retrofit.Builder()
           .baseUrl("http://13.209.10.103/")
           .addConverterFactory(GsonConverterFactory.create())
           .build()


       var myService = retrofit.create(MyService::class.java)
       myService.requestMy().enqueue(object: Callback<My> {
           override fun onFailure(call: Call<My>, t: Throwable) {
               Log.d("TEST5","onFailure: 통신 실패")
               var dialog = AlertDialog.Builder(this@MyActivity)
               dialog.setTitle("알림")
               dialog.setMessage("My알약을 불러오는데 실패했습니다.")
               dialog.show()
           }
           override fun onResponse(call: Call<My>, response: Response<My>) {
               for (item in response.body()?.data!! ){
                   val res = item.itemName
                   val profileList = arrayListOf(
                       Profiles(R.drawable.line, res.toString())
                   )
                   rv_profile.layoutManager = LinearLayoutManager(this@MyActivity, LinearLayoutManager.VERTICAL, false)
                   rv_profile.setHasFixedSize(true)

                   rv_profile.adapter = ProfileAdapter(profileList)
               }
           }
       })

        if (intent.hasExtra("msg")){//?
            textView5.text = intent.getStringExtra("msg")
        }

        btnBack3.setOnClickListener {
            onBtnBackClicked()
        }
        val profileList = arrayListOf(
            Profiles(R.drawable.line, "씨콜드코프정"),
            Profiles(R.drawable.line, "케토라신정"),
            Profiles(R.drawable.line, "아펜탁정"),
            Profiles(R.drawable.line, "부루펜정200밀리그램(이부프로펜)")
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
