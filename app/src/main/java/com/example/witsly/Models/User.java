package com.example.witsly.Models;

public class User {

  private String name, surname, email;
  private Boolean admin;
  // Don't remove this constructor
  public User() {}

  public User(String name, String surname, String email) {
    this.name = name;
    this.surname = surname;
    this.email = email;

    // it sets all new registered users as non admin by default
    admin = false;
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

  public boolean isAdmin() {
    return admin;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public void setAdmin(Boolean admin) {
    this.admin = admin;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setSurname(String surname) {
    this.surname = surname;
  }
}
