package com.example.capstonedesign

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_login.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        //레트로핏 객체 생성
        var retrofit = Retrofit.Builder()
                .baseUrl("http://localhost:7000")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        //create을 통해 서비스를 올려줌
        var loginService = retrofit.create(LoginService::class.java)

        btnBack.setOnClickListener {
            onBtnBackClicked()
        }


        btnLogin.setOnClickListener {

            var textID = et_id2.text.toString()
            var textPW = et_pass2.text.toString()

            loginService.requestLogin(textID,textPW).enqueue(object: Callback<Login>{
                override fun onFailure(call: Call<Login>, t: Throwable) {
                    //통신 실패 (인터넷 끊김, 시스템적 문제 발생)
                    Log.d("FAIL","onFailure: 통신 실패")
                }

                override fun onResponse(call: Call<Login>, response: Response<Login>) {
                    if(response.isSuccessful()){
                        //정상적으로 통신이 성공된 경우
                        Log.d("SUCCESS","onResponse: 성공, 결과\n"+response.body().toString())
                        var dialog = AlertDialog.Builder(this@LoginActivity)
                        dialog.setTitle("알림")
                        dialog.setMessage("로그인 성공")
                        dialog.show()
                    }
                    else{
                        //통신 실패한 경우(응답코드 3xx, 4xx 등)
                        Log.d("FAIL"," onResponse: 통신 실패")
                    }
                }

            })
            onLoginClicked()

        }

    }

    fun onBtnBackClicked(){
        Log.d("", "LoginActivity-onBtnBackClicked() called")

        val intent = Intent(this, StartActivity::class.java)
        startActivity(intent)
    }

    fun onLoginClicked(){
        Log.d("","LoginActivity-onLoginClicked() called")

        val intent = Intent(this, HomeActivity::class.java)
        intent.putExtra("msg",et_id2.text.toString())
        startActivity(intent)
    }
}
