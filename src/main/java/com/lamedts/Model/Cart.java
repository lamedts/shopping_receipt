package com.lamedts.Model;

import java.math.BigDecimal;
import java.util.List;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Cart {
  List<Product> productList;
  String stateCode;

  @Data
  @Accessors(chain = true)
  public static class Product {
    String productName;
    BigDecimal price;
    Integer quantity;
  }
}
