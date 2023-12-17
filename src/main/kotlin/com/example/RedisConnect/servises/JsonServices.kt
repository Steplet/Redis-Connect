package com.example.RedisConnect.servises

import org.json.JSONObject
import org.springframework.stereotype.Service

/**
 * Useful services for json manipulations
 */
@Service
class JsonServices {

    public fun createJsonSymbol(symbol:String, number: Int, cmd:String): JSONObject {
        val json = JSONObject()
        json.put("symbol", symbol)
        json.put("Number", number)
        json.put("Command", cmd)
//        println(json)
        return json
    }

    fun createJsonID(id:Int, cmd:String): JSONObject {
        val json = JSONObject()
        json.put("id", id)
        json.put("Command", cmd)
//        println(json)
        return json
    }
}