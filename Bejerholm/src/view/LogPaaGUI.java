package view;

import java.awt.CardLayout;
import javax.swing.JFrame;

/**
 *
 * @author TheToiletpaper
 */
public class LogPaaGUI extends javax.swing.JPanel {
    
    BejerholmGUI beg;

    public LogPaaGUI(BejerholmGUI beg) {
        this.beg = beg;
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        username = new javax.swing.JTextField();
        password = new javax.swing.JTextField();
        hostname = new javax.swing.JTextField();
        port = new javax.swing.JTextField();
        database = new javax.swing.JTextField();
        brugernavnLabel = new javax.swing.JLabel();
        passwordLabel = new javax.swing.JLabel();
        hostnameLabel = new javax.swing.JLabel();
        portLabel = new javax.swing.JLabel();
        login = new javax.swing.JButton();
        databaseLabel = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(100, 100, 100));
        setLayout(null);

        username.setText("root");
        add(username);
        username.setBounds(570, 110, 100, 20);

        password.setText("root");
        add(password);
        password.setBounds(570, 150, 100, 20);

        hostname.setText("localhost");
        add(hostname);
        hostname.setBounds(570, 190, 100, 20);

        port.setText("3306");
        add(port);
        port.setBounds(570, 230, 100, 20);

        database.setText("Bejerholm");
        add(database);
        database.setBounds(570, 270, 100, 20);

        brugernavnLabel.setText("Brugernavn:");
        add(brugernavnLabel);
        brugernavnLabel.setBounds(460, 110, 80, 14);

        passwordLabel.setText("Kodeord:");
        add(passwordLabel);
        passwordLabel.setBounds(460, 150, 80, 14);

        hostnameLabel.setText("Hostname:");
        add(hostnameLabel);
        hostnameLabel.setBounds(460, 190, 80, 14);

        portLabel.setText("Port:");
        add(portLabel);
        portLabel.setBounds(460, 230, 80, 14);

        login.setText("Log på!");
        login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginActionPerformed(evt);
            }
        });
        add(login);
        login.setBounds(520, 340, 110, 23);

        databaseLabel.setText("Database:");
        add(databaseLabel);
        databaseLabel.setBounds(460, 270, 80, 14);

        jButton1.setText("Options!");
        add(jButton1);
        jButton1.setBounds(990, 350, 90, 23);
    }// </editor-fold>//GEN-END:initComponents

    private void loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginActionPerformed
        beg.skiftPanel("OrdreGUI");
    }//GEN-LAST:event_loginActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel brugernavnLabel;
    private javax.swing.JTextField database;
    private javax.swing.JLabel databaseLabel;
    private javax.swing.JTextField hostname;
    private javax.swing.JLabel hostnameLabel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton login;
    private javax.swing.JTextField password;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JTextField port;
    private javax.swing.JLabel portLabel;
    private javax.swing.JTextField username;
    // End of variables declaration//GEN-END:variables
}
