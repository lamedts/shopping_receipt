package com.lamedts.service;

import org.junit.Test;

public class ReadInputServiceTest {

  ReadInputService readInputService = new ReadInputService();

  @Test
  public void getInputFromFile() throws Exception {
    readInputService.getInputFromFile("useCase1.txt");
  }
}
