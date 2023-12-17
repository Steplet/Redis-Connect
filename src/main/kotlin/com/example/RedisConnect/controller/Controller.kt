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
    @PostMapping("/toAppStock")
    fun sendToAppStock(data: JSONObject): JSONObject {
        return data

    }
    @PostMapping("toApp/showAllStocks")
    fun showAllStocks(data: JSONObject): JSONObject{
        return data
    }


    @PostMapping("delStock/{id}")
    fun delStockById(@PathVariable id:Int){
        val mess = jsonServ.createJsonID(id, "delById")
        serv.noti(mess.toString(), channelMicroOne)
    }

    @PostMapping("/getAllStocks")
    fun getAllStocks(){
        val mess = JSONObject().put("Command", "getAllStocks")
        serv.noti(mess.toString(), channelMicroOne)
    }
    @PostMapping("/getStock/{symbol}/{number}")
    fun getStock(@PathVariable symbol:String, @PathVariable number:Int){
        val mess = jsonServ.createJsonSymbol(symbol, number,  "getStock")
        serv.noti(mess.toString(), channelMicroOne)
    }

}