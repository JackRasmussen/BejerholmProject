package control;

import javax.swing.JFrame;
import javax.swing.JPanel;
import view.LogPaaGUI;
import view.SystemGUI;

/**
 *
 * @author Dan-Philip-N
 */
public class ViewControl {

    private static JFrame frame = new JFrame();
    public static LogPaaGUI lpg = new LogPaaGUI();
    public static SystemGUI sg = new SystemGUI();

    public ViewControl() {
    }

    public static void LogPaaGUI() {
        frame(lpg);
    }

    public static void systemGUI() {
        frame(sg);
    }

    public static void frame(JPanel jp) {
        frame.setSize(1280, 720);
        frame.add(jp);
        frame.setVisible(true);
        frame.setTitle("Bejerholm");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public static void lukNuvaerendeGUI(JPanel jp) {
        frame.getContentPane().remove(jp);
    }
}
