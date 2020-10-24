package com.netsensia.rivalchess.recorder

import com.netsensia.rivalchess.recorder.model.RivalStatistics
import com.netsensia.rivalchess.recorder.service.RedisService
import com.netsensia.rivalchess.vie.model.MatchUpStats
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class Controller {

    @Autowired
    private lateinit var redisService: RedisService

    @GetMapping("/matchUpStats")
    fun stats(): ResponseEntity<RivalStatistics> {
        val rivalStatistics = redisService.getRivalStatistics()

        return ResponseEntity.ok().body(rivalStatistics)
    }

    @PostMapping("/matchUpStats")
    fun matchUpStats(@RequestBody matchUpStats: MatchUpsPayload): ResponseEntity<AcceptedPayload> {

        println("Received $matchUpStats")

        redisService.set("rivalStatistics", ResponsePayload(matchUpStats.matchUps))

        return ResponseEntity.accepted().body(AcceptedPayload())
    }

    @GetMapping("/health")
    fun health(): ResponseEntity<String> {
        return ResponseEntity.ok().body("ok")
    }
}