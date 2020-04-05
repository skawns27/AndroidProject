package com.jsn.Location_p;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView latitude_tv;
    TextView longtitude_tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        latitude_tv=findViewById(R.id.latitude);
        longtitude_tv=findViewById(R.id.longitude);
        Button search_loc=findViewById(R.id.search_loc);
        search_loc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startLocationService();
            }
        });
    }
    public void startLocationService(){
        LocationManager locationManager=(LocationManager)getSystemService(Context.LOCATION_SERVICE);

        try{
            Location location=locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
            if(location!=null){
                double latitude=location.getLatitude();
                double longitude=location.getLongitude();

                longtitude_tv.setText(Double.toString(longitude));
                latitude_tv.setText(Double.toString(latitude));
            }

            GPSListener gpsListener=new GPSListener();
            long minTime=10000;//10초
            float minDistance=0;
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,minTime,minDistance,gpsListener);
            Toast.makeText(this,"위치정보 조회 요청 중",Toast.LENGTH_LONG);

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    class GPSListener implements LocationListener{
        public void onLocationChanged(Location location){//위치정보 업데이트 시 리스너를 통해 받아옴
            double latitude=location.getLatitude();
            double longitude=location.getLongitude();
            longtitude_tv.setText(Double.toString(longitude));
            latitude_tv.setText(Double.toString(latitude));
        }
        public void onProviderDisabled(String provider){
            Toast.makeText(getApplicationContext(),"위치정보를 제공받을 수 없습니다",Toast.LENGTH_LONG);
        }
        public void onProviderEnabled(String provider){}
        public void onStatusChanged(String provider,int status, Bundle extra){}

    }
}
