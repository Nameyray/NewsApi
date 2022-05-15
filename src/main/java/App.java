import Sql2o.Sql2oDepartmentDao;
import Sql2o.Sql2oNewsDao;
import Sql2o.Sql2oUserDao;
import models.Department;
import models.News;
import models.User;

public class App {
    public static void main(String[] args) {
        User Rachel = new User("Rachel", "about", "Author", "chef", 1);
        Sql2oUserDao userDao = new Sql2oUserDao();
        userDao.add(Rachel );
        System.out.println(userDao.getAll());
//        System.out.println(userDao.update(3, "Namiba", "about us", "Writer", "cook", 3));
        System.out.println(userDao.findById(2));
        Department Modelling = new Department("Modelling", "model");
        Sql2oDepartmentDao departmentDao = new Sql2oDepartmentDao();
        departmentDao.add(Modelling);
        System.out.println(departmentDao.getAll());
        System.out.println(userDao.getAll());
        System.out.println(departmentDao.findById(1));

        News headlines = new News("politics","elections to be held soon", 2);
        Sql2oNewsDao newsDao = new Sql2oNewsDao();
        newsDao.add(headlines);
        System.out.println(newsDao.getAll());
        System.out.println(newsDao.findById(1));
        newsDao.update(4, "trending", "men take skin care serious", 2);
//        System.out.println(newsDao.update(2, "trending", "skin care for women", 2);
//        System.out.println(newsDao.deleteById(2));
    }

}
