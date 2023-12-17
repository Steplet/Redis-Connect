package com.example.RedisConnect.controller

import com.example.RedisConnect.servises.DefServise
import com.example.RedisConnect.servises.JsonServices
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

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

    @PostMapping("/getStock/{symbol}")
    fun getStock(@PathVariable symbol:String){
        val mess = jsonServ.createJsonSymbol(symbol, "getStock")
        serv.noti(mess.toString(), channelMicroOne)
    }

}