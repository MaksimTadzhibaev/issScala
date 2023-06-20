package iss.service;

import iss.dto.securities.SecuritiesDto;
import org.springframework.data.domain.Page;
import iss.dto.HistoryAndSecuritiesListParams;
import iss.dto.history.HistoryDto;

import java.util.List;
import java.util.Optional;

public interface HistoryAndSecuritiesService {
    Page<HistoryDto> findAllHistoryAndSecuritiesWithParam(HistoryAndSecuritiesListParams historyAndSecuritiesListParams);
    List<HistoryDto> findAllHistory();
    List<SecuritiesDto> findAllSecurities();
    Optional<HistoryDto> findByIdHistory(Long id);
    Optional<SecuritiesDto> findByIdSecurities(String id);
    void saveHistory(HistoryDto historyDto);
    void saveSecurities(SecuritiesDto securitiesDto);
    void deleteByIdHistory(Long id);
    void deleteByIdSecurities(String id);
}
