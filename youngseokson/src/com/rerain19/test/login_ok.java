package com.rerain19.test;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.TabActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.TextureView;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

public class login_ok extends TabActivity {
    private TabHost mTabHost;
     
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_ok);
         
        mTabHost = getTabHost();
         
        // 탭 1, 2, 3 을 추가하면서 태그를 달아주고, 제목(또는 아이콘)을 설정한다.
        mTabHost.addTab(mTabHost.newTabSpec("tab1").setContent(R.id.tabs1).setIndicator("Tab1"));
        mTabHost.addTab(mTabHost.newTabSpec("tab2").setContent(R.id.tabs2).setIndicator("Tab2"));
        mTabHost.addTab(mTabHost.newTabSpec("tab3").setContent(R.id.tabs3).setIndicator("Tab3"));
        mTabHost.addTab(mTabHost.newTabSpec("tab4").setContent(R.id.tabs4).setIndicator("Tab4"));        
    }
}
