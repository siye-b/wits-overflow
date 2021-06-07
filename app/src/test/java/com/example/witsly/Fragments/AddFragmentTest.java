package com.example.witsly.Fragments;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AddFragmentTest {
  private AddFragment mathDemo;

  @Before
  public void setUp() throws Exception {
    mathDemo = new AddFragment();
  }

  @Test
  public void testAdd() {
    int result = mathDemo.add(5, 3);
    Assert.assertEquals(result, 8);
  }
}
