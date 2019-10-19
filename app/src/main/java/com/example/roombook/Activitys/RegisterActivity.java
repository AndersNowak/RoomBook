package com.example.roombook.Activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.roombook.Classes.User;
import com.example.roombook.LocalData.UserLocalData;
import com.example.roombook.R;

public class RegisterActivity extends AppCompatActivity {

    Button registerBtn;
    EditText phoneNrRegisterText, nameRegisterText, emailRegisterText, passRegisterText;
    UserLocalData userLocalData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        userLocalData = new UserLocalData(this);

        phoneNrRegisterText = findViewById(R.id.phoneNrRegisterText);
        nameRegisterText = findViewById(R.id.nameRegisterText);
        emailRegisterText = findViewById(R.id.emailRegisterText);
        passRegisterText = findViewById(R.id.passRegisterText);

        registerBtn = findViewById(R.id.registerBtn);

        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int phoneNr = Integer.parseInt(phoneNrRegisterText.getText().toString());
                String name = nameRegisterText.getText().toString();
                String email = emailRegisterText.getText().toString();
                String password = passRegisterText.getText().toString();


                User registeredUserData = new User(phoneNr, name, email, password);
                userLocalData.storeUserData(registeredUserData);

                startActivity(new Intent(RegisterActivity.this, UserActivity.class));
            }
        });

    }
}
