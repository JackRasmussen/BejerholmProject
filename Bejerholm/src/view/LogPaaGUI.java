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
        hostname.setVisible(false);
        hostnameLabel.setVisible(false);
        port.setVisible(false);
        portLabel.setVisible(false);
        database.setVisible(false);
        databaseLabel.setVisible(false);
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
        jCheckBox1 = new javax.swing.JCheckBox();

        setBackground(new java.awt.Color(100, 100, 100));
        setLayout(null);

        username.setText("root");
        add(username);
        username.setBounds(570, 110, 100, 20);

        password.setText("root");
        add(password);
        password.setBounds(570, 150, 100, 20);

        hostname.setText("localhost");
        hostname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hostnameActionPerformed(evt);
            }
        });
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
        login.setBounds(570, 340, 90, 23);

        databaseLabel.setText("Database:");
        add(databaseLabel);
        databaseLabel.setBounds(460, 270, 80, 14);

        jCheckBox1.setBackground(new java.awt.Color(100, 100, 100));
        jCheckBox1.setText("Avanceret");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });
        add(jCheckBox1);
        jCheckBox1.setBounds(451, 340, 90, 23);
    }// </editor-fold>//GEN-END:initComponents

    private void loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginActionPerformed
        beg.skiftPanel("OrdreGUI");
    }//GEN-LAST:event_loginActionPerformed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        if (jCheckBox1.isSelected()) {
            hostname.setVisible(true);
            hostnameLabel.setVisible(true);
            port.setVisible(true);
            portLabel.setVisible(true);
            database.setVisible(true);
            databaseLabel.setVisible(true);
        } else {
            hostname.setVisible(false);
            hostnameLabel.setVisible(false);
            port.setVisible(false);
            portLabel.setVisible(false);
            database.setVisible(false);
            databaseLabel.setVisible(false);
        }

    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void hostnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hostnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_hostnameActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel brugernavnLabel;
    private javax.swing.JTextField database;
    private javax.swing.JLabel databaseLabel;
    private javax.swing.JTextField hostname;
    private javax.swing.JLabel hostnameLabel;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JButton login;
    private javax.swing.JTextField password;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JTextField port;
    private javax.swing.JLabel portLabel;
    private javax.swing.JTextField username;
    // End of variables declaration//GEN-END:variables
}
