package com.rerain19.test;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.regex.Pattern;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.DefaultClientConnection;
import org.apache.http.message.BasicNameValuePair;

import com.google.android.gcm.GCMRegistrar;
import com.rerain19.test.R;

import android.R.string;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.Spanned;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class JoinProc extends Activity{
	String email, pwd;
	InputStream is = null;
	
	private EditText input_email, input_pwd;
	private TextView status, role, method;
	private String result_flag = "fail";
	
	
	public InputFilter filterAlpha = new InputFilter() {
	    public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
	        Pattern ps = Pattern.compile("^[a-zA-Z]+$");
	            if (!ps.matcher(source).matches()) {
	                    return "";
	            } 
	        	return null;
	    } 
	}; 
	// 영문만 허용 (숫자 포함)
	public InputFilter filterAlphaNum = new InputFilter() {
		public CharSequence filter(CharSequence source, int start, int end,	Spanned dest, int dstart, int dend) {
			Pattern ps = Pattern.compile("^[a-zA-Z0-9]+$");
	
			if (!ps.matcher(source).matches()) {
				return "";
			}
			return null;
	        } 
	}; 

	// 한글만 허용
	public InputFilter filterKor = new InputFilter() {
		public CharSequence filter(CharSequence source, int start, int end,	Spanned dest, int dstart, int dend) {
			Pattern ps = Pattern.compile("^[ㄱ-가-힣]+$");
		
		    if (!ps.matcher(source).matches()) {
		            return "";
			} 
			return null;
		}
	}; 
	
	protected void onCreate(Bundle savedInstanceState) 	{

		super.onCreate(savedInstanceState);

		setContentView(R.layout.subactivity);
		
		Button BtnCalltoDupCheck = (Button)findViewById(R.id.dupCheck);
		Button BtnReg = (Button)findViewById(R.id.Reg);
		Button BtnCalltoMain = (Button)findViewById(R.id.cancel);
		
		input_email = (EditText)findViewById(R.id.EditEmail);
		input_email.setFilters(new InputFilter[] { filterAlphaNum});
		input_pwd = (EditText)findViewById(R.id.EditPwd);	
		
		status = (TextView)findViewById(R.id.textView6);
		role = (TextView)findViewById(R.id.textView7);
		method = (TextView)findViewById(R.id.textView9);
		
		input_email.requestFocus();
		
		final Context context = getApplicationContext();
		
		BtnCalltoMain.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Log.i("onClick", "CallMainActivity");
				finish();
			}
		});
		//이메일 중복확인
		BtnCalltoDupCheck.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String email = input_email.getText().toString();
				String password = input_pwd.getText().toString();
				String query_result;

				try{
					query_result = new IdCheckActivity(context, status, role, 0).execute(email, password).get();
					if(query_result != ""){
						//결과값이 있다. 생성하려는 아이디가 존재한다.
						//email.setEnabled(true);
						result_flag="fail";
					}else{
						//생성하려는 아이디가 없다. 사용한다면 email 항목을 disabled 한다
						//email.setEnabled(false);
						result_flag="pass";
					}
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		});
		
		//저장하기 버튼
		BtnReg.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				//아이디 중복확인 여부 체크
				if(input_email.length() < 1){
					Toast toast = Toast.makeText(getApplicationContext(), "아이디를 입력해 주십시요.", Toast.LENGTH_LONG);
					toast.setGravity(Gravity.CENTER, 0, 0);
					toast.show();
					return;
				}
				
				if(result_flag=="fail"){
					Toast toast = Toast.makeText(getApplicationContext(), "아이디 중복 확인을 해주십시요", Toast.LENGTH_LONG);
					toast.setGravity(Gravity.CENTER, 0, 0);
					toast.show();
					return;
				}
				
				if(input_pwd.length() < 4 || input_pwd.length() > 20){
					Toast toast = Toast.makeText(getApplicationContext(), "비밀번호는 4자 이상\n 20자 이하로 입력해주십시요.", Toast.LENGTH_LONG);
					toast.setGravity(Gravity.CENTER, 0, 0);
					toast.show();
				}
				
//				Toast toast = Toast.makeText(getApplicationContext(), "가입 되었습니다.", Toast.LENGTH_LONG);
//				toast.setGravity(Gravity.CENTER, 0, 0);
//				toast.show();
				email = input_email.getText().toString();
				pwd	  = input_pwd.getText().toString();
				
				try {
					//String db_insert_result = new memberInsert().execute(email, pwd).get();
					InsertData task1 = new InsertData();
					task1.execute(new String[]{"http://rerain19.nanuminet.co.kr/insert.php"});
					
//					Toast toast2 = Toast.makeText(context, "리턴값" + db_insert_result, Toast.LENGTH_LONG);
//					toast2.setGravity(Gravity.CENTER, 0, 0);
//					toast2.show();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					Log.e("db_insert_result", e.toString());
				}
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.

		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	private class InsertData extends AsyncTask<String, Void, Boolean>{
		ProgressDialog dialog = new ProgressDialog(JoinProc.this);
		
		@Override
		protected void onPreExecute() {
			// TODO Auto-generated method stub
			//super.onPreExecute();
			dialog.setMessage("Sending Data Modify..");
			dialog.show();
		}
		
		@Override
		protected Boolean doInBackground(String... urls) {
			// TODO Auto-generated method stub
			
			for(String url : urls){
				
				try{
					ArrayList<NameValuePair> paris = new ArrayList<NameValuePair>();
					paris.add(new BasicNameValuePair("email", email));
					paris.add(new BasicNameValuePair("pwd", pwd));
					
					HttpClient client = new DefaultHttpClient();
					HttpPost post = new HttpPost(url);
					post.setEntity(new UrlEncodedFormEntity(paris));
	
					HttpResponse response = client.execute(post);
				} catch(Exception e){
					Toast.makeText(JoinProc.this, e.toString(), Toast.LENGTH_LONG).show();
					return false;
				}
			}
			return true;
		}
		
		@Override
		protected void onPostExecute(Boolean result) {
			// TODO Auto-generated method stub
			//super.onPostExecute(result);
			if(result == true){
				Toast.makeText(JoinProc.this, "저장 되었습니다, 이클립스와 연동중입니다.", Toast.LENGTH_LONG).show();
				registerGcm();
			}else{
				Toast.makeText(JoinProc.this, "저장 실패", Toast.LENGTH_LONG).show();
			}
			
			dialog.dismiss();
		}
	}
	
	public void registerGcm(){
		GCMRegistrar.checkDevice(this);
		GCMRegistrar.checkManifest(this);
		
		final String regId = GCMRegistrar.getRegistrationId(this);
		
		if(regId.equals("")){
			GCMRegistrar.register(this, "307089596463");
		}else{
			Log.e("id", regId);
		}
	}
}
