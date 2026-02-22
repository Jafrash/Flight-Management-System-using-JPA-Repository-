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
public class PassportService {
    @Autowired
    private PassportRepo passportRepo;

    @Autowired
    private PersonRepo personRepo;

    public List<Passport> findAll(){
        return passportRepo.findAll();
    }

    public Passport findById(Long id){
        return passportRepo.findById(id).orElseThrow(()->new RuntimeException("invalid id"));
    }

    public Passport addPassport(Passport passport){
        Person p=passport.getPerson();
        if(p==null){
            return passportRepo.save(passport);
        }
           p=personRepo.save(p);
           passport.setPerson(p);

        return passportRepo.save(passport);
    }



    public Person getPersonByPassportId(Long passportId){
        Passport passport=passportRepo.findById(passportId).orElseThrow(()->new RuntimeException("invalid id"));
        return passport.getPerson();
    }

    public Passport bindPersonToPassport(Long passportId,Long personId){
        Passport passport=passportRepo.findById(passportId).orElseThrow(()->new RuntimeException("invalid passport id"));
        Person person = personRepo.findById(personId).orElseThrow(()->new RuntimeException("invalid Person id"));
        passport.setPerson(person);
        return passportRepo.save(passport);
    }





}
