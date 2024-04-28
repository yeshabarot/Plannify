package com.example.navigationdrawer;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CoverPage extends Activity {
	private Button toLogin,toSignup;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_cover_page);
		toLogin=findViewById(R.id.Login);
		toSignup=findViewById(R.id.SignUp);
		toLogin.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Intent intent = new Intent(CoverPage.this, LoginPage.class);
				startActivity(intent);
			}
		});
		toSignup.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Intent intent = new Intent(CoverPage.this, SignIn.class);
				startActivity(intent);
			}
		});
	
	}
}
	
	