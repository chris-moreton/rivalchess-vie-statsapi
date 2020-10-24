package com.netsensia.rivalchess.recorder

import com.netsensia.rivalchess.vie.model.MatchUpStats
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class Controller {

    @GetMapping("/matchUpStats")
    fun stats(): ResponseEntity<MatchUpStats> {

        val matchUpStats = MatchUpStats("","","",1)
        return ResponseEntity.ok().body(matchUpStats)
    }

    @PostMapping("/matchUpStats")
    fun matchUpStats(@RequestBody matchUpStats: MatchUpsPayload): ResponseEntity<AcceptedPayload> {

        println("Received $matchUpStats")
        return ResponseEntity.accepted().body(AcceptedPayload())
    }

    @GetMapping("/health")
    fun health(): ResponseEntity<String> {
        return ResponseEntity.ok().body("ok")
    }
}