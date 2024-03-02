package com.imooc.springclouddemo2;

import com.imooc.springclouddemo2.entity.*;
import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.*;

import javax.annotation.*;

@SpringBootTest
public class MapperTests {

  @Resource
  UserMapper userMapper;

  @Test
  public void testInsert() {
    User user  = new User();
    user.setName("Helen");
    user.setAge(18);
    int result = userMapper.insert(user);
    System.out.println("影响的行数: " + result);
    System.out.println("id: " + user.getId());
  }
}
