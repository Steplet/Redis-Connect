package com.example.RedisConnect.consumer

import com.example.RedisConnect.controller.Controller
import com.fasterxml.jackson.core.json.UTF8JsonGenerator
import com.google.gson.Gson
import org.json.JSONObject
import org.springframework.boot.autoconfigure.web.ErrorProperties.Whitelabel
import org.springframework.context.annotation.Lazy
import org.springframework.data.redis.connection.Message
import org.springframework.data.redis.connection.MessageListener
import org.springframework.stereotype.Component

@Component
class Comsumer(@Lazy val controller:Controller): MessageListener {
    override fun onMessage(message: Message, pattern: ByteArray?) {

        var mes = message.toString().replace("\\", "")
        mes = mes.replace(Regex("^\"|\"$"), "")
        val json = JSONObject(mes)

        val cmd = json.get("Command")

        when( cmd) {
            "test" -> {

                println("test accepted")
                println(json)
//                println(json.get("dataPrice"))
            }
            "gotStock" -> {
                json.remove("Command")
                controller.sendToAppStock(json)
                println("stock got")
            }
            "gotAllStocks" -> {
                json.remove("Command")
                println(json)
                controller.showAllStocks(json)
            }
            else -> {
                println("Wrong: bad cmd")
            }
        }

    }

}