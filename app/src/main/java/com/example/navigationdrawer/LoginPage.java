package com.example.navigationdrawer;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthInvalidUserException;

public class LoginPage extends AppCompatActivity {
    private Button callSignUp,loginButton,forgetButton;

    TextInputLayout login_email , login_pass;
    private FirebaseAuth UserProfile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login_page);
        login_email = findViewById(R.id.login_email);
        login_pass = findViewById(R.id.login_pass);
        loginButton=findViewById(R.id.login_button);
        forgetButton=findViewById(R.id.forgot_pass);
        callSignUp =findViewById(R.id.callSignup_btn);
        UserProfile = FirebaseAuth.getInstance();

        callSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginPage.this, SignIn.class);
                startActivity(intent);
            }
        });
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String S_et_signin_email = login_email.getEditText().getText().toString();
                String S_et_signin_password = login_pass.getEditText().getText().toString();

                if (TextUtils.isEmpty(S_et_signin_email)){
                    Toast.makeText(LoginPage.this,"Enter email !",Toast.LENGTH_LONG).show();
                    login_email.setError("Enter Email");
                    login_email.requestFocus();
                } else if (TextUtils.isEmpty(S_et_signin_password)) {
                    Toast.makeText(LoginPage.this,"Enter Password !",Toast.LENGTH_LONG).show();
                    login_pass.setError("Enter the password");
                    login_pass.requestFocus();
                } else if (!Patterns.EMAIL_ADDRESS.matcher(S_et_signin_email).matches()) {
                    Toast.makeText(LoginPage.this,"Enter the Correct email",Toast.LENGTH_LONG).show();
                    login_email.setError("Enter the Correct Mail!");
                    login_email.requestFocus();
                } else {
                    loginUser(S_et_signin_email,S_et_signin_password);
                }
            }
            private void loginUser(String sEtSigninEmail, String sEtSigninPassword) {

                UserProfile.signInWithEmailAndPassword(sEtSigninEmail,sEtSigninPassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if(task.isSuccessful()){
                            Intent intent = new Intent(LoginPage.this,MainActivity.class);
                            startActivity(intent);
                            Toast.makeText(LoginPage.this, "You are logged in", Toast.LENGTH_LONG).show();
                        }
                        else {
                            try {
                                throw task.getException();
                            }catch (FirebaseAuthInvalidUserException e){
                                login_email.setError("User does not exists,Please register yourself");
                                login_email.requestFocus();
                            }catch (FirebaseAuthInvalidCredentialsException e){
                                login_email.setError("Invalid credentials");
                                login_email.requestFocus();
                            }catch (Exception e){
                                Log.e("loginexception",e.getMessage());
                                Toast.makeText(LoginPage.this, e.getMessage(), Toast.LENGTH_LONG).show();

                            }

                            Toast.makeText(LoginPage.this, "Something went wrong", Toast.LENGTH_LONG).show();
                        }

                    }
                });


            }
        });
        forgetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginPage.this, forgotpass.class);
                startActivity(intent);
            }
        });
    }
}