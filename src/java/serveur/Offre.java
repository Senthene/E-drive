/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serveur;

import java.sql.Time;
import java.util.Date;

/**
 *
 * @author Sénthène
 */
public class Offre {
    
    private Date date;
    private Time heureDebut;
    private Time heureFin;
    private etat etatActuel;
    private int prix;
    
    public enum etat { 
        Disponible, 
        PasDisponible, 
        Demandé, 
        Reservé;
    }
    
     public Offre(Date d, Time hd, Time hf, etat t){
        date = d;
        heureDebut = hd;
        heureFin = hf;
        etatActuel = t;
        
    }
     
     public void setPrix(int nouveauPrix){
         prix = nouveauPrix;
       
     }
    
}
