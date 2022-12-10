package com.example.giftsapp.Activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.giftsapp.R;
import com.example.giftsapp.models.User;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.SetOptions;

import java.util.Map;

public class ProfileActivity extends AppCompatActivity {
    EditText profileNameeditText;
    EditText profileemaileditText;
    EditText profilephoneeditText;
    Button buttonupdateinformation;
    Button profilebuttonsignout;
    FirebaseAuth firebaseAuth;
    FirebaseUser userauth;
    FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        profileNameeditText=findViewById(R.id.profileNameeditText);
        profileemaileditText=findViewById(R.id.profileemaileditText);
        profilephoneeditText=findViewById(R.id.profilephoneeditText);
        buttonupdateinformation=findViewById(R.id.buttonupdateinformation);
        profilebuttonsignout=findViewById(R.id.profilebuttonsignout);

         db = FirebaseFirestore.getInstance();
         firebaseAuth = FirebaseAuth.getInstance();
         userauth=firebaseAuth.getCurrentUser();



        profilebuttonsignout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                onBackPressed();
            }
        });


        if (getIntent().getStringExtra("id")!=null) {

            Task<DocumentSnapshot> documentSnapshotTask = db.collection("users")
                    .document(getIntent().getStringExtra("id"))
                    .get();
            documentSnapshotTask.addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                @Override
                public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                    User user = task.getResult().toObject(User.class);
                    Log.d("data", "onCreate: " + user.getId() + "\n" + user.getName() + "\n"
                            + user.getEmail() + "\n" + user.getPhoneNumber());
                    profileNameeditText.setText(user.getName());
                    profileemaileditText.setText(user.getEmail());
                    profilephoneeditText.setText(user.getPhoneNumber());
                }
            });
        }
        buttonupdateinformation.setOnClickListener(v -> {
            String name=profileNameeditText.getText().toString();
            String email=profileemaileditText.getText().toString().trim();
            String phone=profilephoneeditText.getText().toString().trim();
            User user=new User(getIntent().getStringExtra("id"),name,email,phone);

         updatedataUser(user);
         updateEmail(user.getEmail());

        });



    }

        public void updatedataUser(User user){
            db.collection("users").document(user.getId())
                    .set(user, SetOptions.merge()).addOnSuccessListener(new OnSuccessListener<Void>() {
                @Override
                public void onSuccess(Void unused) {
                    Toast.makeText(ProfileActivity.this, "تم تحديث البيانات بنجاح"
                                                                , Toast.LENGTH_SHORT).show();
                    Log.d("email", "onSuccess: ");

                }
            });
        }


        public void updateEmail(String email){
            FirebaseUser userauth = FirebaseAuth.getInstance().getCurrentUser();

            userauth.updateEmail(email)
                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(ProfileActivity.this, "تم تحديث الإيميل بنجاح"
                                        , Toast.LENGTH_SHORT).show();
                                Log.d("email", "User email address updated.");
                            }
                        }
                    });
        }
}