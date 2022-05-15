package Sql2o;

import interfaces.UserDao;
import models.User;
import org.sql2o.Connection;
import org.sql2o.Sql2oException;

import java.util.List;

public class Sql2oUserDao implements UserDao {

    @Override
    public void add(User user) {
        String query = "INSERT INTO users(name,bio, position, role, departmentId) values(:name, :bio, :position, :role, :departmentId)";
        try (Connection conn = DB.connect.open()) {
            int id = (int) conn.createQuery(query, true)
                    .bind(user)
                    .executeUpdate()
                    .getKey();
            user.setId(id);

        } catch (Sql2oException e) {
            System.out.println(e.getMessage());
        }

    }
//getAll users method
    @Override
    public List<User> getAll() {
        try (Connection conn = DB.connect.open()) {
            String getAllUsers = "SELECT * FROM users";
            return conn.createQuery(getAllUsers)
                    .executeAndFetch(User.class);
        }
    }
//update method
    @Override
    public void update(int id, String name, String bio, String position, String role, Integer departmentId) {
        String query = "UPDATE users SET name = :name WHERE id=:id";
        try (Connection conn = DB.connect.open()) {
            conn.createQuery(query)
                    .addParameter("name", name)
                    .addParameter("bio", bio)
                    .addParameter("position", position)
                    .addParameter("role", role)
                    .addParameter("departmentId", departmentId)
                    .addParameter("id", id)
                    .executeUpdate();

        } catch (Sql2oException e) {
            System.out.println(e.getMessage());
        }
    }


    @Override
    public User findById(int id) {
        try (Connection conn = DB.connect.open()) {
            return conn.createQuery("SELECT * FROM users WHERE id= :id")
                    .addParameter("id", id)
                    .executeAndFetchFirst(User.class);//fetch an individual or single user
        }
    }

    @Override
    public void deleteById(int id) {
        String query = "DELETE FROM users WHERE id=:id";
        try (Connection con = DB.connect.open()) {
            con.createQuery(query)
                    .addParameter("id", id)
                    .executeUpdate();
        } catch (Sql2oException e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void deleteAll() {
        String query = "DELETE FROM users";
        try (Connection con = DB.connect.open()) {
            con.createQuery(query)
                    .executeUpdate();

        } catch (Sql2oException e) {
            System.out.println(e.getMessage());
        }
    }
}
