/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BDD;

import Modèles.Utilisateur;
import static com.sun.xml.ws.security.addressing.impl.policy.Constants.logger;
import java.awt.Cursor;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


/**
 *
 * @author Abdelkarim
 * 
 */

public final class UtilisateurBDD {
    
    static private Connection connexion;
    static private Statement instruction = null;
    static private boolean resultat = false;

    SimpleDateFormat formater  = null;
    private int nombreColonnes = 0;
    static private ResultSetMetaData metadata ;

    static public ArrayList<Utilisateur> GenerateUtilisateur(String mail, String passe)
    {
        ArrayList<Utilisateur> returnList = new ArrayList();
        try {
            instruction = Connexion.Connexion();
            if (instruction!=null)
            {
                ResultSet SelectUtilisateur = null;
                SelectUtilisateur = instruction.executeQuery("SELECT * FROM t01_list_utilisateur WHERE T01_EMAIL=\""+mail+"\" AND T01_MDP=\""+passe+"\"");
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
                    int depatement = SelectUtilisateur.getInt("T01_DEPARTEMENT"); 
                    String dateInscription = SelectUtilisateur.getString("T01_DATE_INSCRIPTION");

                    returnList.add(new Utilisateur(email, mdp, type, nom, prenom, dateNaissance, telephone, adresse, codePostal, depatement, dateInscription));
                }
                instruction.close();
                SelectUtilisateur.close();
            }
        } catch (Exception ex) {}
        
        return returnList;
            
    }
    
    static public boolean VérifieEmail(String mail)
    {
        try {
            ResultSet SelectUtilisateur = null;
            instruction = Connexion.Connexion();
            if (instruction!=null)
            {
                SelectUtilisateur = instruction.executeQuery("SELECT COUNT(T01_EMAIL) AS count FROM t01_list_utilisateur WHERE T01_EMAIL=\""+mail+"\"");
                SelectUtilisateur.next();
                if(SelectUtilisateur.getInt("count") == 0) {
                    instruction.close();
                    SelectUtilisateur.close();
                    return true;
                }
                instruction.close();
                SelectUtilisateur.close();
                
            }
        } catch (Exception ex) {}
        return false; 
    }
      
    static public boolean Inscription(String mail, String mdp, String type, String nom, String prenom, String dateNaissance, int tel, String a, int c, int d)
    {
        try {
            instruction = Connexion.Connexion();
            if (instruction!=null)
            {   
                //ResultSet SelectUtilisateur = null;
                SimpleDateFormat formater  = new SimpleDateFormat("dd-MM-yyyy");
                Date aujourdhui = new Date();
                String today = formater.format(aujourdhui);
                //System.out.println("INSERT INTO t01_list_utilisateur(T01_EMAIL, T01_MDP, T01_TYPE, T01_NOM, T01_PRENOM, T01_DATE_NAISSANCE, T01_TELEPHONE, T01_ADRESSE, T01_CODE_POSTALE, T01_DEPARTEMENT, T01_EXPERIENCE, T01_DATE_INSCRIPTION, T01_DATE_MODIF, T01_ISACTIF) VALUES (\""+mail+"\",\""+mdp+"\",\""+type+"\",\""+nom+"\",\""+prenom+"\",\""+dateNaissance+"\",\""+tel+"\",\""+a+"\",\""+c+"\",\""+d+"\",\""+e+"\",\""+today+"\",\""+today+"\",'1')");
                int nbInsert = instruction.executeUpdate("INSERT INTO t01_list_utilisateur(T01_EMAIL, T01_MDP, T01_TYPE, T01_NOM, T01_PRENOM, T01_DATE_NAISSANCE, T01_TELEPHONE, T01_ADRESSE, T01_CODE_POSTALE, T01_DEPARTEMENT, T01_EXPERIENCE, T01_DATE_INSCRIPTION, T01_DATE_MODIF, T01_ISACTIF) VALUES (\""+mail+"\",\""+mdp+"\",\""+type+"\",\""+nom+"\",\""+prenom+"\",\""+dateNaissance+"\",\""+tel+"\",\""+a+"\",\""+c+"\",\""+d+"\", '0', \""+today+"\",\""+today+"\",'1')");
                if (nbInsert==0){
                    return false;
                } 
                instruction.close();
                //SelectUtilisateur.close();
                
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }
    
    static public boolean SuppressionUtilisateur(String mail)
    {
        try {
            instruction = Connexion.Connexion();
            if (instruction!=null)
            { 
                System.out.println("DELETE FROM t01_list_utilisateur WHERE T01_EMAIL=\""+mail+"\"");
                instruction.execute("DELETE FROM t01_list_utilisateur WHERE T01_EMAIL=\""+mail+"\"");

                instruction.close();
                
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }
    
}

