package iss.dto.history

import lombok.{AllArgsConstructor, Data, NoArgsConstructor}
import iss.dto.securities.SecuritiesDto

@Data
@NoArgsConstructor
@AllArgsConstructor
class SHistoryDto {

    private val id = 0L
    private val tradeDate: String = null
    private val secId: String = null
    private val numTrades: String = null
    private val open: String = null
    private val securitiesDto: SecuritiesDto = null
}
