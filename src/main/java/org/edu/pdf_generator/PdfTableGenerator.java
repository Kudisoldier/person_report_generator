package  org.edu.pdf_generator;

import com.lowagie.text.*;
import com.lowagie.text.pdf.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import com.lowagie.text.pdf.BaseFont;



public class PdfTableGenerator {
    public static final String FONT = System.getProperty("user.dir") + "/src/main/resources/arial.ttf";

    public static PdfPCell getNormalCell(String string) throws com.lowagie.text.DocumentException, IOException {
        BaseFont bf=BaseFont.createFont(FONT, BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
        Font font=new Font(bf,5,Font.NORMAL);
        PdfPCell cell = new PdfPCell(new Phrase(string, font));
        cell.setHorizontalAlignment(Element.ALIGN_LEFT);
        return cell;
    }

    public static void createPdf(String dest, List<List<String>> table) throws IOException, com.lowagie.text.DocumentException {
        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream(dest));
        document.open();
        Font f = FontFactory.getFont(FONT, BaseFont.IDENTITY_H, true);
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