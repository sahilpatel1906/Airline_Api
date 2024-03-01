package com.example.airline_api.components;


import com.example.airline_api.models.Flight;
import com.example.airline_api.models.Passenger;
import com.example.airline_api.repositories.FlightRepository;
import com.example.airline_api.repositories.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    PassengerRepository passengerRepository;

    @Autowired
    FlightRepository flightRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {



        Passenger passenger1 = new Passenger("Bob", "Bob@test.com");
        passengerRepository.save(passenger1);
        Passenger passenger2 = new Passenger("Tedd", "Tedd@Todd.com");
        passengerRepository.save(passenger2);
        Passenger passenger3 = new Passenger("Gemma", "Gemma@mail.com");
        passengerRepository.save(passenger3);

        Flight flight1 = new Flight("Italy", 200, "date1", "time1");
        flight1.addPassenger(passenger1);
        flight1.addPassenger(passenger3);
        flightRepository.save(flight1);
        Flight flight2 = new Flight("Bali", 150, "NotDate", "NotTime");
        flight2.addPassenger(passenger2);
        flightRepository.save(flight2);
        Flight flight3 = new Flight("France", 100, "Date1", "Time1");
        flight3.addPassenger(passenger3);
        flightRepository.save(flight3);


    }
}
