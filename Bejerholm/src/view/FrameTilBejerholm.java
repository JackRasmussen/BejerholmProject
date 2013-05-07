package view;

import java.awt.CardLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

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
        
    }

}
