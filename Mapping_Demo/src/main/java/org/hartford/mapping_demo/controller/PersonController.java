package org.hartford.mapping_demo.controller;

import org.hartford.mapping_demo.model.Passport;
import org.hartford.mapping_demo.model.Person;
import org.hartford.mapping_demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/persons")
public class PersonController {
    @Autowired
    PersonService personService;

    @GetMapping
    public List<Person> getAllPersons(){
        return personService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Person> getPersonById(@PathVariable Long id){
        return personService.findById(id);
    }

    @PostMapping
    public Person addPerson(@RequestBody Person person){
        return personService.addPerson(person);
    }



    @GetMapping("/passport/{personId}")
    public Passport getPassport(@PathVariable Long personId) {
        return personService.getPassportByPersonId(personId);
    }


    @GetMapping("/bind/{personId}/{passportId}")
    public Person bindPassportToPerson(@PathVariable Long personId,@PathVariable Long passportId){
        return personService.bindPassportToPerson(personId,passportId);
    }


}
