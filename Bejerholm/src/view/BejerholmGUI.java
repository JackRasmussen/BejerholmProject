package view;

import java.awt.CardLayout;
import javax.swing.JPanel;

/**
 *
 * @author TheToiletpaper
 */
public class BejerholmGUI extends javax.swing.JPanel {
    OrdreGUI org = new OrdreGUI();
    LogPaaGUI lpg = new LogPaaGUI(this);
    AdminGUI adg = new AdminGUI();
    LagerGUI lag = new LagerGUI();
    
   
    

    public BejerholmGUI() {
        initComponents();
        cards.add(org);
        cards.add(lpg);
        cards.add(adg);
        cards.add(lag);
        
        
        ((CardLayout) cards.getLayout()).addLayoutComponent(org, "OrdreGUI");
        ((CardLayout) cards.getLayout()).addLayoutComponent(lpg, "LogPaaGUI");
        ((CardLayout) cards.getLayout()).addLayoutComponent(adg, "AdminGUI");
        ((CardLayout) cards.getLayout()).addLayoutComponent(lag, "LagerGUI");
//         skiftPanel("LogPaaGUI");
         skiftPanel("LagerGUI");
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
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        lager = new javax.swing.JButton();
        cards = new javax.swing.JPanel();

        jPanel1.setBackground(new java.awt.Color(100, 100, 100));
        jPanel1.setLayout(null);

        topBillede.setBackground(new java.awt.Color(0, 0, 0));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/bejerholm.png"))); // NOI18N

        jPanel2.setBackground(new java.awt.Color(156, 23, 6));

        jButton1.setText("Ordre");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Admin");

        jButton3.setText("Log af!");

        lager.setText("Lager");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lager)
                .addGap(218, 218, 218)
                .addComponent(jButton3)
                .addGap(473, 473, 473))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(lager))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout topBilledeLayout = new javax.swing.GroupLayout(topBillede);
        topBillede.setLayout(topBilledeLayout);
        topBilledeLayout.setHorizontalGroup(
            topBilledeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(topBilledeLayout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addComponent(jLabel1)
                .addContainerGap(746, Short.MAX_VALUE))
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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        ((CardLayout) cards.getLayout()).next(cards);
    }//GEN-LAST:event_jButton1ActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel cards;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton lager;
    private javax.swing.JPanel topBillede;
    // End of variables declaration//GEN-END:variables
}
