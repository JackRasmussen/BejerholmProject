/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view.ordre;

import java.awt.Dimension;
import java.util.ArrayList;
import view.OrdreGUI;

/**
 *
 * @author Dan-Philip Christensen
 */
public class TilfoejelseGUI extends javax.swing.JPanel {

    OrdreGUI ordreGUI;
    ArrayList<TilfojelseTilListe> listeAfTilfoejelser;
    ArrayList<TilfojelseTilListe> listeAfTilfoejelserTilOrdre;

    public TilfoejelseGUI(OrdreGUI org) {
        listeAfTilfoejelser = new ArrayList<>();
        listeAfTilfoejelserTilOrdre = new ArrayList<>();
        ordreGUI = org;
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        soegeKnap = new javax.swing.JButton();
        indsaetProduktIOrdreKnap = new javax.swing.JButton();
        produktListe = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        fortsaetKnap = new javax.swing.JButton();

        setBackground(new java.awt.Color(100, 100, 100));

        jLabel1.setText("Tilføjelsestype:");

        soegeKnap.setText("Søg");
        soegeKnap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                soegeKnapActionPerformed(evt);
            }
        });

        indsaetProduktIOrdreKnap.setText("Indsæt valgte tilføjelse i ordre");
        indsaetProduktIOrdreKnap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                indsaetProduktIOrdreKnapActionPerformed(evt);
            }
        });

        produktListe.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        produktListe.setViewportView(jPanel1);

        fortsaetKnap.setText("Videre");
        fortsaetKnap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fortsaetKnapActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(produktListe)
                    .add(layout.createSequentialGroup()
                        .add(jLabel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 129, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(4, 4, 4)
                        .add(jTextField1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 167, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(18, 18, 18)
                        .add(soegeKnap)
                        .add(18, 18, 18)
                        .add(indsaetProduktIOrdreKnap)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 631, Short.MAX_VALUE)
                        .add(fortsaetKnap)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(28, 28, 28)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jTextField1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(soegeKnap)
                    .add(indsaetProduktIOrdreKnap)
                    .add(fortsaetKnap)
                    .add(jLabel1))
                .add(30, 30, 30)
                .add(produktListe, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void soegeKnapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_soegeKnapActionPerformed
        TilfojelseTilListe ttl = new TilfojelseTilListe(1, "Test", 50.5);
        listeAfTilfoejelser.add(ttl);

        jPanel1.removeAll();
        for (int i = 0; i < listeAfTilfoejelser.size(); i++) {
            jPanel1.add(listeAfTilfoejelser.get(i));
        }
        jPanel1.setPreferredSize(new Dimension(1272, jPanel1.getComponentCount() * 45));
        produktListe.revalidate();
    }//GEN-LAST:event_soegeKnapActionPerformed

    private void fortsaetKnapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fortsaetKnapActionPerformed
        ordreGUI.skiftOrdrePanel("BestillingsOrdreGUI");
    }//GEN-LAST:event_fortsaetKnapActionPerformed

    private void indsaetProduktIOrdreKnapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_indsaetProduktIOrdreKnapActionPerformed
        for (int i = 0; i < listeAfTilfoejelser.size(); i++) {
            if (listeAfTilfoejelser.get(i).isChosen()) {
                listeAfTilfoejelserTilOrdre.add(listeAfTilfoejelser.get(i));
            }
        }
    }//GEN-LAST:event_indsaetProduktIOrdreKnapActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton fortsaetKnap;
    private javax.swing.JButton indsaetProduktIOrdreKnap;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JScrollPane produktListe;
    private javax.swing.JButton soegeKnap;
    // End of variables declaration//GEN-END:variables
}
