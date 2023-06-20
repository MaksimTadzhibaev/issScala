package iss.dto.history;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import iss.dto.securities.SecuritiesDto;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HistoryDto {

    private Long id;
    private String tradeDate;
    private String secId;
    private String numTrades;
    private String open;
    private SecuritiesDto securitiesDto;
}
