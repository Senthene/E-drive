/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BDD;

import Modèles.Utilisateur;
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
 * 
 */

public final class UtilisateurBDD {
    
    static private Connection connexion;
    static private Statement instruction = null;

    static public ArrayList<Utilisateur> GenerateUtilisateur()
    {
        ArrayList<Utilisateur> returnList = new ArrayList();
        try {
            instruction = Connexion.Connexion();
            if (instruction!=null)
            {
                ResultSet SelectUtilisateur = instruction.executeQuery("SELECT * FROM t01_list_utilisateur");
                while (SelectUtilisateur.next()) 

                {
                    String email = SelectUtilisateur.getString("T01_EMAIL");
                    String mdp = SelectUtilisateur.getString("T01_MDP");
                    String type = SelectUtilisateur.getString("T01_TYPE");
                    String nom = SelectUtilisateur.getString("T01_NOM");
                    String prenom = SelectUtilisateur.getString("T01_PRENOM");
                    String dateNaissance = SelectUtilisateur.getString("T01_DATE_NAISSANCE");
                    int telephone = SelectUtilisateur.getInt("T01_TELEPHONE");
                    String experience = SelectUtilisateur.getString("T01_EXPERIENCE");
                    String adresse = SelectUtilisateur.getString("T01_ADRESSE");
                    int codePostal = SelectUtilisateur.getInt("T01_CODE_POSTALE"); 
                    String depatement = SelectUtilisateur.getString("T01_DEPARTEMENT"); 
                    String dateInscription = SelectUtilisateur.getString("T01_DATE_INSCRIPTION");

                    returnList.add(new Utilisateur(email, mdp, nom, prenom, dateNaissance, telephone, adresse, codePostal, depatement, dateInscription));
                }
                instruction.close();
                connexion.close();
            }
        } catch (Exception ex) {}
        
        return returnList;
            
    }

}
