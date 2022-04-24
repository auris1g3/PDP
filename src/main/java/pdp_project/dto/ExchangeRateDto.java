package pdp_project.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.jdbi.v3.core.mapper.reflect.ColumnName;
import org.jdbi.v3.core.mapper.reflect.JdbiConstructor;

@Getter
@Setter
@ToString
@EqualsAndHashCode(callSuper = false)
public class ExchangeRateDto extends BaseDTO {

    private int id;
    private String currency;
    private double sellingRate,
            buyingRate;

    @JdbiConstructor
    public ExchangeRateDto(@ColumnName("id") int id, @ColumnName("currency") String currency,
                           @ColumnName("selling_rate") double sellingRate, @ColumnName("buying_rate") double buyingRate) {
        super();
        this.id = id;
        this.currency = currency;
        this.sellingRate = sellingRate;
        this.buyingRate = buyingRate;
    }

}
