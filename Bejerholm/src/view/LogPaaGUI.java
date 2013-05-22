package view;

import control.Controller;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author TheToiletpaper
 */
public class LogPaaGUI extends javax.swing.JPanel {

    BejerholmGUI beg;
    Controller controller;

    public LogPaaGUI(BejerholmGUI beg) {
        this.beg = beg;
        controller = new Controller();
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
        password = new javax.swing.JPasswordField();

        setBackground(new java.awt.Color(100, 100, 100));
        setLayout(null);

        username.setText("root");
        add(username);
        username.setBounds(570, 110, 100, 28);

        hostname.setText("localhost");
        hostname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hostnameActionPerformed(evt);
            }
        });
        add(hostname);
        hostname.setBounds(570, 190, 100, 28);

        port.setText("3306");
        add(port);
        port.setBounds(570, 230, 100, 28);

        database.setText("Bejerholm");
        add(database);
        database.setBounds(570, 270, 100, 28);

        brugernavnLabel.setForeground(new java.awt.Color(255, 255, 255));
        brugernavnLabel.setText("Brugernavn:");
        add(brugernavnLabel);
        brugernavnLabel.setBounds(460, 110, 80, 16);

        passwordLabel.setForeground(new java.awt.Color(255, 255, 255));
        passwordLabel.setText("Kodeord:");
        add(passwordLabel);
        passwordLabel.setBounds(460, 150, 80, 16);

        hostnameLabel.setForeground(new java.awt.Color(255, 255, 255));
        hostnameLabel.setText("Hostname:");
        add(hostnameLabel);
        hostnameLabel.setBounds(460, 190, 80, 16);

        portLabel.setForeground(new java.awt.Color(255, 255, 255));
        portLabel.setText("Port:");
        add(portLabel);
        portLabel.setBounds(460, 230, 80, 16);

        login.setText("Log på!");
        login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginActionPerformed(evt);
            }
        });
        add(login);
        login.setBounds(570, 340, 90, 29);

        databaseLabel.setForeground(new java.awt.Color(255, 255, 255));
        databaseLabel.setText("Database:");
        add(databaseLabel);
        databaseLabel.setBounds(460, 270, 80, 16);

        jCheckBox1.setBackground(new java.awt.Color(100, 100, 100));
        jCheckBox1.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBox1.setText("Avanceret");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });
        add(jCheckBox1);
        jCheckBox1.setBounds(451, 340, 90, 23);

        password.setText("root");
        add(password);
        password.setBounds(570, 150, 100, 28);
    }// </editor-fold>//GEN-END:initComponents

    private void loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginActionPerformed
        String passwordString = "";
        for (int i = 0; i < password.getPassword().length; i++) {
            passwordString = passwordString + password.getPassword()[i];
        }
        try {
            controller.connectDB(username.getText(), passwordString,
                    hostname.getText(), port.getText(), database.getText(), beg);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Forkerte indstillinger eller forkert password, prøv venligst igen.", 
                    "Advarsel", JOptionPane.WARNING_MESSAGE);
        }
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
    private javax.swing.JPasswordField password;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JTextField port;
    private javax.swing.JLabel portLabel;
    private javax.swing.JTextField username;
    // End of variables declaration//GEN-END:variables
}
