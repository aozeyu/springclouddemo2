package com.imooc.springclouddemo2;

import com.baomidou.mybatisplus.core.conditions.query.*;
import com.imooc.springclouddemo2.entity.*;
import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.*;

import javax.annotation.*;

import java.util.*;

@SpringBootTest
public class WrapperTest {

  @Resource
  private UserMapper userMapper;


  @Test
  public void test1() {
    QueryWrapper<User> queryWrapper = new QueryWrapper<>();
    queryWrapper.like("name", "n").between("age", 10, 20).isNotNull("email");
    List<User> users = userMapper.selectList(queryWrapper);
    users.forEach(System.out::println);
  }

  @Test
  public void test3() {
    QueryWrapper<User> queryWrapper = new QueryWrapper<>();
    queryWrapper.isNull("email");
    int result = userMapper.delete(queryWrapper);
    System.out.println("delete return count = " + result);
  }


  @Test
  public void test5() {
    QueryWrapper<User> queryWrapper = new QueryWrapper<>();
    queryWrapper.select("name","age");
    List<Map<String,Object>> maps = userMapper.selectMaps(queryWrapper);
    maps.forEach(System.out::println);
  }


  @Test
  public void test6() {
    QueryWrapper<User> queryWrapper = new QueryWrapper<>();
    queryWrapper.inSql("id","select id from user where id <= 3");

    List<Object> objects = userMapper.selectObjs(queryWrapper);
    objects.forEach(System.out::println);
  }
}
