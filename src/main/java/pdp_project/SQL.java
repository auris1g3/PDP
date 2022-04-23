package pdp_project;

import lombok.NoArgsConstructor;
import org.apache.log4j.Logger;
import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.core.mapper.reflect.ConstructorMapper;
import org.testng.Assert;
import pdp_project.dto.BaseDTO;


import java.util.List;


@NoArgsConstructor()
public class SQL implements DataBaseQuery {

    private static final Logger LOG = Logger.getLogger(SQL.class);

    static {
        try {
            connect().open().close();
        } catch (Exception e) {
            Assert.fail("Could not get DB connection! " + e.getMessage());
        }
    }

    private static Jdbi connect() {
        String dbUrl = "jdbc:mysql://localhost:3306/test";
        return Jdbi.create(dbUrl, "root", "rootadmin");
    }

    @Override
    public <T extends BaseDTO> List<T> select(String query, Class<T> clazz) {
        LOG.info("Query: " + query);
        try (var handle = connect().open()) {
            handle.registerRowMapper(ConstructorMapper.factory(clazz));
            return handle.createQuery(query).mapTo(clazz).list();
        }
    }

    @Override
    public void update(String query) {
        LOG.info("Query: " + query);
        try (var handle = connect().open()) {
            int affectedRows = handle.execute(query);
            LOG.info("@@ affectedRows: " + affectedRows);
        }

    }

    @Override
    public void delete(String query) {
        LOG.info("Query: " + query);
        try (var handle = connect().open()) {
            int affectedRows = handle.execute(query);
            LOG.info("@@ affectedRows: " + affectedRows);
        }
    }
}