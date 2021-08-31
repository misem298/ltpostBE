package com.example.ltpastasbackend;
import javax.persistence.*;
import java.io.Serializable;

    @Entity
    @Table(name = "regions")
    public class RegionEntity implements Serializable {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "nr")
        private int nr;
        @Column(name = "id", length = 8)
        private String id;
        @Column(name = "code", length = 7)
        private String code;
        @Column(name = "name", length = 100)
        private String country;
        @Column(name = "continent", length = 10)
        private String continent;
        @Column(name = "iso_country", length = 5)
        private String iso;

        //Getters and setters
        public void setId(String id) {
            this.id = id;
        }
        public void setCode(String code) {
            this.code = code;
        }
        public void setCountry(String country) {
            this.country = country;
        }
        public void setContinent(String continent) {
            this.continent = continent;
        }
        public void setIso(String iso) {
            this.iso = iso;
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
        public String getIso() {
            return iso;
        }
        @Override
        public String toString() {
            return "states {id-" + id +  ", code-" + code + ", country-'" + country + ", continent-" + continent +
                    ", iso_country-" + iso + '}';
        }

}


