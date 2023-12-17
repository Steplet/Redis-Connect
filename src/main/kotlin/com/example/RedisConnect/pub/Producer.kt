package com.example.RedisConnect.pub

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.data.redis.listener.ChannelTopic
import org.springframework.stereotype.Component

@Component
class Producer(val redisTemplate: RedisTemplate<String, Any>) {

    fun publish(text:String, channel:String){
        redisTemplate.convertAndSend(channel, text)
    }
}