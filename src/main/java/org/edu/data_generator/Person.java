package org.edu.data_generator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Person {
    public String name;
    private String surname;
    private String middlename;
    private int age;
    private String sex;
    private String birthDate;
    private String birthPlace;
    private int birthIndex;
    private final String country = "Россия";
    private String region;
    private String city;
    private String street;
    private int building;
    private int room;

    public long getRandomNumber(long start, long end) {
        return ThreadLocalRandom.current().nextLong(start, end + 1);
    }

    public String getRandomLineFromResourceFile(String resourceFilename) throws IOException {
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        InputStream fileStream = classloader.getResourceAsStream(resourceFilename);

        BufferedReader br = new BufferedReader(new InputStreamReader(fileStream, "UTF-8"));
        String line;
        int linesCount = 0;
        List<String> lines = new ArrayList<>();

        while ((line = br.readLine()) != null)
        {
            linesCount++;
            lines.add(line);
        }

        int randomLineIndex = (int) getRandomNumber(0, linesCount);

        return lines.get(randomLineIndex);
    }

    public String getRandomSex() {
        int randomBinNumber = (int) getRandomNumber(0, 1);

        if (randomBinNumber == 1) {
            return "МУЖ";
        } else {
            return "ЖЕН";
        }
    }

    public Person() throws IOException {
        String maleName = getRandomLineFromResourceFile("male_names_rus.txt");
        String maleName2 = getRandomLineFromResourceFile("male_names_rus.txt");
        String femaleName = getRandomLineFromResourceFile("female_names_rus.txt");
        String maleSurname = getRandomLineFromResourceFile("male_surnames_rus.txt");

        sex = getRandomSex();
        if (Objects.equals(sex, "МУЖ")) {
            name = maleName;
            surname = maleSurname;
            middlename = maleName2 + "ович";
        } else {
            name = femaleName;
            surname = maleSurname + "а";
            middlename = maleName + "овна";
        }

        long currentTimestamp = System.currentTimeMillis();
        long birthDateTimestamp = getRandomNumber(0, currentTimestamp);
        Date date = new Date(birthDateTimestamp);
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        birthDate = formatter.format(date);
        age = (int) ((currentTimestamp-birthDateTimestamp)/(365*24*60*60*1000L));
        birthPlace = getRandomLineFromResourceFile("txt-cities-russia.txt");
        birthIndex = (int) getRandomNumber(100000, 999999);
        city = getRandomLineFromResourceFile("txt-cities-russia.txt");
        building = (int) getRandomNumber(1, 999);
        room = (int) getRandomNumber(1, 999);
        region = getRandomLineFromResourceFile("region.txt");
        street = getRandomLineFromResourceFile("streets.txt");
    }
}
