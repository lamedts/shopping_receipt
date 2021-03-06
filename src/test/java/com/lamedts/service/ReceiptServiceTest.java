package com.lamedts.service;

import com.lamedts.Model.Cart;
import com.lamedts.Model.Summary;
import java.math.BigDecimal;
import java.util.List;
import org.junit.Test;

public class ReceiptServiceTest {

  ReceiptService receiptService = new ReceiptService();

  @Test
  public void printReceipt() {
    Cart cart =
        new Cart()
            .setProductList(
                List.of(
                    new Cart.Product()
                        .setQuantity(10)
                        .setProductName("Product")
                        .setPrice(BigDecimal.TEN),
                    new Cart.Product()
                        .setQuantity(10)
                        .setProductName("Product")
                        .setPrice(BigDecimal.TEN)));
    Summary summary =
        new Summary().setSubtotal(BigDecimal.TEN).setTax(BigDecimal.TEN).setTotal(BigDecimal.TEN);
    receiptService.printReceipt(cart, summary);
  }
}
