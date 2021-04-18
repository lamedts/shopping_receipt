package com.lamedts.Model;

import java.math.BigDecimal;
import java.util.List;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class State {
  String stateCode;
  String stateName;
  BigDecimal taxRate;
  List<String> exempt;
}
