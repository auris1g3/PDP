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
public class CityDto extends BaseDTO {

    private int id;
    private String name;

    @JdbiConstructor
    public CityDto(@ColumnName("id") int id, @ColumnName("name") String name) {
        super();
        this.id = id;
        this.name = name;
    }
}
