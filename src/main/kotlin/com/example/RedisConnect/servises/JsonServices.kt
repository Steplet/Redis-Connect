package com.example.RedisConnect.servises

import org.json.JSONObject
import org.springframework.stereotype.Service

@Service
class JsonServices {

    public fun createJsonSymbol(symbol:String, cmd:String): JSONObject {
        val json = JSONObject()
        json.put("symbol", symbol)
        json.put("Command", cmd)
//        println(json)
        return json
    }
}