package sql2o;

import interfaces.NewsDao;
import models.News;
import org.sql2o.Connection;
import org.sql2o.Sql2oException;

import java.util.List;

public class Sql2oNewsDao implements NewsDao {
    @Override
    public void add(News news) {
        String query = "INSERT INTO news(title ,content, departmentId) values(:title, :content, :departmentId)";
        try (Connection conn = DB.connect.open()) {
            int id = (int) conn.createQuery(query, true)
                    .bind(news)
                    .executeUpdate()
                    .getKey();
            news.setId(id);

        } catch (Sql2oException e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public List<News> getAll() {
        try (Connection conn = DB.connect.open()) {
            String getAllNews = "SELECT * FROM news";
            return conn.createQuery(getAllNews)
                    .executeAndFetch(News.class);
        }
    }

    @Override
    public News findById(int id) {
        try (Connection conn = DB.connect.open()) {
            return conn.createQuery("SELECT * FROM news WHERE id= :id")
                    .addParameter("id", id)
                    .executeAndFetchFirst(News.class);//fetch single news
        }
    }

    @Override
    public void update(int id, String title, String content, int departmentId) {
        String query = "UPDATE news SET (title, content, departmentId) = (:title,:content, :departmentId)WHERE id= ;id";
        try (Connection conn = DB.connect.open()) {
            conn.createQuery(query)
                    .addParameter("title", title)
                    .addParameter("content", content)
                    .addParameter("departmentId", departmentId)
                    .addParameter("id", id)
                    .executeUpdate();

        } catch (Sql2oException e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void deleteById(int id) {
        String query = "DELETE FROM newss WHERE id=:id";
        try (Connection con = DB.connect.open()) {
            con.createQuery(query)
                    .addParameter("id", id)
                    .executeUpdate();
        } catch (Sql2oException e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void clearAll() {
        String query = "DELETE FROM news";
        try (Connection con = DB.connect.open()) {
            con.createQuery(query)
                    .executeUpdate();

        } catch (Sql2oException e) {
            System.out.println(e.getMessage());
        }

    }
}
