package com.lamedts.service;

import com.lamedts.Model.Cart;
import com.lamedts.Model.State;
import com.lamedts.Model.Summary;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class CalculatorService {

  CategoryService categoryService = new CategoryService();

  StateService stateService = new StateService();

  public Summary calculate(Cart cart) throws Exception {
    Summary summary = new Summary();
    BigDecimal tax;
    BigDecimal subtotal;
    State state = stateService.getStateInformation(cart.getStateCode());
    List<String> exemptItems = categoryService.getProductByCategory(state.getExempt());

    subtotal =
        cart.getProductList().stream()
            .map(product -> product.getPrice().multiply(BigDecimal.valueOf(product.getQuantity())))
            .reduce(BigDecimal.ZERO, BigDecimal::add);

    tax =
        cart.getProductList().stream()
            .map(
                product -> {
                  if (exemptItems.contains(product.getProductName().trim())) {
                    return BigDecimal.ZERO;
                  }
                  BigDecimal saleTax =
                      product
                          .getPrice()
                          .multiply(
                              BigDecimal.valueOf(product.getQuantity())
                                  .multiply(state.getTaxRate()));
                  return round(saleTax, BigDecimal.valueOf(0.05), RoundingMode.UP);
                })
            .reduce(BigDecimal.ZERO, BigDecimal::add);

    return summary.setSubtotal(subtotal).setTax(tax).setTotal(tax.add(subtotal));
  }

  public static BigDecimal round(
      BigDecimal value, BigDecimal increment, RoundingMode roundingMode) {
    if (increment.signum() == 0) {
      // 0 increment does not make much sense, but prevent division by 0
      return value;
    } else {
      BigDecimal divided = value.divide(increment, 0, roundingMode);
      return divided.multiply(increment);
    }
  }
}
