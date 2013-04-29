package view;

import javax.swing.JFrame;

public class LogPaaGUI extends javax.swing.JPanel {
    
public LogPaaGUI() {
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
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        login1 = new javax.swing.JButton();
        topBillede = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(100, 100, 100));
        setLayout(null);

        username.setText("root");
        add(username);
        username.setBounds(600, 240, 100, 20);

        password.setText("root");
        add(password);
        password.setBounds(600, 280, 100, 20);

        hostname.setText("localhost");
        add(hostname);
        hostname.setBounds(600, 320, 100, 20);

        port.setText("3306");
        add(port);
        port.setBounds(600, 360, 100, 20);

        database.setText("Bejerholm");
        add(database);
        database.setBounds(600, 400, 100, 20);

        jLabel7.setText("Brugernavn:");
        add(jLabel7);
        jLabel7.setBounds(490, 240, 80, 14);

        jLabel9.setText("Kodeord:");
        add(jLabel9);
        jLabel9.setBounds(490, 280, 80, 14);

        jLabel8.setText("Hostname:");
        add(jLabel8);
        jLabel8.setBounds(490, 320, 80, 14);

        jLabel6.setText("Port:");
        add(jLabel6);
        jLabel6.setBounds(490, 360, 80, 14);

        login1.setText("Log på!");
        login1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                login1ActionPerformed(evt);
            }
        });
        add(login1);
        login1.setBounds(550, 470, 110, 23);

        topBillede.setBackground(new java.awt.Color(0, 0, 0));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/bejerholm.png"))); // NOI18N

        jPanel1.setBackground(new java.awt.Color(156, 23, 6));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1266, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout topBilledeLayout = new javax.swing.GroupLayout(topBillede);
        topBillede.setLayout(topBilledeLayout);
        topBilledeLayout.setHorizontalGroup(
            topBilledeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(topBilledeLayout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(topBilledeLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        topBilledeLayout.setVerticalGroup(
            topBilledeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, topBilledeLayout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        add(topBillede);
        topBillede.setBounds(0, 0, 1266, 200);

        jLabel2.setText("Database:");
        add(jLabel2);
        jLabel2.setBounds(490, 400, 80, 14);
    }// </editor-fold>//GEN-END:initComponents

    private void login1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_login1ActionPerformed
<<<<<<< HEAD
        control.ViewControl.lukNuvaerendeGUI(control.ViewControl.lpg);
        control.ViewControl.systemGUI();
=======
//        dbconnect = new DBConnection(username.getText(), password.getText(),
//            hostname.getText(), port.getText(), database.getText());
//        if (dbconnect.connection()){
//        }
>>>>>>> origin/ModelDP
    }//GEN-LAST:event_login1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField database;
    private javax.swing.JTextField hostname;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton login1;
    private javax.swing.JTextField password;
    private javax.swing.JTextField port;
    private javax.swing.JPanel topBillede;
    private javax.swing.JTextField username;
    // End of variables declaration//GEN-END:variables

    

}
