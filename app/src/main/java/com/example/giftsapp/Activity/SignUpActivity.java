package com.example.giftsapp.Activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.giftsapp.R;
import com.example.giftsapp.apiManager.ApiManager;
import com.example.giftsapp.models.Category;
import com.example.giftsapp.models.Mall;
import com.example.giftsapp.models.User;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;


public class SignUpActivity extends AppCompatActivity {
    // ...

    private static final int RC_SIGN_IN = 2;  // Can be any integer unique to the Activity.
    static String uid;
    // ...
    private FirebaseAuth mAuth;
    GoogleSignInClient mGoogleSignInClient;
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    EditText editTextemail;
    EditText editTextpassword;
    EditText editTextname;
    EditText editTextphone;
    Button buttonsignup;
    SignInButton  SignInButtonGoogle;
    TextView textViewlogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
// ...

     //   getSupportActionBar().hide();
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);



        // Initialize Firebase Auth
        //decler firebase
        mAuth = FirebaseAuth.getInstance();
        SignInButton signInButton = findViewById(R.id.SignInButtonGoogle);
        signInButton.setSize(SignInButton.SIZE_STANDARD);
        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signIn();
            }
        });


        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();
// Build a GoogleSignInClient with the options specified by gso.
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);
        GoogleSignInAccount acct = GoogleSignIn.getLastSignedInAccount(getApplicationContext());
        if (acct != null) {
            String personName = acct.getDisplayName();
            String personGivenName = acct.getGivenName();
            String personFamilyName = acct.getFamilyName();
            String personEmail = acct.getEmail();
            String personId = acct.getId();

            Uri personPhoto = acct.getPhotoUrl().normalizeScheme();

            Log.d("person", "onCreate: "+personPhoto+""
                    +personName+"/"+personGivenName+"/"+personFamilyName
                    +"/"+personEmail+"/"+personId);
        }

        //declere editTextname,editTextpassword,textViewtosignup and buttonLogin
            editTextname=findViewById(R.id.editTextSignupName);
            editTextphone=findViewById(R.id.editTextSignupPhone);
            editTextemail=findViewById(R.id.editTextSignupEmail);
           editTextpassword=findViewById(R.id.editTextSignuppassword);
           buttonsignup=findViewById(R.id.buttonsignup);
           textViewlogin=findViewById(R.id.textViewlogin);

           SignInButtonGoogle= (SignInButton ) findViewById(R.id.SignInButtonGoogle);
        //click to text login user intent to LoginActivity
        textViewlogin.setOnClickListener(v -> {
            Intent intent=new Intent(getApplicationContext(),LoginActivity.class);
            startActivity(intent);
        });

//click to buttonsignup for intent to HomeActivity if success
        buttonsignup.setOnClickListener(v -> {
            String name=editTextname.getText().toString();
            String phone=editTextphone.getText().toString();
            String email = editTextemail.getText().toString();
            String password = editTextpassword.getText().toString();
            CreateUserWithEmailAndPassword(name,email, password,phone);
        });
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


    //Method CreateUser  WithEmailAndPassword firebase
    public void CreateUserWithEmailAndPassword(String name,String email, String password,String phone){
        if (email!=null&&password!=null) {
            mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(task -> {
                if (task.isSuccessful()){
                     uid=task.getResult().getUser().getUid();
                    addusertoFirestore(uid,name,email,phone);
                    Log.d("TAG", "createUserWithEmail:success");
                    Toast.makeText(SignUpActivity.this, "Authentication success.",
                            Toast.LENGTH_SHORT).show();
                    Intent data=new Intent(getApplicationContext(),ProfileActivity.class);
                    data.putExtra("uid",uid);
                    data.putExtra("name",name);
                    data.putExtra("email",email);
                    data.putExtra("phone",phone);
                    startActivity(data);
                    Intent intent=new Intent(getApplicationContext(),HomeActivity.class);
                    startActivity(intent);

                }else {
                    Log.w("TAG", "createUserWithEmail:failure", task.getException());
                    Toast.makeText(SignUpActivity.this, "Authentication failed.",
                            Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
    public void addusertoFirestore(String id,String name,String email,String phone){
        // Create a new user with a first and last name
       User user = new User(id,name,email, phone);


// Add a new document with a generated ID
        db.collection("users").document(id).set(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        Log.d("", "DocumentSnapshot added with ID: success");

                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w("TAG", "Error adding document", e);

                    }
                });
SignOut();
signOutGoogle();


    }
    //sign in google
    private void signIn() {

        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Result returned from launching the Intent from GoogleSignInClient.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            // The Task returned from this call is always completed, no need to attach
            // a listener.

            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            handleSignInResult(task);

            startActivity(new Intent(SignUpActivity.this,HomeActivity.class));
        }
    }

    private void handleSignInResult(Task<GoogleSignInAccount> completedTask) {
        try {
            GoogleSignInAccount account = completedTask.getResult(ApiException.class);

            // Signed in successfully, show authenticated UI.
            //updateUI(account);
        } catch (ApiException e) {
            // The ApiException status code indicates the detailed failure reason.
            // Please refer to the GoogleSignInStatusCodes class reference for more information.
            Log.w("TAG", "signInResult:failed code=" + e.getStatusCode());
            // updateUI(null);
        }
    }
    private void signOutGoogle() {
        mGoogleSignInClient.signOut()
                .addOnCompleteListener(this, new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        // ...
                    }
                });
    }
    private void SignOut(){
        FirebaseAuth.getInstance().signOut();
    }

    }


