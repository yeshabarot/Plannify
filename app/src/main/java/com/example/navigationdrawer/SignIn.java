package com.example.navigationdrawer;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Objects;


public class SignIn extends AppCompatActivity {
    private TextInputLayout et_name , et_email , et_password , et_conf_pass;
    private Button regisNow;
    private Button log;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin_page);
        et_name = findViewById(R.id.signin_name);
        et_email=findViewById(R.id.signin_email);
        et_password = findViewById(R.id.signin_password);
        et_conf_pass = findViewById(R.id.signin_Cpassword);
        regisNow = findViewById(R.id.signin_signup);
        log = findViewById(R.id.signin_login);

        regisNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignIn.this, LoginPage.class);
                startActivity(intent);
            }
        });

        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String S_et_name = et_name.getEditText().getText().toString();
                String S_et_email = et_email.getEditText().getText().toString();
                String S_et_password = et_password.getEditText().getText().toString();
                String S_et_conf_pass = et_conf_pass.getEditText().getText().toString();

                if (TextUtils.isEmpty(S_et_name)) {
                    Toast.makeText(SignIn.this, "Enter your name", Toast.LENGTH_LONG).show();
                    et_name.setError("Can't be Empty!");
                    et_name.requestFocus();
                } else if (TextUtils.isEmpty(S_et_email)) {
                    Toast.makeText(SignIn.this, "Enter Email", Toast.LENGTH_LONG).show();
                    et_email.setError("Can't be Empty!");
                    et_name.requestFocus();
                } else if (TextUtils.isEmpty(S_et_password)) {
                    Toast.makeText(SignIn.this, "Enter the password", Toast.LENGTH_LONG).show();
                    et_password.setError("Can't be Enpty!");
                    et_password.requestFocus();
                } else if (TextUtils.isEmpty(S_et_conf_pass)) {
                    Toast.makeText(SignIn.this, "Don't forget to conform your password !", Toast.LENGTH_LONG).show();
                    et_conf_pass.setError("Can't be Empty!");
                    et_conf_pass.requestFocus();
                } else if (!Patterns.EMAIL_ADDRESS.matcher(S_et_email).matches()) {
                    Toast.makeText(SignIn.this, "Enter correct Email", Toast.LENGTH_LONG).show();
                    et_email.setError("Incorrect Mail !");
                    et_email.requestFocus();
                } else if (!S_et_conf_pass.equals(S_et_password)) {
                    Toast.makeText(SignIn.this, "Enter the the same password.", Toast.LENGTH_LONG).show();
                    et_conf_pass.setError("Password do not match.");
                    et_conf_pass.requestFocus();
                    et_password.getContext();
                    et_conf_pass.getContext();
                } else {
                    Log.i("hi", "onClick: else part");
                    register(S_et_name, S_et_email, S_et_password, S_et_conf_pass);
                }


            }
        });
    }
    public void register(String name,String email,String passwaord,String cf_pass) {
        //firebase authentication karega baadme
        FirebaseAuth auth = FirebaseAuth.getInstance();
        auth.createUserWithEmailAndPassword(email, passwaord).addOnCompleteListener(SignIn.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Log.i("hi", "Clicked on sign in!");
                    Toast.makeText(SignIn.this, "User regestered", Toast.LENGTH_LONG).show();
                    FirebaseUser firebaseUser = auth.getCurrentUser();

                    //storing your data into firebase realtime database
                    ReadWriteUserDetails writeUserDetails = new ReadWriteUserDetails(name, email, passwaord, cf_pass);


                    //creating a note to a user to add data into realtime data base
                    DatabaseReference profile = FirebaseDatabase.getInstance().getReference("Registered User: ");
                    assert firebaseUser != null;
                    profile.child(firebaseUser.getUid()).setValue(writeUserDetails).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {

                            if (task.isSuccessful()) {
                                Toast.makeText(SignIn.this, "Registered successfully in firsebase", Toast.LENGTH_LONG).show();


                                firebaseUser.sendEmailVerification(); //send verification mail

                                //intent to next page
                                Intent intent = new Intent(SignIn.this, LoginPage.class);
                                //to prevent user from returning back to register activity pressing back button after registration is done
                                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                                startActivity(intent);
                                finish();  //to close registration activity
                            } else {
                                Toast.makeText(SignIn.this, "Registered failed in firsebase", Toast.LENGTH_LONG).show();
                            }

                        }
                    });

                } else {
                    try {
                        throw Objects.requireNonNull(task.getException());
                    } catch (Exception e) {
                        Log.e("exception", Objects.requireNonNull(e.getMessage()));
                        Toast.makeText(SignIn.this, e.getMessage(), Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
    }
}