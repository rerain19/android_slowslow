package com.rerain19.test;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class listviewProc  extends AsyncTask<String,Void,String>{

//	   private TextView statusField,roleField;
//	   private Context context;
//	   private int byGetOrPost = 0; 
	   //flag 0 means get and 1 means post.(By default it is get.)
	  
	   protected void onPreExecute(){
		   /*
		   Toast toast = Toast.makeText(context, "어씽크 들어옴", Toast.LENGTH_LONG);
		   toast.setGravity(Gravity.CENTER, 0, 0);
		   toast.show();
		   */
		   
		   
	   }
	   @Override
	   protected String doInBackground(String... arg0) {
//		   HttpClient httpclient = new DefaultHttpClient(); 
//       	StringBuilder builder = new StringBuilder();
//           HttpPost httppost = new HttpPost("http://rerain19.nanuminet.co.kr/android_board.php"); 
//          
//           try { 
//           	HttpResponse response = httpclient.execute(httppost); 
//           	StatusLine statusLine = response.getStatusLine();
//           	int statusCode = statusLine.getStatusCode();
//           	
//           	if (statusCode == 200) {
//           		HttpEntity entity = response.getEntity();
//           		InputStream content = entity.getContent();
//           		BufferedReader reader = new BufferedReader(new InputStreamReader(content));
//           		String line;
//           		
//           		while ((line = reader.readLine()) != null) {
//           			builder.append(line);
//           			 
//           		}
//           	} 
//           } catch (Exception e) {
//           	e.printStackTrace();
//           }
//           
//          	return builder.toString();
		   return "";
	   }
	   @Override
	   protected void onPostExecute(String result){
//		   if(result != ""){
//			   Toast toast = Toast.makeText(context, "로그인성공", Toast.LENGTH_LONG);
//			   toast.setGravity(Gravity.CENTER, 0, 0);
//			   toast.show();
//		   
//		   }else{
//			   
//			   Toast toast = Toast.makeText(context, "로그인실패", Toast.LENGTH_LONG);
//			   toast.setGravity(Gravity.CENTER, 0, 0);
//			   toast.show();
//		   
//			}   
		
//		   
//		   if(result != ""){
//			   Toast toast = Toast.makeText(context, result.toString(), Toast.LENGTH_LONG);
//			   toast.setGravity(Gravity.CENTER, 0, 0);
//			   toast.show();
//		   
//			  // this.statusField.setText("로그인성공");
//
////				Intent login_ok = new Intent(context, login_ok.class);
////				context.startActivity(login_ok);
////				((Activity)context).finish();
//		   }else{
//			   
//			   Toast toast = Toast.makeText(context, "로그인실패", Toast.LENGTH_LONG);
//			   toast.setGravity(Gravity.CENTER, 0, 0);
//			   toast.show();
//		   
//			   //this.statusField.setText("아이디와 비밀번호를 확인해주십시요.");
//			}
	   }
	}