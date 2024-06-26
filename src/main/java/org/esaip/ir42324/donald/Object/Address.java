package org.esaip.ir42324.donald.Object;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "ADDRESS")
public class Address implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long id;
    @Column(name = "NUMBER")
    private String number;
    @Column(name = "STREET")
    private String street;
    @Column(name = "ZIPCODE")
    private String zipCode;
    @Column(name = "CITY")
    private String city;

    public Address() {}

    public Address(long id, String number, String street, String zipCode, String city) {
        this.id = id;
        this.number = number;
        this.street = street;
        this.zipCode = zipCode;
        this.city = city;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
