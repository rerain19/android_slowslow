package com.rerain19.test;

import java.io.BufferedReader;
import java.io.Console;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.InputStreamEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;
import android.annotation.SuppressLint;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.view.Gravity;
import android.widget.Toast;

public class memberInsert extends AsyncTask<String,Void,String>{

   protected void onPreExecute(){
	   
   }
	@SuppressLint("ShowToast")
	@Override
	protected String doInBackground(String... arg0) {
		// TODO Auto-generated method stub
		InputStream is = null;
		String line = null;
		String result = null;
		int code;
		
		String email = (String)arg0[0];
        String pwd = (String)arg0[1];
       
        Context context = null;
    
		ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
		
		nameValuePairs.add(new BasicNameValuePair("email", email));
		nameValuePairs.add(new BasicNameValuePair("pwd", pwd));
		
		/* db와 연결수립 시작 */
		try{
			HttpClient httpClient = new DefaultHttpClient();
			HttpPost  httpPost = new HttpPost("http://rerain19.nanuminet.co.kr/insert.php");
			httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
			HttpResponse response = httpClient.execute(httpPost);
			HttpEntity entity = response.getEntity();
			
			is = entity.getContent();
			Log.e("pass 1" , "connection success");
		}catch(Exception e){
			Log.e("fial 1", e.toString());
			Toast.makeText(context, "Invailed ip address", Toast.LENGTH_LONG);
		}
		/* db와 연결수립 종료 */
		
		
		/* 입력받은 아이디, 비밀번호를 스트림에 넣음 시작*/
		try{
			BufferedReader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"), 8);
			StringBuilder sb = new StringBuilder();
			
			while( (line = reader.readLine()) != null){
				sb.append(line + "\n");
			}
			is.close();
		
			Log.e("pass 2", "connection success");
		}catch(Exception e){
			Log.e("fatal 2", e.toString());
		}
		//result = "email=" + email + " " + " pwd = " + pwd;
		return result;
		/* 입력받은 아이디, 비밀번호를 스트림에 넣음 종료*/
	}
}