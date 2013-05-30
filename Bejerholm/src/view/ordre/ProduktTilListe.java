package view.ordre;

import javax.swing.JLabel;

/**
 *
 * @author Dan-Philip-N
 */
public class ProduktTilListe extends javax.swing.JPanel {

    public ProduktTilListe(int produktID, String produktNavn, String produktType, int produktAntalIDB, double maalX, double maalY, double salgsPris) {
        initComponents();
        this.produktID.setText(produktID + "");
        this.produktNavnFelt.setText(produktNavn);
        this.produktType.setText(produktType);
        this.produktAntal.setText(produktAntalIDB + "");
        this.maalX.setText(maalX + "");
        this.maalY.setText(maalY + "");
        this.salgsPris.setText(salgsPris + "");
    }

    public JLabel getProduktID() {
        return produktID;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        produktNavnFelt = new javax.swing.JLabel();
        produktID = new javax.swing.JLabel();
        produktType = new javax.swing.JLabel();
        produktAntal = new javax.swing.JLabel();
        maalX = new javax.swing.JLabel();
        maalY = new javax.swing.JLabel();
        salgsPris = new javax.swing.JLabel();

        produktNavnFelt.setText("Navn");

        produktID.setText("Produkt ID");

        produktType.setText("Type");

        produktAntal.setText("Antal");

        maalX.setText("maalX");

        maalY.setText("maalY");

        salgsPris.setText("Pris");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(produktID, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(produktNavnFelt, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(produktType, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(produktAntal, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(maalX, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(maalY, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(salgsPris, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(337, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(produktNavnFelt)
                    .addComponent(produktID)
                    .addComponent(produktType)
                    .addComponent(produktAntal)
                    .addComponent(maalX)
                    .addComponent(maalY)
                    .addComponent(salgsPris))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel maalX;
    private javax.swing.JLabel maalY;
    private javax.swing.JLabel produktAntal;
    private javax.swing.JLabel produktID;
    private javax.swing.JLabel produktNavnFelt;
    private javax.swing.JLabel produktType;
    private javax.swing.JLabel salgsPris;
    // End of variables declaration//GEN-END:variables
}
