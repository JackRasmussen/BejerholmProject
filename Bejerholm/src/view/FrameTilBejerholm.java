package view;

import javax.swing.JFrame;

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
//        OrdreForm ordform = new OrdreForm();
//        try {
//            JFrame frame2 = new JFrame();
//            frame2.setSize(595, 842);
//            frame2.add(ordform);
//            frame2.setVisible(true);
//            PDFWriter pdw = new PDFWriter(ordform, "Ordre");
//            pdw.writePDF();
//        } catch (FileNotFoundException ex) {
//            Logger.getLogger(FrameTilBejerholm.class.getName()).log(Level.SEVERE, null, ex);
//        }
        
    }

}
