package com.lamedts.service;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.math.RoundingMode;
import org.junit.jupiter.api.Test;

class CalculatorServiceTest {

  CalculatorService calculatorService = new CalculatorService();

  //  @Test
  //  void calculate() throws Exception {
  //    Cart cart =
  //            new Cart()
  //                    .setProductList(
  //                            List.of(
  //                                    new Cart.Product()
  //                                            .setQuantity(10)
  //                                            .setProductName("Product")
  //                                            .setPrice(BigDecimal.TEN),
  //                                    new Cart.Product()
  //                                            .setQuantity(10)
  //                                            .setProductName("Product")
  //                                            .setPrice(BigDecimal.TEN)));
  //    Summary summary = calculatorService.calculate(cart);
  //    assertNotNull(summary);
  //  }

  @Test
  void round1() {
    BigDecimal rounded1 =
        CalculatorService.round(
            BigDecimal.valueOf(123.456), BigDecimal.valueOf(0.05), RoundingMode.UP);
    assertEquals(0, BigDecimal.valueOf(123.50).compareTo(rounded1));
  }

  @Test
  void round2() {
    BigDecimal rounded2 =
        CalculatorService.round(
            BigDecimal.valueOf(123.123), BigDecimal.valueOf(0.05), RoundingMode.UP);
    assertEquals(0, BigDecimal.valueOf(123.15).compareTo(rounded2));
  }

  @Test
  void round3() {
    BigDecimal rounded3 =
        CalculatorService.round(
            BigDecimal.valueOf(123.999), BigDecimal.valueOf(0.05), RoundingMode.UP);
    assertEquals(0, BigDecimal.valueOf(124).compareTo(rounded3));
  }
}
