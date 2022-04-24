package pdp_project.proxyCache;

import pdp_project.db.LoggedSQL;
import pdp_project.dto.ExchangeRateDto;

import java.util.List;

public class SimpleExchangeRateProvider implements ExchangeRateProvider {


    @Override
    public List<ExchangeRateDto> getAllData() {
        return new LoggedSQL().select(getAllDataQuery(), ExchangeRateDto.class);
    }

    private String getAllDataQuery() {
        return "SELECT * FROM `exchange_rate`";
    }

    @Override
    public ExchangeRateDto getDataByCurrency(String currency) {
        return new LoggedSQL().select(getDataByCurrencyQuery(currency), ExchangeRateDto.class).get(0);
    }

    private String getDataByCurrencyQuery(String currency) {
        return "SELECT * FROM `exchange_rate` WHERE currency ='" + currency + "'";
    }
}
