package com.imooc.springclouddemo2;

import com.imooc.springclouddemo2.entity.*;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.*;

import java.util.*;

@SpringBootTest
class Springclouddemo2ApplicationTests {

  @Resource
  private UserMapper userMapper;

  @Test
  void contextLoads() {
  }


  @Test
  void testSelectList() {
    List<User> users = userMapper.selectList(null);
    users.forEach(System.out::println);
  }
}
