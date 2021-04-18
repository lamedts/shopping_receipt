package com.lamedts.service;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class StateServiceTest {

  @Test
  public void getStateInformation_ok() throws Exception {
    StateService stateService = new StateService();
    assertNotNull(stateService.getStateInformation("NY"));
  }
}
