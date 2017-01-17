/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BDD;

import Modèles.Moniteur;
import Modèles.Voiture;
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
 * @author Sénthène
 */
public class MoniteurBDD {
    
     static private Connection connexion;
    static private Statement instruction = null;
    static private boolean resultat = false;
       SimpleDateFormat formater  = null;
    private int nombreColonnes = 0;
    static private ResultSetMetaData metadata ;
    
    
     static public ArrayList<Moniteur> rechercheMoniteur (int code, int dep)
    {
        ArrayList<Moniteur> returnList = new ArrayList();
        try {
            instruction = Connexion.Connexion();
            if (instruction!=null)
            {
                ResultSet SelectMoniteur = null;
                if (dep == 0){
                    SelectMoniteur = instruction.executeQuery("SELECT * FROM t01_list_utilisateur LEFT JOIN t02_list_voiture ON T01_EMAIL = T02_EMAIL WHERE T01_CODEPOSTALE=\""+code+"\" AND T01_TYPE = \"Moniteur\" ");
               
                }
                else {
                    SelectMoniteur = instruction.executeQuery("SELECT * FROM t01_list_utilisateur LEFT JOIN t02_list_voiture ON T01_EMAIL = T02_EMAIL WHERE T01_DEPARTEMENT=\""+dep+"\"AND T01_TYPE = \"Moniteur\"");
                }
               
                while (SelectMoniteur.next()) 
                    

                {
                    
                    
                    String email = SelectMoniteur.getString("T01_EMAIL");
                    String mdp = SelectMoniteur.getString("T01_MDP");
                    String type = SelectMoniteur.getString("T01_TYPE");
                    String nom = SelectMoniteur.getString("T01_NOM");
                    String prenom = SelectMoniteur.getString("T01_PRENOM");
                    String dateNaissance = SelectMoniteur.getString("T01_DATE_NAISSANCE");
                    int telephone = SelectMoniteur.getInt("T01_TELEPHONE");
                    String adresse = SelectMoniteur.getString("T01_ADRESSE");
                    int codePostal = SelectMoniteur.getInt("T01_CODE_POSTALE"); 
                    String depatement = SelectMoniteur.getString("T01_DEPARTEMENT"); 
                    String dateInscription = SelectMoniteur.getString("T01_DATE_INSCRIPTION");
                    int experience = SelectMoniteur.getInt("T01_EXPERIENCE");
                    //int idVoiture = SelectMoniteur.getInt("T01_ID_VOITURE");
                    
                    // On récupère la voiture du moniteur
                    
                     Voiture voiture = null;
                  
                           String marque = SelectMoniteur.getString("T02_MARQUE");
                            String modele = SelectMoniteur.getString("T02_MODELE");
                            String carburant = SelectMoniteur.getString("T02_CARBURANT");
                            voiture = new Voiture(marque, modele, carburant);
                            
                    
                            if (voiture !=null) {
                    returnList.add(new Moniteur(email, mdp, type, nom, prenom, dateNaissance, telephone, adresse, codePostal, depatement, dateInscription, experience, voiture));
                            }
                     }
                instruction.close();
                SelectMoniteur.close();
            }
        } catch (Exception ex) {}
        
        return returnList;
            
    }
    
}
