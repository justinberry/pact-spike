package hojusalam.pactspike.http;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;

import au.com.dius.pact.consumer.ConsumerPactBuilder;
import au.com.dius.pact.consumer.ConsumerPactTest;
import au.com.dius.pact.model.PactFragment;

@RunWith(RobolectricTestRunner.class)
public class BasicHttpServiceRequestTest extends ConsumerPactTest {

  private BasicHttpRequest basicHttpRequest;

  @Before
  public void setUp() {
    Robolectric.getFakeHttpLayer().interceptHttpRequests(false);
    basicHttpRequest = new BasicHttpRequest();
  }

  @Override
  protected PactFragment createFragment(ConsumerPactBuilder.PactDslWithProvider builder) {
    return builder.uponReceiving("A boring GET request")
            .path("/")
            .method("GET")

            .willRespondWith()
            .body("{\"message\":\"Hello world\"}")

            .toFragment();
  }

  @Override
  protected String providerName() {
    return "Some awesome provider";
  }

  @Override
  protected String consumerName() {
    return "Some kinda ok consumer";
  }

  @Override
  // Ask George/Ron about multiple tests in Java (and/or groovy)
  public void runTest(String url) {
    basicHttpRequest.get(url);
  }
}