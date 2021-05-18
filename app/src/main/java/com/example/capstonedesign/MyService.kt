package com.example.capstonedesign

import kotlinx.android.synthetic.main.activity_analysis.*
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface MyService {
    @GET("/mydrug/show")//엔드포인트 수정
    fun requestMy() : Call<My>
}