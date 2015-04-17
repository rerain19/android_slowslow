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
         
        // 탭 1, 2, 3 을 추가하면서 태그를 달아주고, 제목(또는 아이콘)을 설정한다.
        mTabHost.addTab(mTabHost.newTabSpec("tab1").setContent(R.id.tabs1).setIndicator("메세지발송"));
        mTabHost.addTab(mTabHost.newTabSpec("tab2").setContent(R.id.tabs2).setIndicator("검색"));
        
        mTabHost.addTab(mTabHost.newTabSpec("tab3").setContent(new Intent(login_ok.this, NMap.class)).setIndicator("검색"));
        //mTabHost.addTab(mTabHost.newTabSpec("tab3").setContent(R.id.tabs3).setIndicator("지도"));
        mTabHost.addTab(mTabHost.newTabSpec("tab4").setContent(R.id.tabs4).setIndicator("갤러리"));  
        
//        Intent intentNMapActivity = new Intent(login_ok.this, NMap.class);
//		startActivity(intentNMapActivity);
//		finish();
    }
}
