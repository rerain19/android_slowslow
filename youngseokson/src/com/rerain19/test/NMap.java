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
        * ���� �� ��ü
        */
       NMapView mMapView;
       
       /*
        * ���� �̵��� ���� ����� ����
        */
       OnMapStateChangeListener onMapViewStateChangeListener;
       OnMapViewTouchEventListener onMapViewTouchEventListener;
       
       /*
        * ���� ��/�� ��� �� ���� �⺻��� 
        */
       NMapController mMapController;
       
 
       
       @Override    
       protected void onCreate(Bundle savedInstanceState) {
             super.onCreate(savedInstanceState);
//           setContentView(R.layout.activity_main);
             
             // create map view
             mMapView = new NMapView(this);
 
             // Ű ����
             mMapView.setApiKey("10d1bb03126f49b10b099c1f5e854d82");
 
             // ��� �ο�
             setContentView(mMapView);
 
             // initialize map view
             mMapView.setClickable(true);
 
             // ���� ��ȭ�� ���� �������
              mMapView.setOnMapStateChangeListener(onMapViewStateChangeListener);
              mMapView.setOnMapViewTouchEventListener(onMapViewTouchEventListener);
 
             // use map controller to zoom in/out, pan and set map center, zoom level etc.
             mMapController = mMapView.getMapController();
             
             
       }
       
       /*
        * ���� ����� ������ġ ��ǥ ���� �޼ҵ�
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
