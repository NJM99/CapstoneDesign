package com.example.capstonedesign

import android.media.session.MediaSession
import com.google.gson.JsonObject
import org.json.JSONObject
import java.util.*

//아웃풋 생성
data class Login(
        var message: String,
        var token: Token
)
data class Token(
        var accessToken: String,
        var refreshToken: String,
        var name: String
)


