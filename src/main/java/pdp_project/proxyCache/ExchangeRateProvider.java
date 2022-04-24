package pdp_project.proxyCache;

import pdp_project.dto.ExchangeRateDto;

import java.util.List;

public interface ExchangeRateProvider {

    List<ExchangeRateDto> getAllData();

    ExchangeRateDto getDataByCurrency(String currency);
}
