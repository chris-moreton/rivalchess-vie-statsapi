package com.netsensia.rivalchess.recorder.model

import com.netsensia.rivalchess.vie.model.EngineRanking
import com.netsensia.rivalchess.vie.model.MatchUpStats
import com.netsensia.rivalchess.vie.model.MatchUpStatsConsolidated

class RivalStatistics (
    val matchUps: List<MatchUpStats>,
    val rankings: List<EngineRanking>,
    val matchUpsConsolidated: List<MatchUpStatsConsolidated>
)