package com.netsensia.rivalchess.recorder.service

import com.google.gson.Gson
import com.netsensia.rivalchess.recorder.model.RivalStatistics
import org.springframework.stereotype.Component
import redis.clients.jedis.Jedis

@Component
class RedisService {

    private val url = System.getenv("REDIS_HOST")
    private val port = System.getenv("REDIS_PORT").toInt()

    val jedis: Jedis = Jedis(url, port)
    val gson = Gson()

    fun set(key: String, value: Any) {
        val str = gson.toJson(value)
        jedis.set(key, str)
    }

    fun getRivalStatistics(): RivalStatistics {
        val json = jedis.get("RivalStatistics")
        return gson.fromJson(json, RivalStatistics::class.java)
    }

}