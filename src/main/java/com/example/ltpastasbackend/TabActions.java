package com.example.ltpastasbackend;

import org.hibernate.Session;

public class TabActions {

    public static void main(String[] args) {
        Session  session = HibernateUtil.getSessionFactory().openSession();
        insertIntoAirportsMysqlTable();
        //Add table countries
        ReadFromCSV readCountries = new ReadFromCSV(4);
        readCountries.readFromCSV("task_countries.csv");
        System.out.println("readRegions.cols " + readCountries.cols[0].size());
        for (int i = 0; i < readCountries.cols[0].size(); i++) {
            session.beginTransaction();
            CountryEntity states = new CountryEntity();
            states.setCountry(readCountries.cols[1].get(i));
            states.setCode(readCountries.cols[0].get(i));
            states.setContinent(readCountries.cols[2].get(i));
            //Save data in database
            session.save(states);
            //Commit the transaction
            session.getTransaction().commit();
        }
        //Add table regions
        ReadFromCSV readRegions = new ReadFromCSV(6);
        readRegions.readFromCSV("task_regions.csv");
        System.out.println("readRegions.cols " + readRegions.cols[0].size());
        for (int i = 0; i < readRegions.cols[0].size(); i++) {
            session.beginTransaction();
            RegionEntity regions = new RegionEntity();
            regions.setId(readRegions.cols[0].get(i));
            regions.setCountry(readRegions.cols[2].get(i));
            regions.setCode(readRegions.cols[1].get(i));
            regions.setContinent(readRegions.cols[3].get(i));
            // System.out.println(readRegions.cols[3].get(i));
            regions.setIso(readRegions.cols[4].get(i));
            //Save data in database
            session.save(regions);
            //Commit the transaction
            session.getTransaction().commit();
        }
        HibernateUtil.shutdown();
    }

    protected static void insertIntoAirportsMysqlTable(){
        Session  session = HibernateUtil.getSessionFactory().openSession();
        ReadFromCSV readAirports = new ReadFromCSV(19);
        //readAirports.readFromCSV("task_airports.csv");
        readAirports.readByOpenCsv("task_airports.csv");
        System.out.println("readRegions.cols " + readAirports.fileScv.size() + "   "
                + readAirports.fileScv.get(0).length);
        for (int i = 1; i < readAirports.fileScv.size(); i++) {
            session.beginTransaction();
            try {
                AirportsEntity airports = new AirportsEntity();
                airports.setId(readAirports.fileScv.get(i)[0].replaceAll("[^a-zA-Z0-9-]",""));
                airports.setType(readAirports.fileScv.get(i)[1].replaceAll("[^a-zA-Z0-9-]",""));
                airports.setAirport(readAirports.fileScv.get(i)[2].replaceAll("[^a-zA-Z0-9-]",""));
                airports.setLatitude(Float.parseFloat(readAirports.fileScv.get(i)[3]));
                airports.setLongitude(Float.parseFloat(readAirports.fileScv.get(i)[4]));
                airports.setElevation(Integer.parseInt(readAirports.fileScv.get(i)[5]));
                airports.setContinent(readAirports.fileScv.get(i)[6].replaceAll("[^a-zA-Z0-9-]",""));
                airports.setIsocountry(readAirports.fileScv.get(i)[7].replaceAll("[^a-zA-Z0-9-]",""));
                airports.setIsoregion(readAirports.fileScv.get(i)[8].replaceAll("[^a-zA-Z0-9-]",""));
                airports.setMunicipality(readAirports.fileScv.get(i)[9].replaceAll("[^a-zA-Z0-9-]",""));
                airports.setService(readAirports.fileScv.get(i)[10].replaceAll("[^a-zA-Z0-9-]",""));
                airports.setGps(readAirports.fileScv.get(i)[11].replaceAll("[^a-zA-Z0-9-]",""));
                airports.setIata(readAirports.fileScv.get(i)[12].replaceAll("[^a-zA-Z0-9-]",""));
                airports.setLocal(readAirports.fileScv.get(i)[13].replaceAll("[^a-zA-Z0-9-]",""));
                airports.setWizzair(Integer.parseInt(readAirports.fileScv.get(i)[14]));
                airports.setRyanair(Integer.parseInt(readAirports.fileScv.get(i)[15]));
                airports.setAirbaltic(Integer.parseInt(readAirports.fileScv.get(i)[16]));
                airports.setLufthansa(Integer.parseInt(readAirports.fileScv.get(i)[17]));
                airports.setTurkishairlines(Integer.parseInt(readAirports.fileScv.get(i)[18]));

                session.save(airports);
               // for(int k=0; k<19; k++){
                   System.out.println(readAirports.fileScv.get(i)[9] + "     " + i);
               //]     System.out.println("     ");
               // }
            }
            catch (Exception e) {
                System.out.println();
                for (int k=0; k==18; k++)  { System.out.println(readAirports.cols[k].get(i));}
            }
            session.getTransaction().commit();
        }
    }
}

