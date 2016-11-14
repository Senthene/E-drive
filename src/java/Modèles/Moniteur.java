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
    
    private int experience;
    private Voiture voiture;
    private ArrayList <Offre> offres;

    public Moniteur(String mail, String mdp, String type, String nom, String prenom, String dateNaissance, int tel, String a, int c, String d, String dateInscription, int e, Voiture v, ArrayList <Offre> o) {
        super(mail, mdp, type, nom, prenom, dateNaissance, tel, a, c, d, dateInscription);
        experience = e;
        voiture = v;
        offres = o;
    }
    public Moniteur() {
        
    }
    
    public void ajoutOffre(Offre o){
        offres.add(o);
    }
    public boolean inscription(String mail, String mdp1, String type, String nom, String prenom, String dateNaissance, int tel, String a, int c, int d, int e){
//        if(isEmpty(mail) && isEmpty(mdp1) && isEmpty(mdp2) && isEmpty(type) && isEmpty(nom) && isEmpty(prenom) && isEmpty(dateNaissance) && isEmpty(a)){
//                return false;

            UtilisateurBDD.Inscription(mail, mdp1, type, nom, prenom, dateNaissance, tel, a, c, d, e);
            return true;
        
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

