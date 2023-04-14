package org.edu.data_generator;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class PersonGenerator {
    public static List<List<String>> generateListOfPersons(int n) throws IllegalAccessException, IOException {
        List<List<String>> table = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<String> fields = new ArrayList<>();
            Person person = new Person();
            Field[] fs = person.getClass().getDeclaredFields();
            for (Field field : fs) {
                field.setAccessible(true);
                fields.add(field.get(person).toString());
            }
            table.add(fields);
        }

        return table;
    }
}
