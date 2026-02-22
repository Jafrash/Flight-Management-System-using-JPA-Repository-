package org.hartford.mapping_demo.controller;

import org.hartford.mapping_demo.model.Passport;
import org.hartford.mapping_demo.model.Person;
import org.hartford.mapping_demo.service.PassportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/passports")
public class PassportController {
    @Autowired
    PassportService passportService;

    @PostMapping
    public Passport addPassport(@RequestBody Passport passport){
        return passportService.addPassport(passport);
    }

    @GetMapping
    public List<Passport>getAllPassports(){
        return passportService.findAll();
    }

    @GetMapping("/{id}")
    public Passport getById(@PathVariable Long id){
        return passportService.findById(id);
    }

    @GetMapping("person/{id}")
    public Person getPersonByPassportId(@PathVariable Long id){
        return passportService.getPersonByPassportId(id);
    }

    @GetMapping("/bind/{passportId}/{personId}")
    public Passport bindPersonToPassport(@PathVariable Long passportId,@PathVariable Long personId){
        return passportService.bindPersonToPassport(passportId,personId);
    }



}
