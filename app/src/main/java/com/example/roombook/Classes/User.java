package com.example.roombook.Classes;

public class User {



    public String name, email, password;
    public int phoneNr;

    public User(Integer phoneNr, String name, String email, String password){

        this.name = name;
        this.phoneNr = phoneNr;
        this.email = email;
        this.password = password;
    }

}
