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
	   Toast toast = Toast.makeText(context, "어씽크 들어옴", Toast.LENGTH_LONG);
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
            
            //URL 객체를 생성후에 url 주소값을 담는다.
//            URL url = new URL(link);
            
            //HttpClient 클래스를 통해 데이터를 보내기 위해 DeafultHttpClient 로 인스턴스 생성
            HttpClient client = new DefaultHttpClient();
            
            //Get 으로 보낼때 사용. POST 는 HttpPost
            HttpGet request = new HttpGet();
            
            //Get으로 보낼 url 주소를 설정한다.
            request.setURI(new URI(link));
            
            //링크 주소를 실행하고 결과를 반환 받는다.
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
		   Toast toast = Toast.makeText(context, "로그인성공", Toast.LENGTH_LONG);
		   toast.setGravity(Gravity.CENTER, 0, 0);
		   toast.show();
	   
		   this.statusField.setText("로그인성공");

			Intent login_ok = new Intent(context, login_ok.class);
			//startActivity(login_ok);
			//finish();
			context.startActivity(login_ok);
			((Activity)context).finish();

//		   context.startActivity(new Intent(context, login_ok.class));
	   }else{
		   
		   Toast toast = Toast.makeText(context, "로그인실패", Toast.LENGTH_LONG);
		   toast.setGravity(Gravity.CENTER, 0, 0);
		   toast.show();
	   
		   this.statusField.setText("아이디와 비밀번호를 확인해주십시요.");
		}
   }
}