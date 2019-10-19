package com.example.roombook.Classes;

public class Reservation {

    int id, fromTime, toTime, roomId;
    String userId, purpose;

    public Reservation(int id, int fromTime, int toTime, int roomId, String userId, String purpose){
        this.id = id;
        this.fromTime = fromTime;
        this. toTime = toTime;
        this.roomId = roomId;
        this.userId = userId;
        this.purpose = purpose;

    }

    public Reservation(){

    }


}
