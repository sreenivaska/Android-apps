package com.enlume.lifecycle;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
public class LifeCycleActivity extends Activity {
String tag = "Events";
/** Called when the activity is first created. */
@Override
public void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
setContentView(R.layout.main);
Log.d(tag, "In the onCreate() event");
}
public void onStart()
{
super.onStart();
Log.d(tag, "In the onStart() event");
}
public void onRestart()
{
super.onRestart();
Log.d(tag, "In the onRestart() event");
}
public void onResume()
{
super.onResume();
Log.d(tag, "In the onResume() event");
}
public void onPause()
{
super.onPause();
Log.d(tag, "In the onPause() event");
}
public void onStop()
{
super.onStop();
Log.d(tag, "In the onStop() event");
}
public void onDestroy()
{
super.onDestroy();
Log.d(tag, "In the onDestroy() event");
}
}