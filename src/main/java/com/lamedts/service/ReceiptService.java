package com.lamedts.service;

import com.lamedts.Model.Cart;
import com.lamedts.Model.Summary;

public class ReceiptService {

  public void printReceipt(Cart cart, Summary summary) {
    System.out.println(String.format("%1$-20s %2$15s %3$15s\n", "item", "price", "qty"));
    cart.getProductList()
        .forEach(
            product -> {
              String line =
                  String.format(
                      "%1$-20s %2$15.2f %3$15d",
                      product.getProductName(), product.getPrice(), product.getQuantity());
              System.out.println(line);
            });
    System.out.println(
        String.format("%1$-20s %2$15s %3$15.2f", "subtotal", "", summary.getSubtotal()));
    System.out.println(String.format("%1$-20s %2$15s %3$15.2f", "tax", "", summary.getTax()));
    System.out.println(String.format("%1$-20s %2$15s %3$15.2f", "total", "", summary.getTotal()));
  }
}
