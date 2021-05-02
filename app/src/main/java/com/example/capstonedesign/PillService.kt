package com.example.capstonedesign

import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface PillService {

    @FormUrlEncoded
    @POST("/drug/save")
    fun requestPill(
        @Field("itemName") itemName:String
    ) : Call<Pill>
}