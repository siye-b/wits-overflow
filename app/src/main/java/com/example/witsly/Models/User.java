package com.example.witsly.Models;

public class User {

  private String name, surname, email, bio = "";
  private Boolean admin;

  public User() {}

  public User(String name, String surname, String email) {
    this.name = name;
    this.surname = surname;
    this.email = email;
    this.bio = bio;

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

  public String getBio() { return bio; }

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

  public void setBio(String bio) { this.bio = bio; }
}
