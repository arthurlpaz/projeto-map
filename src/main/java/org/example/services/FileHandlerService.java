package org.example.services;


import java.io.*;
import java.io.IOException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.io.FileReader;


public class FileHandlerService {

    public static ArrayList<String> readDataDataLineByLine(String file) {
        // list that holds strings of a file
        ArrayList<String> listOfJson = new ArrayList<String>();

        try{
            // load data from file
            BufferedReader bf = new BufferedReader(new FileReader(file));

            // read entire line as string
            String line = bf.readLine();

            // checking for end of file
            while (line != null) {
                listOfJson.add(line);
                line = bf.readLine();
            }

            // closing bufferreader object
            bf.close();
        }catch (IOException e){
            e.printStackTrace();
        }

        if(listOfJson.size() >= 3){
            listOfJson.remove(0);
            listOfJson.remove(listOfJson.size()-1);
        }

        return listOfJson;
    }
    public static void writeDataLineByLine(String filePath, ArrayList<String> database)
    {
        // first create file object for file placed at location
        // specified by filepath


        try {
            // Creates a FileWriter
            FileWriter file = new FileWriter(filePath);

            // Creates a BufferedWriter
            BufferedWriter output = new BufferedWriter(file);

            output.write("[\n");

            // Writes data to the file
            for (String s : database) {
                output.write(s + "\n");
            }

            output.write("]");


            // Flushes data to the destination
            output.flush();

            output.close();
        }

        catch(Exception e) {
            e.getStackTrace();
        }
    }
}
