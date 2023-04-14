package org.edu;

import org.edu.data_generator.PersonGenerator;
import org.edu.pdf_generator.PdfTableGenerator;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, IllegalAccessException, com.lowagie.text.DocumentException {
        System.out.print("Введите количество человек для генерации: ");
        Scanner inp = new Scanner(System.in);
        int n = inp.nextInt();
        if ( 1 <= n && n <= 30) {
            List<List<String>> table = PersonGenerator.generateListOfPersons(n);
            PdfTableGenerator.createPdf("report.pdf", table);
            System.out.println("Файл создан. Путь:" + System.getProperty("user.dir") + "/resource.pdf");
        } else {
            System.out.println("Wrong input! Expect 1 <= n <= 30");
        }

    }
}