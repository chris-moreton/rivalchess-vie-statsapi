package com.netsensia.rivalchess.recorder

import com.netsensia.rivalchess.recorder.model.RivalStatistics
import com.netsensia.rivalchess.recorder.service.RedisService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
class Controller {

    @Autowired
    private lateinit var redisService: RedisService

    @GetMapping("/matchUpStats")
    @CrossOrigin(origins = arrayOf("http://localhost:3000"))
    fun stats(): ResponseEntity<RivalStatistics> {
        val rivalStatistics = redisService.getRivalStatistics()

        return ResponseEntity.ok().body(rivalStatistics)
    }

    @PostMapping("/matchUpStats")
    @CrossOrigin(origins = arrayOf("http://localhost:3000"))
    fun matchUpStats(@RequestBody matchUpStats: MatchUpsPayload): ResponseEntity<AcceptedPayload> {

        println("Received $matchUpStats")

        redisService.set("rivalStatistics", RivalStatistics(
                matchUpStats.matchUps,
                matchUpStats.rankings)
        )

        return ResponseEntity.accepted().body(AcceptedPayload())
    }

    @GetMapping("/health")
    fun health(): ResponseEntity<String> {
        return ResponseEntity.ok().body("ok")
    }
}