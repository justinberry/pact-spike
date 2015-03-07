package hojusalam.pactspike;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;

import hojusalam.pactspike.http.BasicHttpRequest;


public class MainActivity extends ActionBarActivity {

  private static final String PACKAGE = MainActivity.class.getPackage().toString();

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    AsyncTask.execute(new Runnable() {
      @Override
      public void run() {
        BasicHttpRequest basicHttpRequest = new BasicHttpRequest();
        Log.d(PACKAGE, "Stuff:" +  basicHttpRequest.get("http://www.google.com"));
      }
    });
  }
}
