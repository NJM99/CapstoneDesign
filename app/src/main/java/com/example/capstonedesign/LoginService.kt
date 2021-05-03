package com.example.capstonedesign

import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

//실제 로그인 서비스
interface  LoginService{

    @FormUrlEncoded // 인코딩 오류 방지
    @POST("/user/login")
    fun requestLogin(
        @Field("email") email:String,//서버에서 post로 받는 이름이랑 같아야함
        @Field("password") password:String
    ) : Call<Login>
}
