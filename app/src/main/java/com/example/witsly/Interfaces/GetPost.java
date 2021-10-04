package com.example.witsly.Interfaces;

import com.example.witsly.Models.Post;
import com.example.witsly.Models.User;

public interface GetPost {
  void processResponse(Post post, User user);
}
