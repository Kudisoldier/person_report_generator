package org.edu;

import com.itextpdf.text.DocumentException;
import org.edu.data_generator.PersonGenerator;
import org.edu.pdf_generator.PdfTableGenerator;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws IOException, IllegalAccessException, DocumentException {
        Scanner inp = new Scanner(System.in);
        System.out.println("Enter numbers of rows:");
        int n = inp.nextInt();
        if ( n > 0 && n <= 30) {
            List<List<String>> table = PersonGenerator.generateListOfPersons(n);
            PdfTableGenerator.createPdf("report.pdf", table);
        } else {
            System.out.println("Wrong input! Expect 1 <= n <= 30");
        }

    }
}