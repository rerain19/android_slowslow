package com.rerain19.test;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.TabActivity;
import android.content.Intent;

import android.os.Bundle;

import android.widget.TabHost;


public class login_ok extends  TabActivity {
    private TabHost mTabHost;
     
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_ok);
         
        mTabHost = getTabHost();
         
        // �� 1, 2, 3 �� �߰��ϸ鼭 �±׸� �޾��ְ�, ����(�Ǵ� ������)�� �����Ѵ�.
        mTabHost.addTab(mTabHost.newTabSpec("tab1").setContent(R.id.tabs1).setIndicator("�޼����߼�"));
        mTabHost.addTab(mTabHost.newTabSpec("tab2").setContent(R.id.tabs2).setIndicator("�˻�"));
        
        mTabHost.addTab(mTabHost.newTabSpec("tab3").setContent(new Intent(login_ok.this, NMap.class)).setIndicator("�˻�"));
        //mTabHost.addTab(mTabHost.newTabSpec("tab3").setContent(R.id.tabs3).setIndicator("����"));
        mTabHost.addTab(mTabHost.newTabSpec("tab4").setContent(R.id.tabs4).setIndicator("������"));  
        
//        Intent intentNMapActivity = new Intent(login_ok.this, NMap.class);
//		startActivity(intentNMapActivity);
//		finish();
    }
}
