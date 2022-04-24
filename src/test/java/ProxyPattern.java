import pdp_project.db.LoggedSQL;
import pdp_project.db.SQL;
import pdp_project.proxyCache.CachedExchangeRateProvider;
import pdp_project.proxyCache.SimpleExchangeRateProvider;

public class ProxyPattern {
    public static void main(String[] args) {

        //Proxy LOG
        new SQL().update("update `user` set age=34 WHERE id= 1");
        System.out.println();
        new LoggedSQL().update("update `user` set age=34 WHERE id= 1");
        System.out.println("---------------");

        //Proxy cache
        //Without cache
        SimpleExchangeRateProvider simpleExchangeRateProvider = new SimpleExchangeRateProvider();
        System.out.println(simpleExchangeRateProvider.getAllData());

        System.out.println(simpleExchangeRateProvider.getDataByCurrency("USD"));
        System.out.println();

        //With cache
        CachedExchangeRateProvider cachedExchangeRateProvider = new CachedExchangeRateProvider(simpleExchangeRateProvider);
        System.out.println(cachedExchangeRateProvider.getAllData());
        System.out.println();
        System.out.println(cachedExchangeRateProvider.getDataByCurrency("USD"));
        System.out.println();

        System.out.println(cachedExchangeRateProvider.getAllData());
        System.out.println();
        System.out.println(cachedExchangeRateProvider.getDataByCurrency("USD"));
        System.out.println();

        //add new row in db and reload cache with new currencyList
        cachedExchangeRateProvider.revalidateCache();
        System.out.println(cachedExchangeRateProvider.getAllData());
        System.out.println();
        System.out.println(cachedExchangeRateProvider.getDataByCurrency("USD"));
        System.out.println();
    }
}
