package com.rerain19.test;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
 
import com.nhn.android.maps.NMapActivity;
import com.nhn.android.maps.NMapController;
import com.nhn.android.maps.NMapView;
import com.nhn.android.maps.NMapView.OnMapStateChangeListener;
import com.nhn.android.maps.NMapView.OnMapViewTouchEventListener;
import com.nhn.android.maps.maplib.NGeoPoint;
import com.nhn.android.maps.nmapmodel.NMapError;
 
public class NMap extends NMapActivity {
 
       /*
        * 지도 뷰 객체
        */
       NMapView mMapView;
       
       /*
        * 지도 이동에 따라 사용할 변수
        */
       OnMapStateChangeListener onMapViewStateChangeListener;
       OnMapViewTouchEventListener onMapViewTouchEventListener;
       
       /*
        * 지도 줌/인 기능 등 여러 기본기능 
        */
       NMapController mMapController;
       
 
       
       @Override    
       protected void onCreate(Bundle savedInstanceState) {
             super.onCreate(savedInstanceState);
//           setContentView(R.layout.activity_main);
             
             // create map view
             mMapView = new NMapView(this);
 
             // 키 인증
             mMapView.setApiKey("10d1bb03126f49b10b099c1f5e854d82");
 
             // 기능 부여
             setContentView(mMapView);
 
             // initialize map view
             mMapView.setClickable(true);
 
             // 지도 변화에 따른 변경사항
              mMapView.setOnMapStateChangeListener(onMapViewStateChangeListener);
              mMapView.setOnMapViewTouchEventListener(onMapViewTouchEventListener);
 
             // use map controller to zoom in/out, pan and set map center, zoom level etc.
             mMapController = mMapView.getMapController();
             
             
       }
       
       /*
        * 지도 실행시 시작위치 좌표 지정 메소드
        */
       public void onMapInitHandler(NMapView mapView, NMapError errorInfo) {
             
        if (errorInfo == null) { // success
              
                mMapController.setMapCenter(new NGeoPoint(127.108099, 37.366034), 11);
                 
        } 
        else 
        { // fail
                     Log.e("error", "onMapInitHandler: error=" + errorInfo.toString());
        }
        
       }  
       
 
       @Override
       public boolean onCreateOptionsMenu(Menu menu) {
             // Inflate the menu; this adds items to the action bar if it is present.
             getMenuInflater().inflate(R.menu.main, menu);
             return true;
       }
 
}
