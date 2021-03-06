package com.rerain19.test;

import java.util.concurrent.ExecutionException;

import com.rerain19.test.R;

import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.app.Activity;
import android.view.View.OnClickListener;
import android.content.Intent;

public class MainActivity extends Activity {
	
	private EditText usernameField, passwordField;
	private TextView status, role, method;
	private Button join;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		usernameField = (EditText)findViewById(R.id.editText1);
		passwordField = (EditText)findViewById(R.id.editText2);
		
		status = (TextView)findViewById(R.id.textView6);
		role = (TextView)findViewById(R.id.textView7);
		method = (TextView)findViewById(R.id.textView9);
		
		join = (Button)findViewById(R.id.join);
		
		join.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				Intent intentJoinActivity = new Intent(MainActivity.this, JoinProc.class);
				startActivity(intentJoinActivity);
			}
		});
	
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public void login(View view){
		String username = usernameField.getText().toString();
		String password = passwordField.getText().toString();
	
		method.setText("get Method");
		new LoginProc(this, status, role, 0).execute(username, password);		
	}
	
	public void loginPost(View view){
		String username = usernameField.getText().toString();
		String password = passwordField.getText().toString();
		
		method.setText("post Method");
		new LoginProc(this, status, role, 1).execute(username, password);
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
