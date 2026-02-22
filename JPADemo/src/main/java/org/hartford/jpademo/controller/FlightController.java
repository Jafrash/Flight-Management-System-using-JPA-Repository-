package org.hartford.jpademo.controller;

import org.apache.coyote.Response;
import org.hartford.jpademo.model.Flight;
import org.hartford.jpademo.service.FlightService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("flights")
public class FlightController {

    FlightService flightService;

    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    @GetMapping
    public List<Flight>getAll(){
        return flightService.findAll();
    }

    @GetMapping("{id}")
    public Flight getById(@PathVariable Long id){
        return flightService.findById(id);
    }

    @PostMapping
    public ResponseEntity<Flight>addFlight(@RequestBody Flight f){
        return ResponseEntity.status(HttpStatus.CREATED).body(flightService.addFlight(f));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteFlight(@PathVariable Long id){
        if(flightService.deleteById(id)){
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Flight>updateFlight(@PathVariable Long id, @RequestBody Flight f){
        return ResponseEntity.status(HttpStatus.OK).body(flightService.update(id,f));
    }

}
