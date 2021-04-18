package com.lamedts.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

public class StateServiceTest {

  @Test
  public void testGetStates() throws Exception {
    StateService stateService = new StateService();
    assertNotNull(stateService.getStateInformation("NY"));
  }
}
