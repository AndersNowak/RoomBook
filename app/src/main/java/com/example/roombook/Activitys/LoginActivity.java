package com.example.roombook.Activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.roombook.Classes.User;
import com.example.roombook.LocalData.UserLocalData;
import com.example.roombook.R;


public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    Button loginBtn;
    EditText passLoginText, emailLoginText;
    TextView registerHereLink;
    UserLocalData userLocalData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        registerHereLink = findViewById(R.id.registerHereLink);
        passLoginText = findViewById(R.id.passLoginText);
        emailLoginText = findViewById(R.id.emailLoginText);
        loginBtn = findViewById(R.id.loginBtn);


        loginBtn.setOnClickListener(this);
        registerHereLink.setOnClickListener(this);

        userLocalData = new UserLocalData(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.loginBtn:
                User user = new User(null, null, null, null);
                userLocalData.storeUserData(user);
                userLocalData.setUserLoggedIn(true);

                startActivity(new Intent(this, UserActivity.class));
                break;

            case R.id.registerHereLink:
                startActivity(new Intent(this, RegisterActivity.class));
                break;


        }
    }
}
