package com.example.witsly.Models;

public class Tag {
  String Tag, TagID;

  public Tag() {}

  public Tag(String tag, String tid) {
    this.Tag = tag;
    this.TagID = tid;
  }

  public Tag(String tag) {
    this.Tag = tag;
  }

  public void setTag(String tag) {
    Tag = tag;
  }

  public String getTag() {
    return Tag;
  }
}
