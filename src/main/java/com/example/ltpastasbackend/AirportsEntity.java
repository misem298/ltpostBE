package com.example.ltpastasbackend;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "airports")
public class AirportsEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "nr")
    private int nr;
    @Column(name = "id", length = 8)
    private String id;
    @Column(name = "type", length = 20)
    private String type;
    @Column(name = "name", length = 100)
    private String airport;
    @Column(name = "latitude")
    private Float latitude;
    @Column(name = "longitude")
    private Float longitude;
    @Column(name = "elevation")
    private int elevation;
    @Column(name = "continent", length = 3)
    private String continent;
    @Column(name = "iso_country", length = 5)
    private String isocountry;
    @Column(name = "iso_region", length = 7)
    private String isoregion;
    @Column(name = "municipality", length = 254)
    private String municipality;
    @Column(name = "scheduled_service", length = 5)
    private String service;
    @Column(name = "gps_code", length = 254)
    private String gps;
    @Column(name = "iata_code", length = 5)
    private String iata;
    @Column(name = "local_code",length = 254 )
    private String local;
    @Column(name = "wizzair")
    private int wizzair;
    @Column(name = "ryanair")
    private int ryanair;
    @Column(name = "airbaltic")
    private int airbaltic;
    @Column(name = "lufthansa")
    private int lufthansa;
    @Column(name = "turkishairlines")
    private int turkishairlines;

    //Getters and setters
    public void setId(String id) {
        this.id = id;
    }
    public void setType(String type) {
        this.type = type;
    }
    public void setAirport(String airport) {this.airport = airport;}
    public void setLatitude(Float latitude) {this.latitude = latitude;}
    public void setLongitude(Float longitude) {
        this.longitude = longitude;
    }
    public void setElevation(int elevation) {
        this.elevation = elevation;
    }
    public void setContinent(String continent) {this.continent = continent; }
    public void setIsocountry(String isocountry) {
        this.isocountry = isocountry;
    }
    public void setIsoregion(String isoregion) {
        this.isoregion = isoregion;
    }
    public void setMunicipality(String municipality) {
        this.municipality = municipality;
    }
    public void setService(String service) {
        this.service = service;
    }
    public void setGps(String gps) {
        this.gps = gps;
    }
    public void setIata(String iata) {
        this.iata = iata;
    }
    public void setLocal(String local) {
        this.local = local;
    }
    public void setWizzair(int wizzair) { this.wizzair = wizzair;}
    public void setRyanair(int ryanair) {
        this.ryanair = ryanair;
    }
    public void setAirbaltic(int airbaltic) {
        this.airbaltic = airbaltic;
    }
    public void setLufthansa(int lufthansa) {
        this.lufthansa = lufthansa;
    }
    public void setTurkishairlines(int turkishairlines) {
        this.turkishairlines = turkishairlines;
    }

    @Override
    public String toString() {
        return "airports {wizzair-" + wizzair + ", ryanair-" + ryanair + ", airbaltic-'" + airbaltic + ", lufthansa-" + lufthansa +
                ", turkishairlines-" + turkishairlines + '}';
    }
}
