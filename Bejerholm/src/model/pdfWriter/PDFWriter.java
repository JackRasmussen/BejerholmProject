package model.pdfWriter;

import com.itextpdf.awt.PdfGraphics2D;
import com.itextpdf.text.Document;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfTemplate;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Graphics2D;
import java.io.FileOutputStream;
import javax.swing.JPanel;

/**
 * @author Dan-Philip Christensen
 */
public class PDFWriter {

    JPanel panelToPrint;
    FileOutputStream destination;

    public PDFWriter(JPanel panelToPrint, FileOutputStream destination) {
        this.panelToPrint = panelToPrint;
        this.destination = destination;
    }

    public void writePDF() {
        try {
            FileOutputStream fIO = destination;
            Document document = new Document(PageSize.A4);
            PdfWriter pdfWriter = PdfWriter.getInstance(document, fIO);
            document.open();
            PdfContentByte contentByte = pdfWriter.getDirectContent();
            PdfTemplate template = contentByte.createTemplate(PageSize.A4.getWidth(), PageSize.A4.getHeight());
            Graphics2D g2d = new PdfGraphics2D(contentByte, PageSize.A4.getWidth(), PageSize.A4.getHeight());
            panelToPrint.printAll(g2d);
            g2d.dispose();
            contentByte.addTemplate(template, 0, 0);
            document.close();
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
}
