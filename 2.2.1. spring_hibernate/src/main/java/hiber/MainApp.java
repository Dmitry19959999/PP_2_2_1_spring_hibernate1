package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context =
              new AnnotationConfigApplicationContext(AppConfig.class);
      Car car = new Car("Mercedes", 600);
      Car car1 = new Car("BMW", 5);
      Car car2 = new Car("Lada", 10);
      Car car3 = new Car("Mazda", 3);
      UserService userService = context.getBean(UserService.class);
      userService.addUser(new User("Ivan", "Ivanov", "Ivanov@mail.ru", car));
      userService.addUser(new User("Petr", "Petrov", "Petrov@mail.ru", car1));
      userService.addUser(new User("Sidor", "Sidorov", "Sidorov@mail.ru", car2));
      userService.addUser(new User("Mihail", "Mihaiov", "Mihailov@mail.ru", car3));

      List<User> users = userService.getUsers();

      List<User> cars = userService.getUser("BMW", 5);
      for (User user : cars) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println();
      }
      context.close();
   }

}