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
public class UserDto extends BaseDTO {

    private int id,
            age,
            cityId,
            countryId;
    private String firstName,
            lastName;

    @JdbiConstructor
    public UserDto(@ColumnName("id") int id, @ColumnName("first_name") String firstName,
                   @ColumnName("last_name") String lastName, @ColumnName("age") int age,
                   @ColumnName("city_id") int cityId, @ColumnName("country_id") int countryId) {
        super();
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.cityId = cityId;
        this.countryId = countryId;
    }
}
