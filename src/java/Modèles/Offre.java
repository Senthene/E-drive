/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modèles;

import java.sql.Time;
import java.util.Date;

/**
 *
 * @author Sénthène
 */
// test 3
public class Offre {
    
    private String date;
    private String heureDebut;
    private String heureFin;
    private String etatActuel;
    private int prix;
    
 
    
     public Offre(String d, String hd, String hf, String t, int p){
        date = d;
        heureDebut = hd;
        heureFin = hf;
        etatActuel = t;
        prix =p;
        
    }
     
     public void setPrix(int nouveauPrix){
         prix = nouveauPrix;
       
     }
    
}
