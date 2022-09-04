package com.example.giftsapp.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.giftsapp.R;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class WelcomeActivity extends AppCompatActivity {
    FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        getSupportActionBar().hide();
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        mAuth = FirebaseAuth.getInstance();
        Button welcombuttonsignup=findViewById(R.id.welcombuttonsignup);
        Button welcombuttonlogin=findViewById(R.id.welcombuttonlogin);
        welcombuttonsignup.setOnClickListener(v ->
                startActivity(new Intent(WelcomeActivity.this,SignUpActivity.class)));
        welcombuttonlogin.setOnClickListener(v
                -> startActivity(new Intent(WelcomeActivity.this,LoginActivity.class)));
    }
    //if currentUser != null intent to HomeActivity
    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(this);

        if(currentUser != null||account!=null){
            Intent intent=new Intent(getApplicationContext(),HomeActivity.class);
            startActivity(intent);
        }
    }

}