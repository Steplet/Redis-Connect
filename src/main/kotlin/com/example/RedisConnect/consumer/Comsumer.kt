package com.example.RedisConnect.consumer

import com.fasterxml.jackson.core.json.UTF8JsonGenerator
import com.google.gson.Gson
import org.json.JSONObject
import org.springframework.boot.autoconfigure.web.ErrorProperties.Whitelabel
import org.springframework.data.redis.connection.Message
import org.springframework.data.redis.connection.MessageListener
import org.springframework.stereotype.Component

@Component
class Comsumer: MessageListener {
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
                println("stock got")
            }
            else -> {
                println("Wrong: bad cmd")
            }
        }

    }

}