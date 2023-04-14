package  org.edu.pdf_generator;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class PdfTableGenerator {
    public static final String FONT = "resources/arial.ttf";


    public static PdfPCell getNormalCell(String string) {
        //Font f = new Font(Font.FontFamily.HELVETICA, 14);
        Font f = FontFactory.getFont(FONT, "CP-1251", true);
        PdfPCell cell = new PdfPCell(new Phrase(string, f));
        //cell.setHorizontalAlignment(Element.ALIGN_LEFT);
        return cell;
    }

    public static void createPdf(String dest, List<List<String>> table) throws IOException, DocumentException {
        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream(dest));
        document.open();
        Font f = FontFactory.getFont(FONT, "CP-1251", true);
        document.add(new Paragraph("Привет ff",f));
        PdfPTable pdfTable = new PdfPTable(table.get(0).size());
        for (List<String> rows : table) {
            for (int j = 0; j < table.get(0).size(); j++) {
                pdfTable.addCell(getNormalCell(rows.get(j)));
            }
        }
        document.add(pdfTable);
        document.close();
    }
}