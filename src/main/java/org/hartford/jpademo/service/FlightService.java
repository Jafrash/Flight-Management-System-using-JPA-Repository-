package org.hartford.jpademo.service;

import org.hartford.jpademo.model.Flight;
import org.hartford.jpademo.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightService {
    @Autowired
    FlightRepository flightRepository;

    public Flight addFlight(Flight flight) {
        return flightRepository.save(flight);
    }

    public boolean deleteById(Long id){
        if(flightRepository.existsById(id)){
            flightRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public List<Flight> findAll(){
        return flightRepository.findAll();
    }

    public Flight findById(Long id){
        return flightRepository.findById(id).orElse(null);
    }

    public Flight update(Long id,Flight flight){
        Flight f=findById(id);
        if(f==null){
            return null;
        }
        f.setSource(flight.getSource());
        f.setDestination(flight.getDestination());
        f.setDepartureDate(flight.getDepartureDate());
        flightRepository.save(f);
        return f;
    }
}
