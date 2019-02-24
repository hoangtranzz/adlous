package yfp.com;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.firebase.FirebaseApp;
import com.google.firebase.iid.FirebaseInstanceId;
import com.hyxen.adlocusaar.AdLocus;

import yfp.com.R;

public class MainActivity extends AppCompatActivity {

    final private static int TAG_LOCATION=100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(yfp.com.R.layout.activity_main);

        String tokenn = FirebaseInstanceId.getInstance().getToken();
        Log.d("Token","FCM token:"+tokenn);

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            FirebaseApp.initializeApp(this);
            String token = FirebaseInstanceId.getInstance().getToken();
            //Log.d(TAG,"FCM token:"+token);
            AdLocus.getInstance(this)
                    .checkUserStatement(!TextUtils.isEmpty(token) ? token : "",
                            getString(yfp.com.R.string.fcm_app_key), getPackageName(), getString(yfp.com.R.string.app_key));
        } else {
            ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, TAG_LOCATION);
        }

        //第一次修改--------->(以下
        Button Button1 = (Button) findViewById(R.id.button1);
        Button Button2 = (Button) findViewById(R.id.button2);



        Button1.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                Intent intent= new Intent();
                intent.setClass(MainActivity.this, page2.class);
                startActivity(intent);
                //MainActivity.this.finish();
            }
        });
        Button2.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                Intent intent= new Intent();
                intent.setClass(MainActivity.this, page3.class);
                startActivity(intent);
                //MainActivity.this.finish();
            }
        });

        //第一次修改--------->)以上

    }
    @Override
    public void onRequestPermissionsResult(int requestCode,String permissions[], int[] grantResults) {
        switch (requestCode) {
            case TAG_LOCATION: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // permission was granted, yay! Do the
                    // contacts-related task you need to do.
                    String token = FirebaseInstanceId.getInstance().getToken();
                    AdLocus.getInstance(this)
                            .checkUserStatement(!TextUtils.isEmpty(token) ? token : "",
                                    getString(yfp.com.R.string.fcm_app_key), getPackageName(), getString(yfp.com.R.string.app_key));
                } else {
                    String token = FirebaseInstanceId.getInstance().getToken();
                    AdLocus.getInstance(this)
                            .checkUserStatement(!TextUtils.isEmpty(token) ? token : "",
                                    getString(yfp.com.R.string.fcm_app_key), getPackageName(), getString(yfp.com.R.string.app_key));
                }
                return;
            }
        }
    }
}
