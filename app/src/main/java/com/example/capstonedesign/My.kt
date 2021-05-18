package com.example.capstonedesign

import android.provider.ContactsContract
import org.json.JSONArray
import org.json.JSONObject

data class My(
        var data: ArrayList<Data>? = null
)
data class Data(
        var itemName: String
)
