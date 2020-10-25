package com.netsensia.rivalchess.recorder.service

import com.github.fppt.jedismock.RedisServer
import com.google.gson.Gson
import com.netsensia.rivalchess.recorder.model.RivalStatistics
import org.springframework.stereotype.Component
import redis.clients.jedis.Jedis

@Component
class RedisService {

    private val url = System.getenv("REDIS_HOST")
    private val port = System.getenv("REDIS_PORT").toInt()

    var jedis: Jedis? = null

    val gson = Gson()

    fun getCacheService(): Jedis {
        if (jedis == null) {
            if (url.equals("mock")) {
                val server = RedisServer.newRedisServer();  // bind to a random port
                server.start();
                jedis = Jedis(server.host, server.bindPort)
            } else {
                jedis = Jedis(url, port)
            }
        }
        return jedis!!
    }

    fun set(key: String, value: Any) {
        val str = gson.toJson(value)
        getCacheService().set(key, str)
    }

    fun getRivalStatistics(): RivalStatistics {
        val json = getCacheService().get("rivalStatistics")
        return gson.fromJson(json, RivalStatistics::class.java)
    }

}