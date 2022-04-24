package pdp_project.db;

import org.apache.log4j.Logger;
import pdp_project.dto.BaseDTO;

import java.util.List;

public class LoggedSQL implements DataBaseQuery {

    private static final Logger LOG = Logger.getLogger(SQL.class);
    SQL sql;

    public LoggedSQL() {
        this.sql = new SQL();
    }

    @Override
    public <T extends BaseDTO> List<T> select(String query, Class<T> clazz) {
        LOG.info("==========DB connected==========");
        return sql.select(query, clazz);
    }

    @Override
    public void update(String query) {
        LOG.info("==========DB connected==========");
        sql.update(query);
    }

    @Override
    public void delete(String query) {
        LOG.info("==========DB connected==========");
        sql.delete(query);
    }
}
