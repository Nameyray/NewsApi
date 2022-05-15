package interfaces;

import models.News;

import java.util.List;

public interface NewsDao {
    //create
    void add(News news);

    //read
    List<News> getAll();

    // find by News ID
    News findById(int id);

    //update the News details
    void update(int id, String title, String content, int departmentId);

    //delete the news
    void deleteById(int id);
    void clearAll();
}
