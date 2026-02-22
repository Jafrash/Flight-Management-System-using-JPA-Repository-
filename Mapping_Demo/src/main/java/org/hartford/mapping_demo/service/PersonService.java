package org.hartford.mapping_demo.service;

import org.hartford.mapping_demo.model.Passport;
import org.hartford.mapping_demo.model.Person;
import org.hartford.mapping_demo.repository.PassportRepo;
import org.hartford.mapping_demo.repository.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {
    @Autowired
    PersonRepo personRepo;

    @Autowired
    PassportRepo passportRepo;
    public List<Person> findAll(){
        return personRepo.findAll();
    }

    public Optional<Person> findById(Long id){
        return personRepo.findById(id);
    }

    public Person addPerson(Person person){
        return personRepo.save(person);
    }


    public Passport getPassportByPersonId(Long personId){
        Person person=personRepo.findById(personId).orElseThrow(()->new RuntimeException("invalid person ID"));
        return person.getPassport();
    }

    public Person bindPassportToPerson(Long personId,Long passportId){
        Person person=personRepo.findById(personId).orElseThrow(()->new RuntimeException("invalid person id"));
        Passport passport=passportRepo.findById(passportId).orElseThrow(()->new RuntimeException("invalid passport id"));
        person.setPassport(passport);
        return personRepo.save(person);
    }






}
