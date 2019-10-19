package com.example.roombook.LocalData;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.roombook.Classes.User;

public class UserLocalData {


    //laver et navn for filen hvor data bliver lagt i

    public static final String SP_NAME = "userDetails";

    //sharedpreference gør at vi kan gemme data på telefonen

    SharedPreferences userLocalDatabase;

    //UserLocalData er en java class, så den kan ikke instatiate en sharedpreference.
    //så ved at bruge Context tvinger vi de activitys der vil bruge den her class til at give os deres context.

    public UserLocalData(Context context){
            userLocalDatabase = context.getSharedPreferences(SP_NAME, 0);
    }

    //laver en edit på vores lokale database så vi kan redigere i det data der er i vores sharedpreference
    //og så opdaterer vi alt det der bliver lagt i databasen og afslutter med et commit på spEditor

    public void storeUserData(User user){
        SharedPreferences.Editor spEditor = userLocalDatabase.edit();
        spEditor.putInt("phone number", user.phoneNr);
        spEditor.putString("name", user.name);
        spEditor.putString("email", user.email);
        spEditor.putString("password", user.password);
        spEditor.commit();
    }

    //hvis en activity kalder den her metode så vil den returnere en User som har attributes
    //for en logged in User

    public User getLoggedInUser (){
        String name = userLocalDatabase.getString("name","");
        String email = userLocalDatabase.getString("email","");
        String password = userLocalDatabase.getString("password","");
        int phoneNr = userLocalDatabase.getInt("phone number", -1);

        //herunder laver vi en user med de attributes fra user constructor og derefter returnerer den
        User storedUser = new User(phoneNr, name, email, password);
        return storedUser;
    }

    public boolean getUserLoggedIn(){
        if (userLocalDatabase.getBoolean("LoggedIn", false) == true) {
            return true;
        }
        else{
            return false;
        }
    }

    public void setUserLoggedIn(boolean loggedIn){
        SharedPreferences.Editor spEditor = userLocalDatabase.edit();
        spEditor.putBoolean("LoggedIn", loggedIn);
        spEditor.commit();
    }

    public void clearUserData(){
        SharedPreferences.Editor spEditor = userLocalDatabase.edit();
        spEditor.clear();
        spEditor.commit();
    }
}
