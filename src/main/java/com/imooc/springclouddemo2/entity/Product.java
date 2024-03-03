package com.imooc.springclouddemo2.entity;


import lombok.*;

@Data
public class Product {
  private Long id;
  private String name;
  private Integer price;
  private Integer version;
}

