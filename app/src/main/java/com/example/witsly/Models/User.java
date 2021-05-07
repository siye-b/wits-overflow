package com.example.witsly.Models;

public class User {

  public String name, surname, email;
  // Don't remove this constructor
  public User() {}

  public User(String name, String surname, String email) {
    this.name = name;
    this.surname = surname;
    this.email = email;
  }

  public String getEmail() {
    return email;
  }

  public String getSurname() {
    return surname;
  }

  public String getName() {
    return name;
  }
}
