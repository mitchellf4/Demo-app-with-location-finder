package com.example.mfinstad.appexample;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import java.util.Locale;


public class MyLocation extends AppCompatActivity {

    private FusedLocationProviderClient mFusedLocationClient;
    protected Location LastLocation;
    private String LatitudeLabel;
    private String LongitudeLabel;
    private TextView LatitudeText;
    private TextView LongitudeText;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LatitudeLabel = getResources().getString(R.string.latitude_label);
        LongitudeLabel = getResources().getString(R.string.longitude_label);
        LatitudeText = (TextView) findViewById((R.id.lat_text));
        LongitudeText = (TextView) findViewById((R.id.long_text));

        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(this);

    }

    @Override
    public void onStart() {
        super.onStart();
        getLastLocation();

    }

    @SuppressWarnings("MissingPermission")
    private void getLastLocation() {
        mFusedLocationClient.getLastLocation()
                .addOnCompleteListener(this, new OnCompleteListener<Location>() {
                    @Override
                    public void onComplete(@NonNull Task<Location> task) {

                        if (task.isSuccessful() && task.getResult() != null) {

                            LastLocation =task.getResult();
                            LatitudeText.setText(String.format(Locale.ENGLISH, "%s: %f",
                                    LatitudeLabel,
                                    LastLocation.getLatitude()));
                            LongitudeText.setText(String.format(Locale.ENGLISH, "%s: %f",
                                    LongitudeLabel,
                                    LastLocation.getLongitude()));
                        }
                        else {
                            Context context = getApplicationContext();
                            CharSequence text = "Location is not enabled on your device!";
                            int duration = Toast.LENGTH_SHORT;
                            Toast toast = Toast.makeText(context, text, duration);

                            toast.show();

                        }
                    }
                });
    }


}
