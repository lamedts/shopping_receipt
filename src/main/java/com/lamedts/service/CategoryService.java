package com.lamedts.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lamedts.Util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class CategoryService {

  private final ObjectMapper objectMapper = new ObjectMapper();

  public List<String> getProductByCategory(List<String> categories) {
    return categories.stream()
        .map(
            ele -> {
              try {
                String categoryJsonFileName = String.format("%s.json", ele);
                String[] stringArray =
                    objectMapper.readValue(
                        Util.readResourceFile(categoryJsonFileName), String[].class);
                return Arrays.asList(stringArray);
              } catch (Exception e) {
                throw new RuntimeException();
              }
            })
        .flatMap(Collection::stream)
        .collect(Collectors.toList());
  }
}
