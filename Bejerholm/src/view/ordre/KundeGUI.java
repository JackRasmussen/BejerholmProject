/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view.ordre;

import java.awt.CardLayout;
import view.AdminGUI;
import view.OrdreGUI;

/**
 *
 * @author TheToiletpaper
 */
public class KundeGUI extends javax.swing.JPanel {

    OrdreGUI org;

    public KundeGUI(OrdreGUI org) {
        initComponents();
        adressFelt.setVisible(false);
        adressLabel.setVisible(false);
        byFelt.setVisible(false);
        byLabel.setVisible(false);
        eNavnFelt.setVisible(false);
        eNavnLabel.setVisible(false);
        fNavnFelt.setVisible(false);
        fNavnLabel.setVisible(false);
        mobTlfFelt.setVisible(false);
        mobTlfLabel.setVisible(false);
        postFelt.setVisible(false);
        postLabel.setVisible(false);
        videreKnap.setVisible(false);
        opretKundeKnap.setVisible(false);
        this.org = org;

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        soegKundeFelt = new javax.swing.JTextField();
        soegKundeKnap = new javax.swing.JButton();
        soegKundeLabel = new javax.swing.JLabel();
        fNavnFelt = new javax.swing.JTextField();
        fNavnLabel = new javax.swing.JLabel();
        opretKundeKnap = new javax.swing.JButton();
        videreKnap = new javax.swing.JButton();
        eNavnLabel = new javax.swing.JLabel();
        eNavnFelt = new javax.swing.JTextField();
        adressLabel = new javax.swing.JLabel();
        postLabel = new javax.swing.JLabel();
        byLabel = new javax.swing.JLabel();
        adressFelt = new javax.swing.JTextField();
        postFelt = new javax.swing.JTextField();
        byFelt = new javax.swing.JTextField();
        mobTlfLabel = new javax.swing.JLabel();
        mobTlfFelt = new javax.swing.JTextField();

        setBackground(new java.awt.Color(100, 100, 100));

        soegKundeKnap.setText("Søg kunde");
        soegKundeKnap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                soegKundeKnapActionPerformed(evt);
            }
        });

        soegKundeLabel.setForeground(new java.awt.Color(255, 255, 255));
        soegKundeLabel.setText("Søg på kunde tlf. nr:");

        fNavnLabel.setForeground(new java.awt.Color(255, 255, 255));
        fNavnLabel.setText("Fornavn:");

        opretKundeKnap.setText("Opret kunde");
        opretKundeKnap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opretKundeKnapActionPerformed(evt);
            }
        });

        videreKnap.setText("Videre");
        videreKnap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                videreKnapActionPerformed(evt);
            }
        });

        eNavnLabel.setForeground(new java.awt.Color(255, 255, 255));
        eNavnLabel.setText("Efternavn");

        adressLabel.setForeground(new java.awt.Color(255, 255, 255));
        adressLabel.setText("Adresse:");

        postLabel.setForeground(new java.awt.Color(255, 255, 255));
        postLabel.setText("Postnummer:");

        byLabel.setForeground(new java.awt.Color(255, 255, 255));
        byLabel.setText("By:");

        mobTlfLabel.setForeground(new java.awt.Color(255, 255, 255));
        mobTlfLabel.setText("Mobil tlf:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(347, 347, 347)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(videreKnap)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(fNavnLabel)
                            .addComponent(soegKundeLabel)
                            .addComponent(eNavnLabel)
                            .addComponent(adressLabel)
                            .addComponent(postLabel)
                            .addComponent(byLabel)
                            .addComponent(mobTlfLabel))
                        .addGap(89, 89, 89)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(fNavnFelt, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                            .addComponent(soegKundeFelt, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                            .addComponent(eNavnFelt, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                            .addComponent(adressFelt, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                            .addComponent(postFelt, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                            .addComponent(mobTlfFelt, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                            .addComponent(byFelt))
                        .addGap(46, 46, 46)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(opretKundeKnap)
                            .addComponent(soegKundeKnap))))
                .addContainerGap(391, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(soegKundeFelt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(soegKundeKnap)
                    .addComponent(soegKundeLabel))
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fNavnFelt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fNavnLabel))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(eNavnLabel)
                    .addComponent(eNavnFelt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(adressLabel)
                    .addComponent(adressFelt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(postLabel)
                    .addComponent(postFelt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(byLabel)
                    .addComponent(byFelt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mobTlfLabel)
                    .addComponent(mobTlfFelt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(opretKundeKnap)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(videreKnap)
                .addContainerGap(42, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void videreKnapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_videreKnapActionPerformed
        org.skiftOrdrePanel("BestillingsOrdreGUI");
    }//GEN-LAST:event_videreKnapActionPerformed

    private void soegKundeKnapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_soegKundeKnapActionPerformed
        // hvis kunde er fundet i databasen skal felterne udfyldes, 
        //hvis ikke kunden er fundet, skal Bejerholm blive bedt om at udfylde 
        //oplysningerne selv.
        //hvis kunden er fundet skal opretKundeKnap ikke sættes til visible, 
        //og videreKnap skal sættes til visible.
        //og omvendt hvis kunden ikke er fundet.

        adressFelt.setVisible(true);
        adressLabel.setVisible(true);
        byFelt.setVisible(true);
        byLabel.setVisible(true);
        eNavnFelt.setVisible(true);
        eNavnLabel.setVisible(true);
        fNavnFelt.setVisible(true);
        fNavnLabel.setVisible(true);
        mobTlfFelt.setVisible(true);
        mobTlfLabel.setVisible(true);
        postFelt.setVisible(true);
        postLabel.setVisible(true);
        videreKnap.setVisible(false);
        opretKundeKnap.setVisible(true);
    }//GEN-LAST:event_soegKundeKnapActionPerformed

    private void opretKundeKnapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opretKundeKnapActionPerformed
        org.skiftOrdrePanel("BestillingsOrdreGUI");
        fNavnFelt.setText("");
        eNavnFelt.setText("");
        adressFelt.setText("");
        postFelt.setText("");
        byFelt.setText("");
        mobTlfFelt.setText("");
        soegKundeFelt.setText("");
    }//GEN-LAST:event_opretKundeKnapActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField adressFelt;
    private javax.swing.JLabel adressLabel;
    private javax.swing.JTextField byFelt;
    private javax.swing.JLabel byLabel;
    private javax.swing.JTextField eNavnFelt;
    private javax.swing.JLabel eNavnLabel;
    private javax.swing.JTextField fNavnFelt;
    private javax.swing.JLabel fNavnLabel;
    private javax.swing.JTextField mobTlfFelt;
    private javax.swing.JLabel mobTlfLabel;
    private javax.swing.JButton opretKundeKnap;
    private javax.swing.JTextField postFelt;
    private javax.swing.JLabel postLabel;
    private javax.swing.JTextField soegKundeFelt;
    private javax.swing.JButton soegKundeKnap;
    private javax.swing.JLabel soegKundeLabel;
    private javax.swing.JButton videreKnap;
    // End of variables declaration//GEN-END:variables

    public void setFelter(String fNavnFelt, String eNavnFelt, String adresseFelt, int postFelt, String byFelt, int mobTlfFelt) {
        this.fNavnFelt.setText(fNavnFelt);
        this.eNavnFelt.setText(eNavnFelt);
        this.adressFelt.setText(adresseFelt);
        this.postFelt.setText(postFelt + "");
        this.byFelt.setText(byFelt);
        this.mobTlfFelt.setText(mobTlfFelt + "");
    }
}
