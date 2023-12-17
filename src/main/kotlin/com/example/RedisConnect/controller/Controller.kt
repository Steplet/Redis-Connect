package com.example.RedisConnect.controller

import com.example.RedisConnect.servises.DefServise
import com.example.RedisConnect.servises.JsonServices
import netscape.javascript.JSObject
import org.json.JSONObject
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1")
class Controller(val serv:DefServise,
                 val jsonServ:JsonServices,
                )
{

    val channelMicroOne: String = "postMicroServicesOne"

    @PostMapping("/redis")
    private fun sendIt(){
        serv.noti("Hello", channelMicroOne)
    }

    @PostMapping("/toApp")
    fun sendToApp(){
        TODO("Send data to app")
    }
    @GetMapping("/toApp")
    fun sendToAppStock(data: JSONObject): JSONObject {
        println("test")
        return data

    }

    @PostMapping("/getStock/{symbol}")
    fun getStock(@PathVariable symbol:String){
        val mess = jsonServ.createJsonSymbol(symbol, "getStock")
        serv.noti(mess.toString(), channelMicroOne)
    }

}