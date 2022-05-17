import Sql2o.Sql2oDepartmentDao;
import Sql2o.Sql2oNewsDao;
import Sql2o.Sql2oUserDao;
import com.google.gson.Gson;
import models.Department;
import models.News;
import models.User;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import response.ResponseArray;
import response.ResponseObject;

import java.util.Collections;
import java.util.List;

import static spark.Spark.*;

public class App {
    public static void main(String[] args) {
//        User Rachel = new User("Rachel", "about", "Author", "chef", 1);
//        Sql2oUserDao userDao = new Sql2oUserDao();
//        userDao.add(Rachel );
//        System.out.println(userDao.getAll());
////        System.out.println(userDao.update(3, "Namiba", "about us", "Writer", "cook", 3));
//        System.out.println(userDao.findById(2));
//        Department Modelling = new Department("Modelling", "model");
//        Sql2oDepartmentDao departmentDao = new Sql2oDepartmentDao();
//        departmentDao.add(Modelling);
//        System.out.println(departmentDao.getAll());
//        System.out.println(userDao.getAll());
//        System.out.println(departmentDao.findById(1));
//
//        News headlines = new News("politics","elections to be held soon", 2);
//        Sql2oNewsDao newsDao = new Sql2oNewsDao();
//        newsDao.add(headlines);
//        System.out.println(newsDao.getAll());
//        System.out.println(newsDao.findById(1));
//        newsDao.update(4, "trending", "men take skin care serious", 2);
//        System.out.println(newsDao.update(2, "trending", "skin care for women", 2);
//        System.out.println(newsDao.deleteById(2));

        String connect= "jdbc:postgresql://localhost:5432/my_news";
        Sql2o sql2o = new Sql2o(connect, "rachael", "cravings");
        Sql2oUserDao sql2oUserDao =new Sql2oUserDao();
        Connection conn = sql2o.open();

        //adding a new user
        post("add_user", (request,response)->{
            Gson gson = new Gson();
            User user = gson.fromJson(request.body(), User.class);
            sql2oUserDao.add(user);
            ResponseObject responseObject = new ResponseObject(201,"Success!");
            responseObject.setData(new Object());
            response.status(201);

            return gson.toJson(responseObject);
        });
//Route to get all users
        get("get_all_users", (request, response)-> {
            Gson gson = new Gson();
            List<User> list = sql2oUserDao.getAll();
            ResponseArray responseArray =  new ResponseArray(200,"success");
            responseArray.setData(Collections.singletonList(list));
            System.out.println(list.size());
            return gson.toJson(responseArray);

        });

    }

}
