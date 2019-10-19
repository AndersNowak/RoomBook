package com.example.roombook.Activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.roombook.Classes.User;
import com.example.roombook.LocalData.UserLocalData;
import com.example.roombook.R;

public class UserActivity extends AppCompatActivity {

    TextView userNameText, userEmailText, userPhoneNrText;
    Button logoutBtn;
    UserLocalData userLocalData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        userNameText = findViewById(R.id.userNameText);
        userEmailText = findViewById(R.id.userEmailText);
        userPhoneNrText = findViewById(R.id.userPhoneNrText);



        userLocalData = new UserLocalData(this);

        logoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                userLocalData.clearUserData();
                userLocalData.setUserLoggedIn(false);

                startActivity(new Intent(UserActivity.this, MainActivity.class));
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        if (authenticate() == true) {
            displayUserDetails();
        }
        else {
            startActivity((new Intent(UserActivity.this, LoginActivity.class)));
        }
    }

    private boolean authenticate(){
        return userLocalData.getUserLoggedIn();
    }

    private void displayUserDetails(){
        User user = userLocalData.getLoggedInUser();

        userNameText.setText(user.name);
        userEmailText.setText(user.email);
        userPhoneNrText.setText(user.phoneNr);

    }
}
