import exceptions.ApiException;
import models.Department;
import models.News;
import sql2o.Sql2oDepartmentDao;
import sql2o.Sql2oNewsDao;
import sql2o.Sql2oUserDao;
import com.google.gson.Gson;
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

        Sql2oUserDao sql2oUserDao =new Sql2oUserDao();
        Sql2oNewsDao sql2oNewsDao = new Sql2oNewsDao();
        Sql2oDepartmentDao deptDao = new Sql2oDepartmentDao();
        Gson gson = new Gson();


//        //adding a new user
        post("/user/new", (request,response)->{
            User user = gson.fromJson(request.body(), User.class);
            sql2oUserDao.add(user);
            ResponseObject responseObject = new ResponseObject(201,"Success!");
            responseObject.setData(new Object());
            response.status(201);

            return gson.toJson(responseObject);
        });
//adding a new department
        post("/department/new", (request,response)->{
            Department department = gson.fromJson(request.body(), Department.class);
            deptDao.add(department);
            ResponseObject responseObject = new ResponseObject(201,"Success!");
            responseObject.setData(new Object());
            response.status(201);

            return gson.toJson(responseObject);
        });
//getting all departments
        get("/departments", "application/json", (req, res) -> { //accept a request in format JSON from an app
                    res.type("application/json");

                    System.out.println(deptDao.getAll());
                    return gson.toJson(deptDao.getAll());//send

                });

//finding a department by id
        get("/departments/:id", "application/json", (req, res) -> { //accept a request in format JSON from an app
            int departmentId = Integer.parseInt(req.params(":id"));
            res.type("application/json");

            System.out.println(deptDao.findById(departmentId));
            return gson.toJson(deptDao.findById(departmentId));//send

        });

//Route to get all users

        get("/get_all_users", (request, response)-> {
            List<User> list = sql2oUserDao.getAll();
            return gson.toJson(list);

        });

       //getting a new news
        post("/news/new", (request,response)->{
           News news = gson.fromJson(request.body(),News.class);
            sql2oNewsDao.add(news);
            ResponseObject responseObject = new ResponseObject(201,"Success!");
            responseObject.setData(new Object());
            response.status(201);

            return gson.toJson(news);
        });

        //getting all news
        get("/news", "application/json", (req, res) -> { //accept a request in format JSON from an app
            res.type("application/json");

            System.out.println(sql2oNewsDao.getAll());
            return gson.toJson(sql2oNewsDao.getAll());//send

        });

        //finding news by id
        get("/news/:id", "application/json", (req, res) -> { //accept a request in format JSON from an app
            res.type("application/json");

            System.out.println(sql2oNewsDao.findById(Integer.parseInt(req.params(":id"))));
            return gson.toJson(sql2oNewsDao.findById(Integer.parseInt(req.params(":id"))));//send

        });


    }

}
