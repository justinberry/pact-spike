package hojusalam.pactspike.http;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.IOException;

import hojusalam.pactspike.util.StreamReader;

public class BasicHttpRequest {

  public String get(String url) {

    DefaultHttpClient httpClient = new DefaultHttpClient();

    HttpGet httpGet = new HttpGet(url);

    HttpResponse httpResponse;
    try {
      httpResponse = httpClient.execute(httpGet);
      return StreamReader.readStream(httpResponse.getEntity().getContent());
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}
