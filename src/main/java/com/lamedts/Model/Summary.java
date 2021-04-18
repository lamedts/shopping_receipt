package com.lamedts.Model;

import java.math.BigDecimal;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Summary {
  BigDecimal subtotal;
  BigDecimal tax;
  BigDecimal total;
}
