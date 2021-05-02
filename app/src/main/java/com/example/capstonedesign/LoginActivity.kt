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
            .baseUrl("http://10.0.2.2:7000")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        btnBack.setOnClickListener {
            onBtnBackClicked()
        }

        btnLogin.setOnClickListener {
            //create을 통해 서비스를 올려줌
            var loginService = retrofit.create(LoginService::class.java)
            var textID = et_id2.text.toString()
            var textPW = et_pass2.text.toString()

            loginService.requestLogin(textID, textPW).enqueue(object: Callback<Login>{
                override fun onFailure(call: Call<Login>, t: Throwable) {
                    //통신 실패 (인터넷 끊김, 시스템적 문제 발생)
                    Log.d("FAIL","onFailure: 통신 실패")
                    var dialog = AlertDialog.Builder(this@LoginActivity)
                    dialog.setTitle("알림")
                    dialog.setMessage("로그인에 실패했습니다.")
                    dialog.show()
                }

                override fun onResponse(call: Call<Login>, response: Response<Login>) {
                    var result = response.body()
                    Log.d("TEST1", "isSuccessful: "+"${response.isSuccessful()}")
                    if(response.isSuccessful()){
                        //정상적으로 통신이 성공된 경우
                        Log.d("TEST2", "${response}")
                        var dialog = AlertDialog.Builder(this@LoginActivity)
                        dialog.setTitle("알림")
                        dialog.setMessage("로그인 성공")
                        dialog.show()
                        // onLoginClicked() // 실제로그인
                    }

                    Log.d("TEST3", "response: "+"${response}")
                    var dialog = AlertDialog.Builder(this@LoginActivity)
                    dialog.setTitle("알림")
                    dialog.setMessage("message: " + result)
                    dialog.show()
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