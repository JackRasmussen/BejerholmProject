/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.CardLayout;
import view.admin.AdminBronzeGUI;
import view.admin.AdminFuglGUI;
import view.admin.AdminGravstenGUI;
import view.admin.AdminPlanGUI;
import view.admin.AdminVaseGUI;

/**
 *
 * @author TheToiletpaper
 */
public class AdminGUI extends javax.swing.JPanel {

    AdminBronzeGUI abg = new AdminBronzeGUI();
    AdminFuglGUI afg = new AdminFuglGUI();
    AdminGravstenGUI agg = new AdminGravstenGUI();
    AdminPlanGUI apg = new AdminPlanGUI();
    AdminVaseGUI avg = new AdminVaseGUI();

    public AdminGUI() {
        initComponents();

        cardsAdmin.add(abg);
        cardsAdmin.add(afg);
        cardsAdmin.add(agg);
        cardsAdmin.add(apg);
        cardsAdmin.add(avg);

        lagervare.setModel(new javax.swing.DefaultComboBoxModel(new String[]{
                    "Admin Gravsten", "Admin Bronze Dekorationer", "Admin Granitplaner", "Admin Fuglebade", "Admin Granitvaser"
                }));
        ((CardLayout) cardsAdmin.getLayout()).addLayoutComponent(abg, "Admin Bronze Dekorationer");
        ((CardLayout) cardsAdmin.getLayout()).addLayoutComponent(agg, "Admin Gravsten");
        ((CardLayout) cardsAdmin.getLayout()).addLayoutComponent(apg, "Admin Granitplaner");
        ((CardLayout) cardsAdmin.getLayout()).addLayoutComponent(afg, "Admin Fuglebade");
        ((CardLayout) cardsAdmin.getLayout()).addLayoutComponent(avg, "Admin Granitvaser");
        skiftLagerPanel("Admin Gravsten");
    }

    public void skiftLagerPanel(String jp) {
        ((CardLayout) cardsAdmin.getLayout()).show(cardsAdmin, jp);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lagervare = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        cardsAdmin = new javax.swing.JPanel();

        setBackground(new java.awt.Color(100, 100, 100));

        lagervare.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        cardsAdmin.setLayout(new java.awt.CardLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(660, Short.MAX_VALUE)
                .addComponent(lagervare, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(143, 143, 143)
                .addComponent(jButton1)
                .addGap(348, 348, 348))
            .addComponent(cardsAdmin, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lagervare, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addComponent(cardsAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        ((CardLayout) cardsAdmin.getLayout()).show(cardsAdmin, (String) lagervare.getSelectedItem());
        cardsAdmin.setSize(1280, 480);
    }//GEN-LAST:event_jButton1ActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel cardsAdmin;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox lagervare;
    // End of variables declaration//GEN-END:variables
}
