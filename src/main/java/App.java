import Sql2o.Sql2oUserDao;
import models.User;

public class App {
    public static void main(String[] args) {
        User Rachel = new User("Rachel", "about", "Author", "chef", 1);
        Sql2oUserDao userDao = new Sql2oUserDao();
        userDao.add(Rachel );
        System.out.println(userDao.getAll());
//        System.out.println(userDao.update(3, "Namiba", "about us", "Writer", "cook", 3));
        System.out.println(userDao.findById(2));
    }

}
