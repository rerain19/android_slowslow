package com.rerain19.test;

import android.os.Bundle;
import android.util.Log;

import com.nhn.android.maps.NMapActivity;
import com.nhn.android.maps.NMapController;
import com.nhn.android.maps.NMapView;
import com.nhn.android.maps.NMapView.OnMapStateChangeListener;
import com.nhn.android.maps.NMapView.OnMapViewTouchEventListener;
import com.nhn.android.maps.maplib.NGeoPoint;
import com.nhn.android.maps.nmapmodel.NMapError;

public abstract class NMap extends NMapActivity implements OnMapStateChangeListener, OnMapViewTouchEventListener{

	private OnMapStateChangeListener onMapViewStateChangeListener;
	private OnMapViewTouchEventListener onMapViewTouchEventListener;
	private NMapController mMapController;

	public static final String API_KEY="10d1bb03126f49b10b099c1f5e854d82";
	
	@Override
	protected void onCreate(Bundle arg0) {
		// TODO Auto-generated method stub
		super.onCreate(arg0);
		
		
//		NMapView mMapView = null;
//		mMapView = new NMapView(this);
//		
//		mMapView.setApiKey(API_KEY);
//		
//		setContentView(mMapView);
//		
//		mMapView.setClickable(true);
//		
//		mMapView.setOnMapStateChangeListener(onMapViewStateChangeListener);
//		mMapView.setOnMapViewTouchEventListener(onMapViewTouchEventListener);
//		
//		mMapController = mMapView.getMapController();
	}
	
//	public void onMapInitHandler(NMapView mapView, NMapError errorInfo) {       
//		if (errorInfo == null) { // success               
//			mMapController.setMapCenter(new NGeoPoint(126.978371, 37.5666091), 11);
//			} else { 
//				// fail               
//				Log.e("ERROR:", "onMapInitHandler: error=" + errorInfo.toString()); 
//				}
//
//	}
}
