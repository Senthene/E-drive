/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BDD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 *
 * @author Abdelkarim
 */
public class Connexion {
    
    static private Connection connexion;
    static private Statement instruction = null;
    
    static public boolean Connexion()
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            connexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/uberpermis", "root", "");
            instruction = connexion.createStatement();
            return true;
        }
        catch (Exception exc)
        {
            javax.swing.JOptionPane.showMessageDialog(null,"Impossible de se connecter au serveur : " + exc);
        }
        return false;
    }
    
}
