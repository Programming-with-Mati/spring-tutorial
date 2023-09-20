package com.programmingwith.mati;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;

@SpringBootApplication
public class Main {

  public static void main(String[] args) throws ClassNotFoundException {
    Class.forName("com.mysql.cj.jdbc.Driver");
    SpringApplication.run(Main.class, args);
  }
}
