package models;

import java.util.Objects;

public class User {
    private int id;
    private String name;
    private String bio;
    private String position;
    private String role;
    private Integer departmentId;
//constructor with departmentId available
    public User(String name, String bio, String position, String role, Integer departmentId) {
        this.name = name;
        this.bio = bio;
        this.position = position;
        this.role = role;
        this.departmentId = departmentId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id && departmentId == user.departmentId && Objects.equals(name, user.name) && Objects.equals(bio, user.bio) && Objects.equals(position, user.position) && Objects.equals(role, user.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, bio, position, role, departmentId);
    }
//getters and setters for the user properties
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }
}
