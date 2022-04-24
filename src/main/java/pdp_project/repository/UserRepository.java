package pdp_project.repository;

import pdp_project.db.LoggedSQL;
import pdp_project.dto.UserDto;

import java.util.List;

public class UserRepository {

    public List<UserDto> getAll() {
        return new LoggedSQL().select(getAllQuery(), UserDto.class);
    }

    private String getAllQuery() {
        return "SELECT * FROM `user`";
    }
}
