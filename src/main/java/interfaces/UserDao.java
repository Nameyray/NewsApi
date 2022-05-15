package interfaces;

import models.User;

import java.util.List;

public interface UserDao {
    //CRUD
    //Create a user
    void add(User user);

    //Read or list all users
    List<User> getAll();

    //update a user
    void update (int id, String name, String bio, String position, String role, Integer departmentId);

    //finding a user by their id
    User findById(int id);

    //deleting a user
    void deleteById(int id);
    void deleteAll();
}
