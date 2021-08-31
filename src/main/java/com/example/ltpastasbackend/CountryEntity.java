package com.example.ltpastasbackend;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "states")
public class CountryEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "nr")
    private int nr ;
    @Column(name = "code",   length = 5)
    private String code;
    @Column(name = "name",  length = 100)
    private String country;
    @Column(name = "continent",  length = 5)
    private String continent;

    //Getters and setters
    public void setCode(String code) {
        this.code = code;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    public void setContinent(String continent) {
        this.continent = continent;
    }
    public String getCode() {
        return code;
    }
    public String getCountry() {
        return country;
    }
    public String getContinent() {
        return continent;
    }

    @Override
    public String toString() {
        return "states {code-" + code + ", country-'" + country + ", continent-" + continent + '}';
    }
}