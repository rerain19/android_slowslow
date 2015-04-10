package com.rerain19.test;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.Gravity;
import android.view.TextureView;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class login_ok extends Activity{

	private TextView welcomeUser;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.login_ok);
		
		welcomeUser = (TextView)findViewById(R.id.welcomeUser);
		
		welcomeUser.setText("´Ô ¾È³çÇÏ¼¼¿ä");
		
//		Toast toast = Toast.makeText(getApplicationContext(), "ÀÌµ¿¿Ï·á", Toast.LENGTH_LONG);
//		toast.setGravity(Gravity.CENTER, 0, 0);
//		toast.show();
		
//		Button fragmentOne = (Button)findViewById(R.id.msg);
//		Button fragmentTwo = (Button)findViewById(R.id.searchList);
//		
//		fragmentOne.setOnClickListener((OnClickListener) this);
	}
	
	@SuppressLint("NewApi")
	public void selectFlag(View view){
		Toast toast = Toast.makeText(getApplicationContext(), view.toString(), Toast.LENGTH_LONG);
		toast.setGravity(Gravity.CENTER, 0, 0);
		toast.show();		
		Fragment fr = null;
		
//		switch(view.getId()){
//			case R.id.msg :
//				fr = new FragmentOne();
//				break;
//			case R.id.searchList:
//				fr = new FragmentTwo();
//				break;
//		}
		if(view == findViewById(R.id.msg)){
			fr = new FragmentOne();
		}
		if(view == findViewById(R.id.searchList)){
			fr = new FragmentTwo();
		}		
		
		FragmentManager fm = getFragmentManager();
		FragmentTransaction fragmentTransaction = fm.beginTransaction();
		fragmentTransaction.replace(R.id.fragment_place, fr);
		fragmentTransaction.commit();
	}

	
}
