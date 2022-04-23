package pdp_project;

import pdp_project.dto.UserDto;

import java.util.List;

public class UserRepository {

    public List<UserDto> getAll() {
        return new SQL().select(getAllQuery(), UserDto.class);
    }

    private String getAllQuery() {
        return "SELECT * FROM `user`";
    }
}
