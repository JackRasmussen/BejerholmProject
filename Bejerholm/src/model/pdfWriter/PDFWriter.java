package model.pdfWriter;

import com.itextpdf.awt.PdfGraphics2D;
import com.itextpdf.text.Document;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfTemplate;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Graphics2D;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import javax.swing.JPanel;

/**
 * Denne klasse har 2 constructorer, den ene tager et input af en String og et
 * jPanel. Den laver en fil i klassemappen. Den anden constructor har et input
 * af en File og et JPanel. Den kan bruges med eksempelvis en jFileChooser.
 *
 * @author Dan-Philip Christensen
 */
public class PDFWriter {

    JPanel panelToPrint;
    FileOutputStream destination;
    File file;

    public PDFWriter(JPanel panelToPrint, String fileName) throws FileNotFoundException {
        this.panelToPrint = panelToPrint;
        this.file = new File(this.getClass().getResource("").getPath() + fileName + ".pdf");
        System.out.println(this.getClass().getResource("").getPath() + fileName + ".pdf");
        this.destination = new FileOutputStream(file);
    }

    public PDFWriter(JPanel panelToPrint, File destinationFile) throws FileNotFoundException {
        this.panelToPrint = panelToPrint;
        this.file = destinationFile;
        this.destination = new FileOutputStream(file);
    }

    /**
     * Denne metode skriver pdf data til en fil. Den pågældende fil skal være
     * defineret i constructoren for denne klasse. Dette kan enten være
     * constructoren der modtager en fil (f.eks fra file chooser) eller en der
     * modtager en String til filnavn, hvorefter den ligger den i mappen for
     * denne klasse.
     */
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
