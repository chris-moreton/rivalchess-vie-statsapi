
package com.netsensia.rivalchess.recorder

import com.netsensia.rivalchess.recorder.entity.RivalMatchStatistics

data class ResponsePayload(
        val matchUps: List<RivalMatchStatistics>
)
