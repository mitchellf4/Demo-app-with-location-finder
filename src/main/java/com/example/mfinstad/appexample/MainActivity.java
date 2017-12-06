package com.example.mfinstad.appexample;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener {

    Button btnSignIn;
    Button btnSignUp;
    Button btnMyLocation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSignIn = (Button) findViewById(R.id.btnSingIn);
        btnSignUp = (Button) findViewById(R.id.btnSignUp);
        btnMyLocation = (Button) findViewById(R.id.btnMyLocation);

        btnSignIn.setOnClickListener(this);
        btnSignUp.setOnClickListener(this);
        btnMyLocation.setOnClickListener(this);

    }
    @Override
    public void onClick(View v) {
        Intent i = null;
        switch(v.getId()){
            case R.id.btnSingIn:
                i = new Intent(this,SignIn.class);
                break;
            case R.id.btnSignUp:
                i = new Intent(this,SignUp.class);
                break;
            case R.id.btnMyLocation:
                i = new Intent(this,MyLocation.class);
                break;
        }
        startActivity(i);
    }



}

