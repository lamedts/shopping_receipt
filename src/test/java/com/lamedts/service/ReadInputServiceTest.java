package com.lamedts.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ReadInputServiceTest {

  ReadInputService readInputService = new ReadInputService();

  @Test
  void getInputFromFile() throws Exception {
    readInputService.getInputFromFile("useCase1.txt");
  }
}
