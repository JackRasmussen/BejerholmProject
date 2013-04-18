/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mathias
 */
public class Handler {
    
    DBConnection conn;

    public Handler(DBConnection conn) {
        this.conn = conn;
    }
    
    public void addPerson(String cpr, String fnavn, String enavn) {
        try{
            conn.execute("insert into hospital.Personer (CprNummer, Fnavn, Enavn) "
                + " values ( '"+ cpr +"', '" + fnavn + "', '" + enavn + "')" ); 
        System.out.println("Added");
        }catch(Exception ex){
            System.out.println(ex);
        }
    }
    
    public void addPatient(String ID, String CPR) {
        try{
            conn.execute("insert into hospital.Patient (ID, fk_CprNummer) "
                + " values ( '"+ ID +"', '" + CPR + "')" ); 
        System.out.println("Added");
        }catch(Exception ex){
            System.out.println(ex);
        }
    }

    
    public String getPersonCPR(String cpr) {
        String info = "";
        String sql = "Select CprNummer, Fnavn, Enavn from Personer where CprNummer='" + cpr + "'";
        System.out.println(sql);
        ResultSet rs;
        try {
            rs = conn.getResult(sql);
            if (rs.next()) {
                info = "Navn: " + rs.getString("Fnavn") + " " + rs.getString("Enavn") + "\nCPR: " + rs.getInt("CprNummer");
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(Handler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return info;
    }
    
    
    public String getPatientInfo(String cpr) {
        String info = "";
        String sql = "Select IndlæggelsesDato, UdskrivelsesDato, fk_TeamNR, fk_SengID, fk_ID, fk_CprNummer ";
        sql = sql + "from Indlæggelse, Patient ";
        sql = sql + "where fk_CprNummer = '" + cpr+"';";
        System.out.println(sql);
        ResultSet rs;
        try {
            rs = conn.getResult(sql);
            if (rs.next()) {
                info = "\nIndlægDato: " +rs.getDate("IndlæggelsesDato") + "\nUdskrivelsesDato: " + rs.getDate("UdskrivelsesDato") + "\nTeamNR: " + rs.getInt("fk_TeamNR") + "\nSengID: " + rs.getInt("fk_sengID") + "\nPatientID: " + rs.getInt("fk_ID");
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(Handler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return info;
    }
    
    
   public void udskrivPatient( String udskrivelsesdato, String indID ) {
        try {
            conn.execute("update hospital.indlæggelse "
                    + " set UdskrivelsesDato = now (), ");
            conn.execute("delete from hospital.indlæggelse " 
                    + " where fk_ID = " + indID);
        } catch (SQLException ex) {
            Logger.getLogger(Handler.class.getName()).log(Level.SEVERE, null, ex);
        }
                
    }
    
 }


