package com.example.ltpastasbackend;

import com.opencsv.CSVReader;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.List;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner; // Import the Scanner class to read text files

public class ReadFromCSV {
    protected ArrayList<String> cols[] ;
    protected List<String[]> fileScv;
    public  ReadFromCSV(int dim) {
      ArrayList<String> cols[] = new ArrayList[dim];
      for (int i=0; i<dim; i++) {
          cols[i] = new ArrayList<>();
      }
      this.cols = cols;
    }
    protected void readByOpenCsv(String fileName){
        File myFile= new File( "C:/Users/admin/IdeaProjects/ltpastasBackEnd/src/main/java/com/example/ltpastasbackend/" + fileName);
        try (CSVReader reader = new CSVReader(new FileReader(myFile))) {
            fileScv = (List) reader.readAll();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    protected void readFromCSV(String fileName) {
        try {
            File myFile= new File( "C:/Users/admin/IdeaProjects/ltpastasBackEnd/src/main/java/com/example/ltpastasbackend/" + fileName);
           Scanner myReader = new Scanner(myFile);
            myReader.nextLine();
            int k=0;
            while (myReader.hasNextLine()) {
               String  line = myReader.nextLine().replaceAll("[^a-zA-Z0-9,-. _\"]","");
                k++;
                    if(k==21992 ) {
                        System.out.println(line);
                    }
                System.out.println(k + "line:    " + line);
                int indCol = 0;
                int indStart =  0;
                int indEnd = 0;
                while(indStart < line.length()) {
                    String ss=line.substring(indStart,indStart + 1);
                    if (line.substring(indStart,indStart + 1).equals("\"")) {
                        indEnd = line.indexOf('"', indStart + 1 );
                        cols[indCol].add(line.substring(indStart, indEnd ));
                      //  System.out.println(indStart + "-" + indEnd + "  " +  line.substring(indStart, indEnd ));
                        indStart = indEnd + 1;
                       // indCol++;
                    }
                    indEnd = line.indexOf(",", indStart);
                    if (indCol > 18) {
                            System.out.println("line " + line + "   "  );
                    }

                    if (indEnd == -1)  {
                        cols[indCol].add(line.substring(indStart));
                        break;
                    }

                    else cols[indCol].add(line.substring(indStart, indEnd ));
                    indStart = indEnd + 1;
                    indCol++;
                }
               // System.out.println(line);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
