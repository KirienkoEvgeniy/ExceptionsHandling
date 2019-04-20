package org.demo;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListOfNumbers {
    private List<Integer> list;
    private static final int SIZE = 10;

    public ListOfNumbers(String fileLocation) {
        list = new ArrayList<Integer>(SIZE);
        for (int i = 0; i < SIZE; i++)
            list.add(new Integer(i));
    }

    public void writeContentToFile(String fileLocation) throws IOException {
        FileWriter nFile = null;
        try {
            nFile = new FileWriter(fileLocation);
           for (int integer : list) {
               nFile.write(String.valueOf(integer));
               nFile.write("\n");
           }
       }
       finally {
            if(nFile != null) nFile.close();
       }
    }

    public void readContentFromFile(String fileLocation) throws FileNotExistLocationException, IOException, FileIsEmptyException {
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(fileLocation);
            Scanner scanner = new Scanner(fileReader);
            if(!scanner.hasNext()){
                throw new FileIsEmptyException(" File -> " + fileLocation + "   is empty");
            }
            while (scanner.hasNext()) {
                System.out.print(" " + scanner.nextLine());
            }
        }catch (IOException e){
            throw new FileNotExistLocationException(e.getMessage());
        }
        finally {
            if(fileReader != null)  fileReader.close();
        }
    }
}

