/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view.ordre;

import control.Controller;
import java.awt.Color;
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
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[]{
                    "Rensning", "Opmaling", "Oppudsning",}));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        soegeKnap = new javax.swing.JButton();
        indsaetProduktIOrdreKnap = new javax.swing.JButton();
        produktListe = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        fortsaetKnap = new javax.swing.JButton();
<<<<<<< HEAD
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(100, 100, 100));

=======

        setBackground(new java.awt.Color(100, 100, 100));

        jLabel1.setText("Tilføjelsestype:");

>>>>>>> a97dbf69963c103e96a8b97144608a25a58076f2
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

        produktListe.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        produktListe.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        produktListe.setViewportView(jPanel1);

        fortsaetKnap.setText("Spring over");
        fortsaetKnap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fortsaetKnapActionPerformed(evt);
            }
        });

<<<<<<< HEAD
        jLabel3.setForeground(new java.awt.Color(240, 240, 240));
        jLabel3.setText("Navn:");

        jLabel2.setForeground(new java.awt.Color(240, 240, 240));
        jLabel2.setText("VareID:");

        jLabel4.setForeground(new java.awt.Color(240, 240, 240));
        jLabel4.setText("Type:");

        jLabel5.setForeground(new java.awt.Color(240, 240, 240));
        jLabel5.setText("Antal:");

        jLabel8.setForeground(new java.awt.Color(240, 240, 240));
        jLabel8.setText("Pris:");

        jLabel6.setForeground(new java.awt.Color(240, 240, 240));
        jLabel6.setText("Længde:");

        jLabel7.setForeground(new java.awt.Color(240, 240, 240));
        jLabel7.setText("Bredde:");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jButton1.setText("Vis alle tilføjelser");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

=======
>>>>>>> a97dbf69963c103e96a8b97144608a25a58076f2
        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(produktListe)
                    .add(layout.createSequentialGroup()
<<<<<<< HEAD
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                            .add(layout.createSequentialGroup()
                                .add(10, 10, 10)
                                .add(jLabel2)
                                .add(145, 145, 145)
                                .add(jLabel3)
                                .add(144, 144, 144)
                                .add(jLabel4)
                                .add(86, 86, 86)
                                .add(jLabel5)
                                .add(130, 130, 130))
                            .add(org.jdesktop.layout.GroupLayout.LEADING, layout.createSequentialGroup()
                                .add(227, 227, 227)
                                .add(jButton1)
                                .add(18, 18, 18)
                                .add(soegeKnap)
                                .add(18, 18, 18)
                                .add(jComboBox1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .add(18, 18, 18)
                                .add(indsaetProduktIOrdreKnap)))
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                            .add(layout.createSequentialGroup()
                                .add(jLabel6)
                                .add(82, 82, 82)
                                .add(jLabel7)
                                .add(101, 101, 101)
                                .add(jLabel8))
                            .add(fortsaetKnap))
                        .add(0, 289, Short.MAX_VALUE)))
=======
                        .add(jLabel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 129, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(4, 4, 4)
                        .add(jTextField1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 167, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(18, 18, 18)
                        .add(soegeKnap)
                        .add(18, 18, 18)
                        .add(indsaetProduktIOrdreKnap)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 599, Short.MAX_VALUE)
                        .add(fortsaetKnap)))
>>>>>>> a97dbf69963c103e96a8b97144608a25a58076f2
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(28, 28, 28)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(soegeKnap)
                    .add(indsaetProduktIOrdreKnap)
                    .add(fortsaetKnap)
<<<<<<< HEAD
                    .add(jComboBox1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jButton1))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                        .add(jLabel7)
                        .add(jLabel6)
                        .add(jLabel8)
                        .add(jLabel5)
                        .add(jLabel4)
                        .add(jLabel3))
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jLabel2))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(produktListe, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 387, Short.MAX_VALUE)
=======
                    .add(jLabel1))
                .add(30, 30, 30)
                .add(produktListe, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
>>>>>>> a97dbf69963c103e96a8b97144608a25a58076f2
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    public void foejTilListeAfTilfoejelser(int tilfoejelsesID, String tilfoejelsesType, double tilfoejelsesPris) {
        TilfojelseTilListe ttl = new TilfojelseTilListe(tilfoejelsesID, tilfoejelsesType, tilfoejelsesPris);
        listeAfTilfoejelser.add(ttl);
    }

    private void soegeKnapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_soegeKnapActionPerformed
        listeAfTilfoejelser.clear();

        Controller controller = new Controller();
        controller.connSoegEfterTilfoejelse(jComboBox1.getSelectedItem().toString(), this);

        jPanel1.removeAll();
        for (int i = 0; i < listeAfTilfoejelser.size(); i++) {
            jPanel1.add(listeAfTilfoejelser.get(i));
        }
        jPanel1.setPreferredSize(new Dimension(1272, jPanel1.getComponentCount() * 45));
        produktListe.revalidate();
        produktListe.repaint();
    }//GEN-LAST:event_soegeKnapActionPerformed

    private void fortsaetKnapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fortsaetKnapActionPerformed
        if (ordreGUI.isKirkegaardsOrdre()) {
            ordreGUI.skiftOrdrePanel("KirkegaardGUI");
            ordreGUI.getBtilføjelser().setBackground(new Color(240, 240, 240));
            ordreGUI.getKirkegarrd().setBackground(new Color(150, 150, 150));
        } else {
            ordreGUI.skiftOrdrePanel("BestillingsOrdreGUI");
            ordreGUI.getTilføjelser().setBackground(new Color(240, 240, 240));
            ordreGUI.getOrdre().setBackground(new Color(150, 150, 150));
        }

    }//GEN-LAST:event_fortsaetKnapActionPerformed

    private void indsaetProduktIOrdreKnapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_indsaetProduktIOrdreKnapActionPerformed
        for (int i = 0; i < listeAfTilfoejelser.size(); i++) {
            if (listeAfTilfoejelser.get(i).isChosen()) {
                listeAfTilfoejelserTilOrdre.add(listeAfTilfoejelser.get(i));
            }
        }
        if (listeAfTilfoejelserTilOrdre.isEmpty()) {
            fortsaetKnap.setText("Spring over");
        } else {
            fortsaetKnap.setText("Videre");
        }
    }//GEN-LAST:event_indsaetProduktIOrdreKnapActionPerformed
<<<<<<< HEAD

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        listeAfTilfoejelser.clear();

        Controller controller = new Controller();
        controller.connSoegEfterTilfoejelse("", this);

        jPanel1.removeAll();
        for (int i = 0; i < listeAfTilfoejelser.size(); i++) {
            jPanel1.add(listeAfTilfoejelser.get(i));
        }
        jPanel1.setPreferredSize(new Dimension(1272, jPanel1.getComponentCount() * 45));
        produktListe.revalidate();
        produktListe.repaint();
    }//GEN-LAST:event_jButton1ActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton fortsaetKnap;
    private javax.swing.JButton indsaetProduktIOrdreKnap;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
=======
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton fortsaetKnap;
    private javax.swing.JButton indsaetProduktIOrdreKnap;
    private javax.swing.JLabel jLabel1;
>>>>>>> a97dbf69963c103e96a8b97144608a25a58076f2
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane produktListe;
    private javax.swing.JButton soegeKnap;
    // End of variables declaration//GEN-END:variables

    public ArrayList<TilfojelseTilListe> getListeAfTilfoejelserTilOrdre() {
        return listeAfTilfoejelserTilOrdre;
    }
}
