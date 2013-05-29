/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view.ordre;

import java.util.Calendar;
import view.OrdreGUI;

/**
 *
 * @author TheToiletpaper
 */
public class BestillingsOrdreGUI extends javax.swing.JPanel {
    OrdreGUI ordreGUI;
    private Calendar dato;
    private int year;
    private int month;
    private int day;
    
    public BestillingsOrdreGUI(OrdreGUI org) {
        this.ordreGUI = org;
        dato = Calendar.getInstance();
        year = dato.get(Calendar.YEAR);
        month = dato.get(Calendar.MONTH)+1; // Regner fra 0 - 11. Derfor +1
        day = dato.get(Calendar.DAY_OF_MONTH);
        
        initComponents();
        
        jLabel9.setText(day+" / "+month+" / "+year);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox1 = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jCheckBox3 = new javax.swing.JCheckBox();
        jComboBox2 = new javax.swing.JComboBox();
        jTextField2 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea3 = new javax.swing.JTextArea();
        jLabel7 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jTextField3 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jComboBox4 = new javax.swing.JComboBox();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jComboBox5 = new javax.swing.JComboBox();

        setBackground(new java.awt.Color(100, 100, 100));
        setLayout(null);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        add(jComboBox1);
        jComboBox1.setBounds(450, 60, 140, 27);

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Inskription:");
        add(jLabel1);
        jLabel1.setBounds(100, 130, 120, 17);

        jCheckBox3.setBackground(new java.awt.Color(100, 100, 100));
        jCheckBox3.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBox3.setText("Plads til ekstra navn");
        add(jCheckBox3);
        jCheckBox3.setBounds(40, 100, 210, 21);

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        add(jComboBox2);
        jComboBox2.setBounds(160, 310, 140, 27);
        add(jTextField2);
        jTextField2.setBounds(200, 410, 100, 20);

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Pris:");
        add(jLabel2);
        jLabel2.setBounds(40, 410, 100, 17);

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        add(jTextField1);
        jTextField1.setBounds(200, 350, 100, 20);

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Antal bogstaver/timer:");
        add(jLabel4);
        jLabel4.setBounds(40, 350, 150, 17);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextArea1KeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(jTextArea1);

        add(jScrollPane1);
        jScrollPane1.setBounds(40, 150, 262, 140);

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Skrifttype:");
        add(jLabel3);
        jLabel3.setBounds(330, 60, 90, 17);

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Sten:");
        add(jLabel5);
        jLabel5.setBounds(40, 310, 70, 17);

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        add(jComboBox3);
        jComboBox3.setBounds(450, 20, 140, 27);

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Skriftstørrelse:");
        add(jLabel6);
        jLabel6.setBounds(330, 20, 120, 17);

        jTextArea3.setColumns(20);
        jTextArea3.setRows(5);
        jTextArea3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextArea3KeyTyped(evt);
            }
        });
        jScrollPane3.setViewportView(jTextArea3);

        add(jScrollPane3);
        jScrollPane3.setBounds(330, 150, 262, 140);

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Bemærkninger:");
        add(jLabel7);
        jLabel7.setBounds(390, 130, 120, 17);

        jButton1.setText("Opret ordre!");
        add(jButton1);
        jButton1.setBounds(590, 410, 140, 27);
        add(jTextField3);
        jTextField3.setBounds(460, 410, 110, 20);

        jLabel8.setBackground(new java.awt.Color(100, 100, 100));
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Bestillingsdato:");
        add(jLabel8);
        jLabel8.setBounds(330, 380, 120, 17);

        jLabel9.setBackground(new java.awt.Color(100, 100, 100));
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("jLabel9");
        add(jLabel9);
        jLabel9.setBounds(460, 380, 250, 17);

        jLabel10.setBackground(new java.awt.Color(100, 100, 100));
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Leveringsdato:");
        add(jLabel10);
        jLabel10.setBounds(330, 410, 120, 17);

        jLabel11.setBackground(new java.awt.Color(100, 100, 100));
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Rabat:");
        add(jLabel11);
        jLabel11.setBounds(40, 380, 100, 17);
        add(jTextField4);
        jTextField4.setBounds(200, 380, 100, 20);

        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        add(jComboBox4);
        jComboBox4.setBounds(450, 100, 140, 27);

        jLabel12.setBackground(new java.awt.Color(100, 100, 100));
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Skriftstil:");
        add(jLabel12);
        jLabel12.setBounds(330, 100, 110, 17);

        jLabel13.setBackground(new java.awt.Color(100, 100, 100));
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Række:");
        add(jLabel13);
        jLabel13.setBounds(330, 300, 90, 17);

        jLabel14.setBackground(new java.awt.Color(100, 100, 100));
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Nummer:");
        add(jLabel14);
        jLabel14.setBounds(330, 320, 90, 17);

        jLabel15.setBackground(new java.awt.Color(100, 100, 100));
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Afdeling:");
        add(jLabel15);
        jLabel15.setBounds(330, 340, 90, 17);
        add(jTextField5);
        jTextField5.setBounds(460, 300, 110, 20);
        add(jTextField6);
        jTextField6.setBounds(460, 320, 110, 20);
        add(jTextField7);
        jTextField7.setBounds(460, 340, 110, 20);

        jLabel16.setBackground(new java.awt.Color(100, 100, 100));
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Miljøafgift 2,5 %");
        add(jLabel16);
        jLabel16.setBounds(175, 450, 120, 17);

        jLabel17.setBackground(new java.awt.Color(100, 100, 100));
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Ved tilføjelse vælg opgavetype");
        add(jLabel17);
        jLabel17.setBounds(40, 20, 260, 17);

        jLabel18.setBackground(new java.awt.Color(100, 100, 100));
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Opgavetype:");
        add(jLabel18);
        jLabel18.setBounds(40, 50, 110, 17);

        jComboBox5.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        add(jComboBox5);
        jComboBox5.setBounds(180, 50, 120, 27);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed

    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextArea1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextArea1KeyTyped
        String str = jTextArea1.getText();
        str.replace(" ", "");
        str.replace(".", "");
        
        jTextField4.setText((str.length() +1) + "");
    }//GEN-LAST:event_jTextArea1KeyTyped

    private void jTextArea3KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextArea3KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextArea3KeyTyped

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JComboBox jComboBox3;
    private javax.swing.JComboBox jComboBox4;
    private javax.swing.JComboBox jComboBox5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    // End of variables declaration//GEN-END:variables
}
