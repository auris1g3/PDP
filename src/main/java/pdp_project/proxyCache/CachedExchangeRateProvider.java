package pdp_project.proxyCache;

import lombok.SneakyThrows;
import pdp_project.dto.ExchangeRateDto;

import java.util.List;

public class CachedExchangeRateProvider implements ExchangeRateProvider {

    private final SimpleExchangeRateProvider simpleExchangeRateProvider;
    private List<ExchangeRateDto> currencyList;

    public CachedExchangeRateProvider(SimpleExchangeRateProvider simpleExchangeRateProvider) {
        this.simpleExchangeRateProvider = simpleExchangeRateProvider;
        this.currencyList = simpleExchangeRateProvider.getAllData();
    }

    @Override
    public List<ExchangeRateDto> getAllData() {
        return this.currencyList.isEmpty()
                ? simpleExchangeRateProvider.getAllData()
                : currencyList;
    }

    @SneakyThrows
    @Override
    public ExchangeRateDto getDataByCurrency(String currency) {
        return currencyList.stream().filter(f -> f.getCurrency().equals(currency)).findFirst()
                .orElseThrow(() -> new Exception("Not found currency " + currency));
    }

    public void revalidateCache() {
        this.currencyList = simpleExchangeRateProvider.getAllData();
    }
}
