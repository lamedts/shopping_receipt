package com.lamedts.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import com.lamedts.Model.Cart;
import com.lamedts.Model.State;
import com.lamedts.Model.Summary;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.MockitoRule;

@RunWith(MockitoJUnitRunner.class)
public class CalculatorServiceTest {

  @InjectMocks CalculatorService calculatorService = new CalculatorService();

  @Mock CategoryService categoryService;

  @Mock StateService stateService;

  @Rule public MockitoRule initRule = MockitoJUnit.rule();

  @Before
  public void setup() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  public void calculate1() throws Exception {
    when(categoryService.getProductByCategory(any())).thenReturn(new ArrayList<>());
    when(stateService.getStateInformation(any()))
        .thenReturn(new State().setStateCode("XXZ").setTaxRate(BigDecimal.valueOf(0.5)));

    Cart cart =
        new Cart()
            .setStateCode("NY")
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
    Summary summary = calculatorService.calculate(cart);
    assertEquals(0, summary.getTax().compareTo(BigDecimal.valueOf(100)));
    assertEquals(0, summary.getSubtotal().compareTo(BigDecimal.valueOf(200)));
    assertEquals(0, summary.getTotal().compareTo(BigDecimal.valueOf(300)));
  }

  @Test
  public void calculate2() throws Exception {
    when(categoryService.getProductByCategory(any())).thenReturn(List.of("Product"));
    when(stateService.getStateInformation(any()))
        .thenReturn(new State().setStateCode("XXZ").setTaxRate(BigDecimal.valueOf(0.5)));

    Cart cart =
        new Cart()
            .setStateCode("NY")
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
    Summary summary = calculatorService.calculate(cart);
    assertEquals(0, summary.getTax().compareTo(BigDecimal.valueOf(0)));
    assertEquals(0, summary.getSubtotal().compareTo(BigDecimal.valueOf(200)));
    assertEquals(0, summary.getTotal().compareTo(BigDecimal.valueOf(200)));
  }

  @Test
  public void round1() {
    BigDecimal rounded1 =
        CalculatorService.roundUp(BigDecimal.valueOf(123.456), BigDecimal.valueOf(0.05));
    assertEquals(0, BigDecimal.valueOf(123.50).compareTo(rounded1));
  }

  @Test
  public void round2() {
    BigDecimal rounded2 =
        CalculatorService.roundUp(BigDecimal.valueOf(123.123), BigDecimal.valueOf(0.05));
    assertEquals(0, BigDecimal.valueOf(123.15).compareTo(rounded2));
  }

  @Test
  public void round3() {
    BigDecimal rounded3 =
        CalculatorService.roundUp(BigDecimal.valueOf(123.999), BigDecimal.valueOf(0.05));
    assertEquals(0, BigDecimal.valueOf(124).compareTo(rounded3));
  }
}
