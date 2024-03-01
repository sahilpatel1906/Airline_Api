package com.example.airline_api.services;

import com.example.airline_api.models.Flight;
import com.example.airline_api.models.Passenger;
import com.example.airline_api.repositories.FlightRepository;
import com.example.airline_api.repositories.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FlightService {
    @Autowired
    FlightRepository flightRepository;

    @Autowired
    PassengerRepository passengerRepository;

    public List<Flight> getAllFlights(){
        return flightRepository.findAll();
    }

    public Optional<Flight> getFlightById(long id){
        return flightRepository.findById(id);
    }

    public Flight addNewFlight(Flight flight){
        flightRepository.save(flight);
        return flight;
    }



    public Flight addPassengerToFlight(long id, long passengerId) {
        Optional<Flight> flightOptional = flightRepository.findById(id);
        Optional<Passenger> passengerOptional = passengerRepository.findById(passengerId);
        Flight flight;
        Passenger passenger;
        if(flightOptional.isPresent()){
            flight = flightOptional.get();
            if(passengerOptional.isPresent()){
                passenger = passengerOptional.get();
                flight.addPassenger(passenger);
            }

            return flightRepository.save(flight);
        }
        return null;
    }

    public void cancelFlight(long id) {
        Optional<Flight> flightOptional = flightRepository.findById(id);
        Flight flight;
        if(flightOptional.isPresent()) {
            flight = flightOptional.get();
            for(Passenger passenger: flight.getPassengers()){
                passenger.removeFlight(flight);
            }
            flightRepository.delete(flight);
        }

    }
}
