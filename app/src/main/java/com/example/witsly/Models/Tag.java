package com.example.witsly.Models;

import androidx.annotation.NonNull;

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

  public String getTagID(){return TagID;}

  public void setTagID(String TagID){this.TagID = TagID;}


  @Override
  public String toString() {
    return Tag;
  }
}
