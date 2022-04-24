package pdp_project.db;



import pdp_project.dto.BaseDTO;

import java.util.List;

interface DataBaseQuery {

    <T extends BaseDTO> List<T> select(String query, Class<T> clazz);

    void update(String query);

    void delete(String query);
}
