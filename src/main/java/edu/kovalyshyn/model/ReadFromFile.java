package edu.kovalyshyn.model;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class ReadFromFile {

    private static Logger log = LogManager.getLogger(ModelImpl.class);
    File file = new File("data.txt");

    public List<String> readFromFile() {
        List<String> readList = new ArrayList<>();
        try (Scanner read = new Scanner(file)) {
            while (read.hasNext()) {
                String line = read.nextLine();
                readList.add(line);
            }
        } catch (FileNotFoundException e) {
            log.error("file not found");
        }
        return readList;
    }

}
