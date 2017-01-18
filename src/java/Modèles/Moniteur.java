/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modèles;

import BDD.UtilisateurBDD;
import java.util.ArrayList;

/**
 *
 * @author Sénthène
 */
public class Moniteur extends Utilisateur {
    
    
    private Voiture voiture;
    private ArrayList <Offre> offres;

    public Moniteur(String mail, String mdp, String type, String nom, String prenom, String dateNaissance, int tel, String a, int c, int d, String dateInscription, int e, Voiture v, ArrayList <Offre> o) {
        super(mail, mdp, type, nom, prenom, dateNaissance, tel, a, c, d, dateInscription);
       
        voiture = v;
        offres = o;
        experience =e;
    }
        public Moniteur(String mail, String mdp, String type, String nom, String prenom, String dateNaissance, int tel, String a, int c, int d, String dateInscription,int e, Voiture v) {
        super(mail, mdp, type, nom, prenom, dateNaissance, tel, a, c, d, dateInscription);
       
        voiture = v;
        experience = e;
    }
    public Moniteur() {
        
    }
    
    public void ajoutOffre(Offre o){
        offres.add(o);
    }
    
//      public verifiermail(mail) {
//      if ((mail.indexOf("@")>=0)&&(mail.indexOf(".")>=0)) {
//         return true 
//      } else {
//         alert("Mail invalide !");
//         return false
//      }
//   }
        public boolean isEmpty(String chaine) {
        if (chaine==null) return true;
        else return false;
    }
} 

