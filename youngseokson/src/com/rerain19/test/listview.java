package com.rerain19.test;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.app.ListActivity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class listview extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.listview);
        Button submitButton = (Button)this.findViewById(R.id.submit_btn);
        
        submitButton.setOnClickListener(new Button.OnClickListener(){ 
             public void onClick(View v)  {  
                    new ReadJSONFeed().execute("http://rerain19.nanuminet.co.kr/android_board.php");                
             }
        });
    }
      
    private class ReadJSONFeed extends AsyncTask<String, String, String> {
    	protected void onPreExecute() {}

        @Override
        protected String doInBackground(String... urls) {
        	HttpClient httpclient = new DefaultHttpClient(); 
        	StringBuilder builder = new StringBuilder();
            HttpPost httppost = new HttpPost(urls[0]); 
           
            try { 
            	HttpResponse response = httpclient.execute(httppost); 
            	StatusLine statusLine = response.getStatusLine();
            	int statusCode = statusLine.getStatusCode();
            	
            	if (statusCode == 200) {
            		HttpEntity entity = response.getEntity();
            		InputStream content = entity.getContent();
            		BufferedReader reader = new BufferedReader(new InputStreamReader(content));
            		String line;
            		
            		while ((line = reader.readLine()) != null) {
            			builder.append(line);
            			 
            		}
            	} 
            } catch (Exception e) {
            	e.printStackTrace();
            }
            
           	return builder.toString();
        }

        protected void onPostExecute(String result) {
            String state="";
            String values = "";
            String stateInfo="";
            EditText stateName = (EditText) findViewById(R.id.state_name);
            String searchState=stateName.getText().toString();
            
            ListView list = (ListView)findViewById(R.id.list);
            try{
             JSONArray	countriesArray = new JSONArray(result);
             
                   for (int i =0 ; i<countriesArray.length();i++) {
                      JSONObject jObject = countriesArray.getJSONObject(i);
                      state = jObject.getString("idx"); 
                      if(searchState.equalsIgnoreCase(state))
                      {
                          stateInfo+="idx: "+jObject.getString("idx")+"\n"; 
                          stateInfo+="title: "+jObject.getString("title")+"\n";
                      }
//                      ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, stateInfo);
  //                    list.setAdapter(adapter);
                      
          		   ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, values);
          		  list.setAdapter(adapter);
                      
                   }
            }catch (JSONException e) { 
                 e.printStackTrace(); 
            } 
            
            TextView resp = (TextView) findViewById(R.id.response);
            
//            if(stateInfo.trim().length() >0 )
//            	resp.setText(stateInfo);    
//            else
//                resp.setText("Sorry no match found");
            
        }
    }
}