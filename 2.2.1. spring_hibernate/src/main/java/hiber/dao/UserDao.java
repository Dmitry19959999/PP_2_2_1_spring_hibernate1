package hiber.dao;

import hiber.model.User;

import java.util.List;

public interface UserDao {
   void addUser(User user);
   List<User> getlistUsers();
   List<User> getUser(String model, int series);
}