package com.example.witsly.Interfaces;

public interface HandleLogin {
  // 1 wrong cred
  // 2 not registered
  // 3 not verify

  void processAuth(Integer response, String msg);
}
