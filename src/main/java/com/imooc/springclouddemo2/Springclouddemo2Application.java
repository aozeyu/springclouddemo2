package com.imooc.springclouddemo2;

import org.mybatis.spring.annotation.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan
public class Springclouddemo2Application {

  public static void main(String[] args) {
    SpringApplication.run(Springclouddemo2Application.class, args);
  }

}
