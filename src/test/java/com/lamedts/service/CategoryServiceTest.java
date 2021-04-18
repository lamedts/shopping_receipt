package com.lamedts.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

public class CategoryServiceTest {

  CategoryService categoryService = new CategoryService();

  @Test
  public void testGetProductByCategory_categoryExists() throws Exception {
    List<String> items = categoryService.getProductByCategory(List.of("food"));
    assertTrue(items.size() > 0);
  }

  @Test
  public void testGetProductByCategory_categoryExists2() throws Exception {
    List<String> items = categoryService.getProductByCategory(List.of("food", "clothing"));
    assertTrue(items.size() > 0);
  }
}
