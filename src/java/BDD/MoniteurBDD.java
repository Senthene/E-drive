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
    static private ResultSet SelectMoniteur = null;
    static private ResultSet SelectVoiture = null;
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
                if (dep == 0){
                    SelectMoniteur = instruction.executeQuery("SELECT * FROM t05_list_moniteur WHERE T05_CODEPOSTALE=\""+code+"\"");
                }
                else {
                    SelectMoniteur = instruction.executeQuery("SELECT * FROM t05_list_moniteur WHERE T05_DEPARTEMENT=\""+dep+"\"");
                }
               
                while (SelectMoniteur.next()) 
                    

                {
                    
                    
                    String email = SelectMoniteur.getString("T05_EMAIL");
                    String mdp = SelectMoniteur.getString("T05_MDP");
                    String type = SelectMoniteur.getString("T05_TYPE");
                    String nom = SelectMoniteur.getString("T05_NOM");
                    String prenom = SelectMoniteur.getString("T05_PRENOM");
                    String dateNaissance = SelectMoniteur.getString("T05_DATE_NAISSANCE");
                    int telephone = SelectMoniteur.getInt("T05_TELEPHONE");
                    String adresse = SelectMoniteur.getString("T05_ADRESSE");
                    int codePostal = SelectMoniteur.getInt("T05_CODE_POSTALE"); 
                    String depatement = SelectMoniteur.getString("T05_DEPARTEMENT"); 
                    String dateInscription = SelectMoniteur.getString("T05_DATE_INSCRIPTION");
                    int idVoiture = SelectMoniteur.getInt("T05_ID_VOITURE");
                    
                    // On récupère la voiture du moniteur
                    
                    SelectVoiture = instruction.executeQuery("SELECT * FROM t02_list_voiture WHERE T02_ID_VOITURE=\""+idVoiture+"\"");
                            String marque = SelectVoiture.getString("T02_MARQUE");
                            String modele = SelectVoiture.getString("T02_MODELE");
                            String carburant = SelectVoiture.getString("T02_CARBURANT");
                            Voiture voiture = new Voiture(marque, modele, carburant);
                            
                    returnList.add(new Moniteur(email, mdp, type, nom, prenom, dateNaissance, telephone, adresse, codePostal, depatement, dateInscription, voiture));
                }
                instruction.close();
                SelectMoniteur.close();
            }
        } catch (Exception ex) {}
        
        return returnList;
            
    }
    
}
