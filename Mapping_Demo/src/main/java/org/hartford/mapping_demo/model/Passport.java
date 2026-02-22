package org.hartford.mapping_demo.model;


import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Passport {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String passportNumber;
    private Date releaseDate;
    private Date expiryDate;

    @OneToOne(cascade=CascadeType.ALL)
    private Person person;

    public Passport() {
    }

    public Passport(Long id, String passportNumber, Date releaseDate, Date expiryDate) {
        this.id = id;
        this.passportNumber = passportNumber;
        this.releaseDate = releaseDate;
        this.expiryDate = expiryDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
