package com.lamedts;

import java.io.File;
import java.net.URL;
import java.util.Optional;

public class Util {

  public static File readResourceFile(String filename) throws Exception {
    URL fileUrl =
        Optional.ofNullable(Util.class.getClassLoader().getResource(filename))
            .orElseThrow(() -> new Exception("App's setting is not set properly"));
    return new File(fileUrl.getFile());
  }
}
