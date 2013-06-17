package view;

import control.Controller;
import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.JButton;

/**
 *
 * @author TheToiletpaper
 */
public class BejerholmGUI extends javax.swing.JPanel {

    OrdreGUI org = new OrdreGUI();
    LogPaaGUI lpg = new LogPaaGUI(this);
    AdminGUI adg = new AdminGUI();
    LagerGUI lag = new LagerGUI();
    OrdreRedigering orrg = new OrdreRedigering();

    public BejerholmGUI() {
        initComponents();
        cards.add(org);
        cards.add(lpg);
        cards.add(adg);
        cards.add(lag);
        cards.add(orrg);
        lager.setVisible(false);
        admin.setVisible(false);
        ordre.setVisible(false);
        logaf.setVisible(false);
        faktura.setVisible(false);

        ((CardLayout) cards.getLayout()).addLayoutComponent(org, "OrdreGUI");
        ((CardLayout) cards.getLayout()).addLayoutComponent(lpg, "LogPaaGUI");
        ((CardLayout) cards.getLayout()).addLayoutComponent(adg, "AdminGUI");
        ((CardLayout) cards.getLayout()).addLayoutComponent(lag, "LagerGUI");
        ((CardLayout) cards.getLayout()).addLayoutComponent(orrg, "OrdreRedigering");
        skiftPanel("LogPaaGUI");
    }

    public void skiftPanel(String jp) {
        ((CardLayout) cards.getLayout()).show(cards, jp);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        topBillede = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        ordre = new javax.swing.JButton();
        admin = new javax.swing.JButton();
        logaf = new javax.swing.JButton();
        lager = new javax.swing.JButton();
        faktura = new javax.swing.JButton();
        cards = new javax.swing.JPanel();

        jPanel1.setBackground(new java.awt.Color(100, 100, 100));
        jPanel1.setLayout(null);

        topBillede.setBackground(new java.awt.Color(0, 0, 0));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/bejerholm.png"))); // NOI18N

        jPanel2.setBackground(new java.awt.Color(156, 23, 6));

        ordre.setBackground(new java.awt.Color(136, 23, 6));
        ordre.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ordre.setForeground(new java.awt.Color(255, 255, 255));
        ordre.setText("Ordre");
        ordre.setToolTipText("");
        ordre.setBorderPainted(false);
        ordre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ordreMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ordreMouseExited(evt);
            }
        });
        ordre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ordreActionPerformed(evt);
            }
        });

        admin.setBackground(new java.awt.Color(136, 23, 6));
        admin.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        admin.setForeground(new java.awt.Color(255, 255, 255));
        admin.setText("Admin");
        admin.setToolTipText("");
        admin.setBorderPainted(false);
        admin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                adminMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                adminMouseExited(evt);
            }
        });
        admin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adminActionPerformed(evt);
            }
        });

        logaf.setBackground(new java.awt.Color(136, 23, 6));
        logaf.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        logaf.setForeground(new java.awt.Color(255, 255, 255));
        logaf.setText("Log af!");
        logaf.setToolTipText("");
        logaf.setBorderPainted(false);
        logaf.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                logafMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                logafMouseEntered(evt);
            }
        });
        logaf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logafActionPerformed(evt);
            }
        });

        lager.setBackground(new java.awt.Color(136, 23, 6));
        lager.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lager.setForeground(new java.awt.Color(255, 255, 255));
        lager.setText("Lager");
        lager.setToolTipText("");
        lager.setBorderPainted(false);
        lager.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lagerMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lagerMouseExited(evt);
            }
        });
        lager.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lagerActionPerformed(evt);
            }
        });

        faktura.setBackground(new java.awt.Color(136, 23, 6));
        faktura.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        faktura.setForeground(new java.awt.Color(255, 255, 255));
        faktura.setText("Rediger ordre");
        faktura.setToolTipText("");
        faktura.setBorderPainted(false);
        faktura.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                fakturaMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                fakturaMouseEntered(evt);
            }
        });
        faktura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fakturaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(120, 120, 120)
                .addComponent(ordre, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(75, 75, 75)
                .addComponent(admin, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(75, 75, 75)
                .addComponent(lager, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(75, 75, 75)
                .addComponent(faktura)
                .addGap(353, 353, 353)
                .addComponent(logaf, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(ordre, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(logaf, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(admin, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lager, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(faktura, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 129, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout topBilledeLayout = new javax.swing.GroupLayout(topBillede);
        topBillede.setLayout(topBilledeLayout);
        topBilledeLayout.setHorizontalGroup(
            topBilledeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(topBilledeLayout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addComponent(jLabel1)
                .addContainerGap())
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        topBilledeLayout.setVerticalGroup(
            topBilledeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, topBilledeLayout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(topBillede);
        topBillede.setBounds(0, 0, 1280, 200);

        cards.setForeground(new java.awt.Color(255, 255, 255));
        cards.setToolTipText("");
        cards.setPreferredSize(new java.awt.Dimension(1280, 520));
        cards.setLayout(new java.awt.CardLayout());
        jPanel1.add(cards);
        cards.setBounds(0, 200, 1280, 520);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1280, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1280, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 720, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 720, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void ordreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ordreActionPerformed
        skiftPanel("OrdreGUI");

    }//GEN-LAST:event_ordreActionPerformed

    private void adminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adminActionPerformed
        skiftPanel("AdminGUI");
    }//GEN-LAST:event_adminActionPerformed

    private void lagerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lagerActionPerformed
        skiftPanel("LagerGUI");
    }//GEN-LAST:event_lagerActionPerformed

    private void logafActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logafActionPerformed
        Controller controller = new Controller();
        controller.closeDBConnection(this);
    }//GEN-LAST:event_logafActionPerformed

    private void lagerMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lagerMouseEntered
        lager.setBackground(new Color(209, 23, 6));
    }//GEN-LAST:event_lagerMouseEntered

    private void lagerMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lagerMouseExited
        lager.setBackground(new Color(136, 23, 6));
    }//GEN-LAST:event_lagerMouseExited

    private void adminMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_adminMouseEntered
        admin.setBackground(new Color(209, 23, 6));
    }//GEN-LAST:event_adminMouseEntered

    private void adminMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_adminMouseExited
        admin.setBackground(new Color(136, 23, 6));
    }//GEN-LAST:event_adminMouseExited

    private void ordreMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ordreMouseEntered
        ordre.setBackground(new Color(209, 23, 6));
    }//GEN-LAST:event_ordreMouseEntered

    private void ordreMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ordreMouseExited
        ordre.setBackground(new Color(136, 23, 6));
    }//GEN-LAST:event_ordreMouseExited

    private void logafMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logafMouseEntered
        logaf.setBackground(new Color(209, 23, 6));
    }//GEN-LAST:event_logafMouseEntered

    private void logafMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logafMouseExited
        logaf.setBackground(new Color(136, 23, 6));
    }//GEN-LAST:event_logafMouseExited

    private void fakturaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fakturaMouseEntered
        faktura.setBackground(new Color(209, 23, 6));
    }//GEN-LAST:event_fakturaMouseEntered

    private void fakturaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fakturaMouseExited
        faktura.setBackground(new Color(136, 23, 6));
    }//GEN-LAST:event_fakturaMouseExited

    private void fakturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fakturaActionPerformed
        skiftPanel("OrdreRedigering");
    }//GEN-LAST:event_fakturaActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton admin;
    private javax.swing.JPanel cards;
    private javax.swing.JButton faktura;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton lager;
    private javax.swing.JButton logaf;
    private javax.swing.JButton ordre;
    private javax.swing.JPanel topBillede;
    // End of variables declaration//GEN-END:variables

    public JButton getAdmin() {
        return admin;
    }

    public JButton getLager() {
        return lager;
    }

    public JButton getOrdre() {
        return ordre;
    }

    public JButton getLogaf() {
        return logaf;
    }

    public JButton getFaktura() {
        return faktura;
    }
}
