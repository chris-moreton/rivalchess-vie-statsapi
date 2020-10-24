package com.netsensia.rivalchess.recorder

import com.netsensia.rivalchess.vie.model.MatchUpStats

data class MatchUpsPayload (
    val matchUps: List<MatchUpStats>
)