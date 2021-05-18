package com.example.capstonedesign

import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface AddService {
    @FormUrlEncoded // 인코딩 오류 방지
    @POST("/drug/save2mydrug")//엔드포인트 수정
    fun requestAdd(
        @Field("itemName") itemName:String//서버에서 post로 받는 이름이랑 같아야함
    ) : Call<Add>
}