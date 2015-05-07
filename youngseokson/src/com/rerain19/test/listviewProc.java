package com.rerain19.test;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class listviewProc extends ListActivity {
		TextView content;
	  public void onCreate(Bundle savedInstanceState) {
		  
		    super.onCreate(savedInstanceState);
		    setContentView(R.layout.listviewproc);
		    
		    content = (TextView)findViewById(R.id.output);
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

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
		
		int itemPosotion = position;
		
		String itemValue = (String)l.getItemAtPosition(position);
		content.setText("click :\n position :" + itemPosotion + "\n Listitem : " + itemValue);
	}
	
	
	
} 
