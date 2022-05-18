package sql2o;

import models.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.sql2o.Connection;

import static org.junit.Assert.*;

public class Sql2oUserDaoTest {
    private Sql2oUserDao userDao;
    private Connection conn;

    @Before
    public void setUp() throws Exception {
        conn = DB.connect.open();
        userDao = new Sql2oUserDao();

    }

    @Test
    public void add_addsNewUser() {
        User Rachel = new User("Rachel", "about", "Author", "chef", 1);
        int id = Rachel.getId();
        userDao.add(Rachel);
        assertNotEquals(id,Rachel.getId());
    }

    @After
    public void tearDown() throws Exception {
        try(Connection conn = DB.connect.open()){
            String myQuery = "DELETE * FROM users";
            conn.createQuery(myQuery).executeUpdate();
        }
    }

}