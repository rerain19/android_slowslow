package com.rerain19.test;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.HTTP;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.sax.StartElementListener;
import android.util.Log;
import android.view.Gravity;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class SigninActivity  extends AsyncTask<String,Void,String>{

   private TextView statusField,roleField;
   private Context context;
   private int byGetOrPost = 0; 
   //flag 0 means get and 1 means post.(By default it is get.)
   public SigninActivity(Context context,TextView statusField,   TextView roleField,int flag) {
      this.context = context;
      this.statusField = statusField;
      this.roleField = roleField;
      byGetOrPost = flag;
   }

   protected void onPreExecute(){
	   /*
	   Toast toast = Toast.makeText(context, "���ũ ����", Toast.LENGTH_LONG);
	   toast.setGravity(Gravity.CENTER, 0, 0);
	   toast.show();
	   */
	   
	   
   }
   @Override
   protected String doInBackground(String... arg0) {
      if(byGetOrPost == 0){ //means by Get Method
         try{
            String email = (String)arg0[0];
            String pwd = (String)arg0[1];
            /*
            String link = "http://myphpmysqlweb.hostei.com/login.php?username="
            +username+"&password="+password;
            */
            String link = "http://rerain19.nanuminet.co.kr/index.php?email="
                    +email+"&pwd="+pwd;
            
            //URL ��ü�� �����Ŀ� url �ּҰ��� ��´�.
//            URL url = new URL(link);
            
            //HttpClient Ŭ������ ���� �����͸� ������ ���� DeafultHttpClient �� �ν��Ͻ� ����
            HttpClient client = new DefaultHttpClient();
            
            //Get ���� ������ ���. POST �� HttpPost
            HttpGet request = new HttpGet();
            
            //Get���� ���� url �ּҸ� �����Ѵ�.
            request.setURI(new URI(link));
            
            //��ũ �ּҸ� �����ϰ� ����� ��ȯ �޴´�.
            HttpResponse response = client.execute(request);
           
            BufferedReader in = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

           StringBuffer sb = new StringBuffer("");
           String line="";
           while ((line = in.readLine()) != null) {
              sb.append(line);
              break;
            }
            in.close();
            return sb.toString();
            
	      }catch(Exception e){
	         return new String("Exception: " + e.getMessage());
	      }
      }
      else{
         try{
            String username = (String)arg0[0];
            String password = (String)arg0[1];
            String link="http://myphpmysqlweb.hostei.com/loginpost.php";
            String data  = URLEncoder.encode("username", "UTF-8") 
            + "=" + URLEncoder.encode(username, "UTF-8");
            data += "&" + URLEncoder.encode("password", "UTF-8") 
            + "=" + URLEncoder.encode(password, "UTF-8");
            URL url = new URL(link);
            URLConnection conn = url.openConnection(); 
            conn.setDoOutput(true); 
            OutputStreamWriter wr = new OutputStreamWriter
            (conn.getOutputStream()); 
            wr.write( data ); 
            wr.flush(); 
            BufferedReader reader = new BufferedReader
            (new InputStreamReader(conn.getInputStream()));
            StringBuilder sb = new StringBuilder();
            String line = null;
            // Read Server Response
            while((line = reader.readLine()) != null){
               sb.append(line);
               break;
            }
            
            return sb.toString();
         }catch(Exception e){
            return new String("Exception: " + e.getMessage());
         }
      }
   }
   @Override
   protected void onPostExecute(String result){
	   
	   if(result != ""){
		   Toast toast = Toast.makeText(context, "�α��μ���", Toast.LENGTH_LONG);
		   toast.setGravity(Gravity.CENTER, 0, 0);
		   toast.show();
	   
		   this.statusField.setText("�α��μ���");

			Intent login_ok = new Intent(context, login_ok.class);
			//startActivity(login_ok);
			//finish();
			context.startActivity(login_ok);
			((Activity)context).finish();

//		   context.startActivity(new Intent(context, login_ok.class));
	   }else{
		   
		   Toast toast = Toast.makeText(context, "�α��ν���", Toast.LENGTH_LONG);
		   toast.setGravity(Gravity.CENTER, 0, 0);
		   toast.show();
	   
		   this.statusField.setText("���̵�� ��й�ȣ�� Ȯ�����ֽʽÿ�.");
		}
   }
}