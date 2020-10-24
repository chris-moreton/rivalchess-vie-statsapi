
package com.netsensia.rivalchess.recorder

import com.netsensia.rivalchess.vie.model.MatchUpStats

data class ResponsePayload(
        val matchUps: List<MatchUpStats>
)
