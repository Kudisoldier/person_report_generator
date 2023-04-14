package org.edu;

import org.edu.data_generator.PersonGenerator;
import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException, IllegalAccessException {

        System.out.println(PersonGenerator.generateListOfPersons(30));
    }
}