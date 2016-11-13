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
    public boolean inscription(String mail, String mdp, String type, String nom, String prenom, String dateNaissance, int tel, String a, int c, String d, String dateInscription, int e){
        if(isEmpty(mail) && isEmpty(mdp) && isEmpty(type) && isEmpty(nom) && isEmpty(prenom) && isEmpty(dateNaissance) && isEmpty(d))
        UtilisateurBDD.Inscription(mail, mdp, type, nom, prenom, dateNaissance, tel, a, c, d, dateInscription, e);
        return true;
    }
        public boolean isEmpty(String chaine) {
        if (chaine==null) return true;
        else return false;
    }
} 

