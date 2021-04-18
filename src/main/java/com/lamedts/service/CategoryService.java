package com.lamedts.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lamedts.Util;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class CategoryService {

  private final ObjectMapper objectMapper = new ObjectMapper();

  public List<String> getProductByCategory(List<String> categories) {
    return categories.stream()
        .map(
            ele -> {
              List<String> exemptProduct;
              try {
                String categoryJsonFileName = String.format("%s.json", ele);
                exemptProduct =
                    objectMapper.readValue(
                        Util.readResourceFile(categoryJsonFileName), new TypeReference<>() {});
              } catch (Exception e) {
                throw new RuntimeException();
              }
              return exemptProduct;
            })
        .flatMap(Collection::stream)
        .collect(Collectors.toList());
  }
}
