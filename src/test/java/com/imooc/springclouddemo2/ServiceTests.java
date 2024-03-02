package com.imooc.springclouddemo2;


import com.imooc.springclouddemo2.entity.*;
import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.*;

import javax.annotation.*;

import java.util.*;

@SpringBootTest
public class ServiceTests {

  @Resource
  private UserService userService;
  @Test
  public void testCount() {
    int count = userService.count(null);
    System.out.println("总记录数: " + count);
  }
  @Test
  public void testSaveBatch() {
    ArrayList<User> users = new ArrayList<>();
    for (int i = 0; i < 5; i++) {
      User user = new User();
      user.setName("Helen" + i);
      user.setAge(10 + i);
      users.add(user);
    }
    userService.saveBatch(users);
  }
}
