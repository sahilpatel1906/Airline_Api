package com.example.airline_api.models;

public class PassengerDTO {
    private long id;

    public PassengerDTO(){}

    public PassengerDTO(long id){
        this.id = id;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
