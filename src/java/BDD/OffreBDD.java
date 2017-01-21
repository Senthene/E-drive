/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BDD;


import Modèles.Moniteur;
import Modèles.Offre;
import Modèles.Utilisateur;
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
 * @author Abdelkarim
 * 
 */

public final class OffreBDD {
    
    static private Connection connexion;
    static private Statement instruction = null;
    static private boolean resultat = false;
      
    SimpleDateFormat formater  = null;
    private int nombreColonnes = 0;
    static private ResultSetMetaData metadata ;

         
    static public boolean AjouterOfrre(String mail, String date, String heureDebut, String heureFin, int c, int p){
    
        try {
            instruction = Connexion.Connexion();
            if (instruction!=null)
            {   

                SimpleDateFormat formater  = new SimpleDateFormat("dd-MM-yyyy");
                Date aujourdhui = new Date();
                String today = formater.format(aujourdhui);
                String s = "Visible";
                //System.out.println("INSERT INTO `t03_offre_moniteur`(`T03_EMAIL`, `T03_DATE_COURS`, `T03_HEURE_DEBUT`, `T03_HEURE_FIN`, `T03_COMMUNE`, `T03_PRIX`, `T03_STATUT`, `T03_DATE_PUBLICATION`, `T03_DATE_MODIF`, `T03_ISACTIF`) VALUES (\""+mail+"\",\""+date+"\",\""+heureDebut+"\",\""+heureFin+"\",\""+c+"\",\""+p+"\",\""+s+"\",\""+today+"\",\""+today+"\",'1')");
                int nbInsert = instruction.executeUpdate("INSERT INTO `t03_offre_moniteur`(`T03_EMAIL`, `T03_DATE_COURS`, `T03_HEURE_DEBUT`, `T03_HEURE_FIN`, `T03_COMMUNE`, `T03_PRIX`, `T03_STATUT`, `T03_DATE_PUBLICATION`, `T03_DATE_MODIF`, `T03_ISACTIF`) VALUES (\""+mail+"\",\""+date+"\",\""+heureDebut+"\",\""+heureFin+"\",\""+c+"\",\""+p+"\",\""+s+"\",\""+today+"\",\""+today+"\",'1')");
                if (nbInsert==0){
                    return false;
                } 
                instruction.close();

                
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }
    
    static public ArrayList<Offre> consultationOffre (String mail) throws SQLException, SQLException
    {
        ArrayList<Offre> returnList = new ArrayList();
        
        try {
            instruction = Connexion.Connexion();
            if (instruction!=null)
                 {
                ResultSet SelectOffre = null;
                
                    SelectOffre = instruction.executeQuery("SELECT * FROM t03_offre_moniteur WHERE  T03_EMAIL = \""+mail+"\"");
               
                        while (SelectOffre.next()) 


                        {
                            String idOffre = SelectOffre.getString("T03_ID_OFFRE_MONITEUR");
                            String dateCours = SelectOffre.getString("T03_DATE_COURS");
                            String heureDebut = SelectOffre.getString("T03_HEURE_DEBUT");
                            String heureFin = SelectOffre.getString("T03_HEURE_FIN");
                            int prix = SelectOffre.getInt("T03_PRIX");
                            String statut = SelectOffre.getString("T03_STATUT");

                               returnList.add(new Offre(dateCours,heureDebut, heureFin, statut, prix ));

                             }
                        instruction.close();
                        SelectOffre.close();

                  }
            
                }
         catch (SQLException ex) {}
        
        return returnList;
            
    }    
}
