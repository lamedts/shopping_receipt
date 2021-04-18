package com.lamedts.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lamedts.Model.State;
import com.lamedts.Util;
import java.util.Map;

public class StateService {

  private final ObjectMapper objectMapper = new ObjectMapper();

  /**
   * @param stateCode
   * @return State
   * @throws Exception
   *     <p>get state information by reading the stateCode
   */
  public State getStateInformation(String stateCode) throws Exception {
    String stateJsonFileName = "state.json";
    Map<String, State> stateList =
        objectMapper.readValue(Util.readResourceFile(stateJsonFileName), new TypeReference<>() {});
    return stateList.get(stateCode);
  }
}
