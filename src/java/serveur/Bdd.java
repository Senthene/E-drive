/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serveur;

import serveur.Utilisateur;
import java.awt.Cursor;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;


/**
 *
 * @author Abdelkarim
 */
public final class Bdd {
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
    
    static public ArrayList<Utilisateur> GenerateUtilisateur()
    {
        ArrayList<Utilisateur> returnList = new ArrayList();
        try {
            if (Connexion())
            {
                ResultSet SelectUtilisateur = instruction.executeQuery("SELECT * FROM utilisateur");
                while (SelectUtilisateur.next()) 

                {
                    int id = SelectUtilisateur.getInt("id");
                    String nom = SelectUtilisateur.getString("nom");
                    String prenom = SelectUtilisateur.getString("prenom");
                    String email = SelectUtilisateur.getString("email");
                    String type = SelectUtilisateur.getString("type");
                    int age = SelectUtilisateur.getInt("age");
                    String experience = SelectUtilisateur.getString("expérience");
                    String adresse = SelectUtilisateur.getString("adresse");
                    String telephone = SelectUtilisateur.getString("telephone");
                    String dateInscription = SelectUtilisateur.getString("dateInscription");

                    //returnList.add(new Utilisateur(id, nom, prenom, email, age, type,experience, telephone, adresse, dateInscription));
                }
                instruction.close();
                connexion.close();
            }
        } catch (Exception ex) {}
        
        return returnList;
            
    }

}
