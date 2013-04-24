/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Color;
import javax.swing.JFrame;

/**
 *
 * @author TheToiletpaper
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JFrame testFrame = new JFrame();
        LogPaaGUI lpg = new LogPaaGUI();
        testFrame.setSize(1280, 720);
        testFrame.add(lpg);
        testFrame.setVisible(true);
        testFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
    }
}
