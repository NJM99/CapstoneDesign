package com.example.capstonedesign

import kotlinx.android.synthetic.main.activity_analysis.*
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface MyService {
    @FormUrlEncoded // 인코딩 오류 방지
    @GET("/mydrug/show")//엔드포인트 수정
    fun requestMy() : Call<My>
}