package com.example.RedisConnect.controller

import com.example.RedisConnect.servises.DefService

import com.example.RedisConnect.servises.JsonServices
import netscape.javascript.JSObject
import org.json.JSONObject
import org.springframework.web.bind.annotation.*

/**
 * Api controller
 */
@RestController
@RequestMapping("/api/v1")
class Controller(val serv:DefService,
                 val jsonServ:JsonServices,
                )
{

    val channelMicroOne: String = "postMicroServicesOne"

    var jsonToApp:JSONObject = JSONObject()

    /**
     * Part of app's mapping
     */
    @PostMapping("/toApp")
    fun sendToApp(){
        TODO("Send data to app")
    }
    @PostMapping("/toAppStock")
    fun sendToAppStock(): String {
        return jsonToApp.toString()

    }
    @GetMapping("toApp/showAllStocks")
    fun showAllStocks(): String {
//        println(jsonToApp)
        return jsonToApp.toString()
    }
    @PostMapping("toApp/showPriceStock")
    fun showPriceStock(): String {
        return jsonToApp.toString()
    }

    /**
     * Part of microservices mapping
     */

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
    @PostMapping("/addStock/{symbol}/{number}")
    fun addStock(@PathVariable symbol:String, @PathVariable number:Int){
        val mess = jsonServ.createJsonSymbol(symbol, number,  "addStock")
        serv.noti(mess.toString(), channelMicroOne)
    }

    @PostMapping("showPriceStock/{symbol}")
    fun showPriceStock(@PathVariable symbol: String){
        val mess = JSONObject().put("Command", "showPriceStock")
        mess.put("symbol", symbol)
        serv.noti(mess.toString(), channelMicroOne)
    }

}