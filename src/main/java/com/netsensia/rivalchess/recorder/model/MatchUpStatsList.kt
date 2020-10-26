package com.netsensia.rivalchess.recorder.model

import com.netsensia.rivalchess.vie.model.EngineRanking
import com.netsensia.rivalchess.vie.model.MatchUpStats

class RivalStatistics (
    val matchUps: List<MatchUpStats>,
    val rankings: List<EngineRanking>
)