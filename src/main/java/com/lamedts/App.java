package com.lamedts;

import com.lamedts.Model.Cart;
import com.lamedts.service.CalculatorService;
import com.lamedts.service.ReadInputService;
import com.lamedts.service.ReceiptService;

public class App {
  public static void main(String[] args) throws Exception {
    ReadInputService readInputService = new ReadInputService();
    CalculatorService calculatorService = new CalculatorService();
    ReceiptService receiptService = new ReceiptService();

    Cart cart1 = readInputService.getInputFromFile("useCase1.txt");
    receiptService.printReceipt(cart1, calculatorService.calculate(cart1));
  }
}
