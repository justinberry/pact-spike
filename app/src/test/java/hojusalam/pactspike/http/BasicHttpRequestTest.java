package hojusalam.pactspike.http;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;

@RunWith(RobolectricTestRunner.class)
public class BasicHttpRequestTest {

  private BasicHttpRequest basicHttpRequest;

  @Before
  public void setUp() {
    Robolectric.getFakeHttpLayer().interceptHttpRequests(false);

    basicHttpRequest = new BasicHttpRequest();
  }

  @Test
  public void testGet() throws Exception {
    basicHttpRequest.get("http://localhost:8080");
  }
}