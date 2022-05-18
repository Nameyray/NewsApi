package sql2o;

import interfaces.DepartmentDao;
import models.Department;
import models.News;
import models.User;
import org.sql2o.Connection;
import org.sql2o.Sql2oException;

import java.util.List;

public class Sql2oDepartmentDao implements DepartmentDao {
    @Override
    public void add(Department department) {
        String query = "INSERT INTO departments(name ,bio) values(:name, :bio)";
        try (Connection conn = DB.connect.open()) {
            int id = (int) conn.createQuery(query, true)
                    .bind(department)
                    .executeUpdate()
                    .getKey();
            department.setId(id);

        } catch (Sql2oException e) {
            System.out.println(e.getMessage());
        }

    }
//method to list all departments
    @Override
    public List<Department> getAll() {
        try (Connection conn = DB.connect.open()) {
            String getAllDepartments = "SELECT * FROM departments";
            return conn.createQuery(getAllDepartments)
                    .executeAndFetch(Department.class);
        }
    }
//method to list all users in a department
    @Override
    public List<User> getDepartmentUsers(Department department) {
        try (Connection conn = DB.connect.open()) {
            String getAllUsers = "SELECT * FROM users WHERE departmentId= :id";
            return conn.createQuery(getAllUsers)
                    .addParameter("id",department.getId())
                    .executeAndFetch(User.class);
        }

    }
//method to get department news
    @Override
    public List<News> getDepartmentNews(Department department) {
        try (Connection conn = DB.connect.open()) {
            String getAllNews = "SELECT * FROM news WHERE departmentId= :id";
            return conn.createQuery(getAllNews)
                    .addParameter("id",department.getId())
                    .executeAndFetch(News.class);
        }
    }

    @Override
    public Department findById(int id) {
        try (Connection conn = DB.connect.open()) {
            return conn.createQuery("SELECT * FROM departments WHERE id= :id")
                    .addParameter("id", id)
                    .executeAndFetchFirst(Department.class);//fetch an individual or single department
        }

    }

    @Override
    public void update(int id, String name, String bio) {
        String query = "UPDATE users SET (name, bio) = (:name , :bio) WHERE id=:id";
        try (Connection conn = DB.connect.open()) {
            conn.createQuery(query)
                    .addParameter("name", name)
                    .addParameter("bio", bio)
                    .addParameter("id", id)
                    .executeUpdate();

        } catch (Sql2oException e) {
            System.out.println(e.getMessage());
        }

    }
//deletes a department by id
    @Override
    public void deleteById(int id) {
        String query = "DELETE FROM departments WHERE id=:id";
        try (Connection con = DB.connect.open()) {
            con.createQuery(query)
                    .addParameter("id", id)
                    .executeUpdate();
        } catch (Sql2oException e) {
            System.out.println(e.getMessage());
        }

    }
//method to delete all departments
    @Override
    public void clearAll() {
        String query = "DELETE FROM departments";
        try (Connection con = DB.connect.open()) {
            con.createQuery(query)
                    .executeUpdate();

        } catch (Sql2oException e) {
            System.out.println(e.getMessage());
        }

    }
}
