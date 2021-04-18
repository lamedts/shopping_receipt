package com.lamedts.service;

import com.lamedts.Model.Cart;
import com.lamedts.Util;
import java.io.File;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReadInputService {

  public Cart getInputFromFile(String filename) throws Exception {
    String filenameWithPrefix = String.format("useCase/%s", filename);
    File inputFile = Util.readResourceFile(filenameWithPrefix);
    List<String> fileLines, inputs;
    Cart cart = new Cart();

    // validate the input
    try (Stream<String> stream = Files.lines(Paths.get(inputFile.getPath()))) {
      fileLines = stream.collect(Collectors.toList());
    }
    if (fileLines.size() != 1) {
      throw new Exception("Wrong input");
    }

    // retrieve information from input
    // 1. stateCode5
    inputs = Arrays.asList(fileLines.get(0).split(","));
    cart.setStateCode(Arrays.asList(inputs.get(0).split(":")).get(1).trim());
    // 2. product
    List<Cart.Product> products = new ArrayList<>();
    for (int i = 1; i < inputs.size(); i++) {
      String productElement = inputs.get(i);
      Cart.Product product = new Cart.Product();
      // get price
      List<String> productInfo = Arrays.asList(productElement.split(" at "));
      product.setPrice(new BigDecimal(productInfo.get(1).trim()));

      // get quantity and name
      Pattern regex2 = Pattern.compile("^(\\d+|\\s+\\d+)(.+)");
      Matcher matchedGroup2 = regex2.matcher(productInfo.get(0));

      if (matchedGroup2.find()) {
        product.setQuantity(Integer.parseInt(matchedGroup2.group(1).trim()));
        product.setProductName(matchedGroup2.group(2).trim());
      } else {
        throw new Exception("Cannot read input");
      }
      products.add(product);
    }

    cart.setProductList(products);
    return cart;
  }
}
