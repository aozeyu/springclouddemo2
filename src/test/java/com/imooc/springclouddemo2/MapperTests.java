package com.imooc.springclouddemo2;

import com.imooc.springclouddemo2.entity.*;
import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.*;

import javax.annotation.*;

import java.util.*;

@SpringBootTest
public class MapperTests {

  @Resource
  UserMapper userMapper;
  @Resource
  private ProductMapper productMapper;

  @Test
  public void testInsert() {
    User user = new User();
    user.setName("Helen");
    user.setAge(18);
    int result = userMapper.insert(user);
    System.out.println("影响的行数: " + result);
    System.out.println("id: " + user.getId());
  }

  @Test
  public void testSelect() {
    User user = userMapper.selectById(1);
    System.out.println(user);
    List<User> users = userMapper.selectBatchIds(Arrays.asList(1, 2, 3));
    users.forEach(System.out::println);
    Map<String, Object> map = new HashMap<>();
    map.put("name", "Helen");
    map.put("age", 18);
    List<User> users1 = userMapper.selectByMap(map);
    users1.forEach(System.out::println);
  }

  @Test
  public void testUpdate() {
    User user = new User();
    user.setId(1L);
    user.setAge(38);
    int result = userMapper.updateById(user);
    System.out.println("影响的行数: " + result);
  }

  @Test
  public void testDelete() {
    int result = userMapper.deleteById(5);
    System.out.println("影响的行数: " + result);
  }

  @Test
  public void testConUpdate() {
    Product p1 = productMapper.selectById(1L);
    Product p2 = productMapper.selectById(1L);
    p1.setPrice(p1.getPrice() + 50);
    int result1 = productMapper.updateById(p1);
    System.out.println("小李修改结果: " + result1);

    p2.setPrice(p2.getPrice() - 30);
    int result2 = productMapper.updateById(p2);
    System.out.println("小王修改结果: " + result2);

    Product p3 = productMapper.selectById(1L);
    System.out.println("最后的结果: " + p3.getPrice());
  }
}
