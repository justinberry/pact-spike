package hojusalam.pactspike.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class StreamReader {

  public static String readStream(InputStream inputStream) {

    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

    StringBuilder stringBuilder = new StringBuilder();
    try {
      String next;
      while ((next = bufferedReader.readLine()) != null) {
        stringBuilder.append(next);
      }
    } catch (IOException e) {
      throw new RuntimeException(e);
    }

    return stringBuilder.toString();
  }
}
