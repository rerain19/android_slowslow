package com.rerain19.test;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

public class listview extends ListActivity {
	  public void onCreate(Bundle icicle) {
		    super.onCreate(icicle);
		    
		    
		    String[] values = new String[] { "Android", "iPhone", "WindowsMobile",
		        "Blackberry", "WebOS", "Ubuntu", "Windows7", "Max OS X",
		        "Linux", "OS/2","Android", "iPhone", "WindowsMobile",
		        "Blackberry", "WebOS", "Ubuntu", "Windows7", "Max OS X",
		        "Linux", "OS/2","Android", "iPhone", "WindowsMobile",
		        "Blackberry", "WebOS", "Ubuntu", "Windows7", "Max OS X",
		        "Linux", "OS/2" };
		    ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, values);
		    setListAdapter(adapter);
	  }
} 