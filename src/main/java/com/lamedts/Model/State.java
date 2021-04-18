package com.lamedts.Model;

import java.math.BigDecimal;
import java.util.List;
import lombok.Data;

@Data
public class State {
  String stateCode;
  String stateName;
  BigDecimal taxRate;
  List<String> exempt;
}
