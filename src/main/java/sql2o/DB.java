package sql2o;

import org.sql2o.Sql2o;

public class DB {
    public static Sql2o connect = new Sql2o("jdbc:postgresql://localhost:5432/my_news","rachael", "cravings");
}
