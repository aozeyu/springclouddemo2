package com.imooc.springclouddemo2.entity;


import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.plugins.*;
import com.baomidou.mybatisplus.extension.plugins.inner.*;
import lombok.*;
import org.springframework.context.annotation.*;

@Data
public class Product {
  private Long id;
  private String name;
  private Integer price;
  @Version
  private Integer version;


  @Bean
  public MybatisPlusInterceptor mybatisPlusInterceptor()
  {
    MybatisPlusInterceptor mybatisPlusInterceptor = new MybatisPlusInterceptor();
    //分页插件
    mybatisPlusInterceptor.addInnerInterceptor(new PaginationInnerInterceptor());
    //乐观锁插件
    mybatisPlusInterceptor.addInnerInterceptor(new OptimisticLockerInnerInterceptor());
    return mybatisPlusInterceptor;
  }
}

