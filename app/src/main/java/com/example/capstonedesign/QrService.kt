package com.example.capstonedesign

import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface QrService {

    @FormUrlEncoded
    @POST("/drug/qrsearch")//엔드포인트 임의로 설정
    fun requestQr(
            @Field("drugInfor") drugInfor:String//서버에서 post받는 이름 임의로 설정
    ) : Call<Qr>
}