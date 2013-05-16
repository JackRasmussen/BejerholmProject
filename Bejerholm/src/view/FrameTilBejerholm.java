package view;

import java.awt.CardLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import model.pdfWriter.PDFWriter;
import view.faktura.OrdreForm;

/**
 *
 * @author TheToiletpaper
 */
public class FrameTilBejerholm {
    
    JFrame frame = new JFrame();
    BejerholmGUI bg = new BejerholmGUI();
    
    public FrameTilBejerholm(){
        frame.setSize(1280, 720);
        frame.add(bg);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setFocusable(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        OrdreForm ordform = new OrdreForm();
        PDFWriter pdw = new PDFWriter(ordform, "Ordre1");
        
    }

}
