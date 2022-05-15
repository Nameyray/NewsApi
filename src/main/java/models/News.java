package models;

import java.util.Objects;

public class News {
    private  int id;
    private  String title;
    private String content;
    private Integer departmentId;

    public News(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public News(String title, String content, Integer departmentId) {
        this.title = title;
        this.content = content;
        this.departmentId = departmentId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        News news = (News) o;
        return id == news.id && Objects.equals(title, news.title) && Objects.equals(content, news.content) && Objects.equals(departmentId, news.departmentId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, content, departmentId);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }
}
