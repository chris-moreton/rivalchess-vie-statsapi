package com.netsensia.rivalchess.recorder.entity

import com.netsensia.rivalchess.vie.model.MatchUpStats
import org.springframework.data.annotation.Id
import org.springframework.data.redis.core.RedisHash

@RedisHash("RivalMatchStatistics")
data class RivalMatchStatistics(
        @org.springframework.data.redis.core.index.Indexed val name: String,
        val genre: String,
        val year: Int
) {
    @get:Id
    var id: String? = null
    @org.springframework.data.redis.core.index.Indexed
    @get:org.springframework.data.annotation.Reference
    var matchUpStats: List<MatchUpStats> = listOf()
}