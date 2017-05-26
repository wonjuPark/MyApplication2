package com.example.com.myapplication;

import android.location.LocationManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageButton;
import android.view.View;
import android.content.Intent;
import android.widget.TextView;

import com.example.com.utility.GPSManager;

public class MainActivity extends AppCompatActivity {
    LocationManager locationManager;
    TextView te;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        te = (TextView)findViewById(R.id.location);
        findViewById(R.id.set).setOnClickListener(mClickListener);
        findViewById(R.id.gps).setOnClickListener(mClickListener1);
        //locationManager = (LocationManager)getSystemService(LOCATION_SERVICE);
    }
    ImageButton.OnClickListener mClickListener = new View.OnClickListener() {
        public void onClick(View v) {
            Intent intent=(new Intent(MainActivity.this,SettingActivity.class));
            startActivity(intent);
        }
    };

    Button.OnClickListener mClickListener1 = new View.OnClickListener(){
      public void  onClick(View v){
          GPSManager gps = new GPSManager(MainActivity.this);
          if(gps.isGetLocation()){
              double la = gps.getLatitude();
              double lo = gps.getLongitude();

              te.setText(String.valueOf(la) + ", " + String.valueOf(lo));
          }else{
              gps.showSettingsAlert();
          }
        //  te.setText((int)gps.getLocation());

      }
    };

}
